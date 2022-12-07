package com.example.finalpanaderiacoste.services;

import com.example.finalpanaderiacoste.exceptions.LoginException;

public interface LoginService {

    void login(String user , String password) throws LoginException;
}
