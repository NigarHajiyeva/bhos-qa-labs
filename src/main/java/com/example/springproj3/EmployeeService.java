package com.example.springproj3;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EmployeeService {

    public static String createCrud(Employee employee) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("employee").document(employee.getDocumentId()).set(employee);
        return collectionApiFuture.get().getUpdateTime().toString();
    }


    public static Employee getCrud(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("employee").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Employee employee;
        if (document.exists()) {
            employee = document.toObject(Employee.class);
            return employee;
        } else {
            return null;
        }
    }
}
