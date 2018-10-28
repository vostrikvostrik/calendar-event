package com.vostrik.service.auth.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.vostrik.exception.AuthServiceException;
import com.vostrik.model.SessionUser;
import com.vostrik.service.auth.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service("authService")
public class GoogleAuthService implements AuthService {

    private static final String CLIENT_ID = "447376838568-pv0rgse1c647bv4t5b1q97hvnjmr7t4o.apps.googleusercontent.com";

    private final Logger logger = LoggerFactory.getLogger(GoogleAuthService.class);

    @Override
    public SessionUser setUserAuth(String tokenId) throws AuthServiceException {
        SessionUser sessionUser = new SessionUser();
        HttpTransport transport = new ApacheHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();
        GoogleIdToken idToken = null;
        for (int i = 0; i < 10; ++i) {
            try {
                idToken = verifier.verify(tokenId);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
        sessionUser.setName((String) payload.get("name"));
            sessionUser.setEmail(payload.getEmail());
            sessionUser.setId(payload.getSubject());
            logger.debug(sessionUser.toString());

        } else {
            logger.debug("Invalid ID token.");
            throw new AuthServiceException("Invalid ID token.");
        }
        return sessionUser;
    }
}
