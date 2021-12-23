package com.example.springproj8;

import com.nimbusds.srp6.SRP6CryptoParams;
import com.nimbusds.srp6.SRP6Exception;
import com.nimbusds.srp6.SRP6ServerSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class Service {
    static String salt = "736255382716635459";
    static String verifier = "9142705015822410786778443658462719508271472485376840179015566472528537277805419827255975609343567739675278686538246514440076698084087651594952214016478182";
    public static SRP6CryptoParams config;
    public static SRP6ServerSession serverSession;

    @PostMapping("/new_session")
    public String new_session(@RequestBody String userID) {
        config = SRP6CryptoParams.getInstance();
        serverSession = new SRP6ServerSession(config);
        BigInteger saltS = new BigInteger(salt);
        BigInteger verifierV = new BigInteger(verifier);
        String serverPublicValue_B = serverSession.step1(userID, saltS, verifierV).toString();
        return serverPublicValue_B;
    }

    @PostMapping("/compute_values")
    public String compute_values(@RequestBody GetValue getValue) {
        try{
            return serverSession.step2(getValue.A, getValue.M1).toString();
        } catch (SRP6Exception e) {
            return "";
        }

    }
}