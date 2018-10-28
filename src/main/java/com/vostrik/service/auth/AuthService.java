package com.vostrik.service.auth;

import com.vostrik.exception.AuthServiceException;
import com.vostrik.model.SessionUser;

public interface AuthService {
    SessionUser setUserAuth(String tokenId) throws AuthServiceException;
}
