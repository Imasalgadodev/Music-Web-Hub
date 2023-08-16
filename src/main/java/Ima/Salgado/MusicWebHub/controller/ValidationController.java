package Ima.Salgado.MusicWebHub.controller;


public abstract class ValidationController {
    protected  boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    protected boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{9}$";
        return phoneNumber.matches(phoneRegex);
    }
}
