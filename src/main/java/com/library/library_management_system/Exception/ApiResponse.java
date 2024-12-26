package com.library.library_management_system.Exception;
// Replace with your actual package

public class ApiResponse {
    private String message;
    private int statusCode;

    // Default constructor
    public ApiResponse() {}

    // Constructor with parameters
    public ApiResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

