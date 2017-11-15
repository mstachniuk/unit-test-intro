package com.example;

public class PasswordVerifier {
    public void verify(String password) throws InvalidPasswordException {
        if(password == null) {
            throw new InvalidPasswordException("Password should be NOT null");
        }
        if(password.length() < 9) {
            throw new InvalidPasswordException("Password should be larger than 8 characters");
        }
//        if(!password.matches(".*[A-Z].*")) {
//            throw new InvalidPasswordException("Password should have one uppercase letter at least");
//        }
        if(password.toLowerCase().equals(password)) {
            throw new InvalidPasswordException("Password should have one uppercase letter at least");
        }
    }
}
