package com.example.springproj6;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FirebaseTest {

    @Test
    public void test() throws IOException, InterruptedException {
        // Login and get authorization token
        String responseBody = authenticate();
        JSONObject resBody = new JSONObject(responseBody);
        String idToken = resBody.getString("idToken");
        String userId = resBody.getString("localId");

        // Upload image to Firebase storage and get file reference out of response
        String fileReference = uploadImage(idToken, userId);

        // Set avatar property in user document
        setCat(idToken, fileReference, userId);

        // Get image reference from avatar property
        String userDetailsResult = getUserDetails(userId, idToken);
        String catReference = new JSONObject(userDetailsResult).getJSONObject("fields").getJSONObject("cat").getString("stringValue");
        String catReferenceUrlEncoded = URLEncoder.encode(catReference, StandardCharsets.UTF_8.toString());

        // Check if file with this reference exists in storage
        String url = String.format("%s/%s?alt=media&token=%s", ApiUrlConstants.FIREBASE_STORAGE_CAT, catReferenceUrlEncoded, System.getenv("CAT_TOKEN"));
        assertEquals(200, HTTPUtil.check(url, idToken));
    }

    public String getUserDetails(String userId, String idToken) throws IOException {
        String url = String.format("%s/%s", ApiUrlConstants.FIRESTORE_DOCUMENT, userId);
        return HTTPUtil.get(url, idToken);
    }

    public void setCat(String idToken, String fileReference, String userId) throws IOException, InterruptedException {
        String url = String.format("%s/%s?updateMask.fieldPaths=cat", ApiUrlConstants.FIRESTORE_DOCUMENT, userId);
        JSONObject data = new JSONObject();
        JSONObject fieldsObject = new JSONObject();
        JSONObject catObject = new JSONObject();
        catObject.put("stringValue", fileReference);
        fieldsObject.put("cat", catObject);
        data.put("fields", fieldsObject);

        HTTPUtil.patch(url, idToken, data.toString());
    }

    public String uploadImage(String idToken, String userId) throws IOException, InterruptedException {
        String url = String.format("%s/%s%%2F%s?alt=media&token=%s", ApiUrlConstants.FIREBASE_STORAGE_CAT, userId, "cat.jpg", System.getenv("CAT_TOKEN"));
        String response = HTTPUtil.uploadFile(url, idToken, "cat.jpg");
        return new JSONObject(response).getString("name");
    }

    public String authenticate() throws IOException, InterruptedException {
        JSONObject data = new JSONObject();
        data.put("email", System.getenv("FIREBASE_EMAIL"));
        data.put("password", System.getenv("FIREBASE_PASSWORD"));
        data.put("returnSecureToken", "true");
        return HTTPUtil.post(ApiUrlConstants.FIREBASE_SIGNIN_EMAIL_AND_PASSWORD.concat(System.getenv("FIREBASE_API_KEY")), data);
    }
}
