package com.crisoper.demo.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiResponseError {

	private boolean success;
    private int status;
    private List<String> errors;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    public ApiResponseError(boolean success, int status, List<String> errors, String message, String path) {
        this.success = success;
        this.status = status;
        this.errors = errors;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public boolean isSuccess() { return success; }
    public int getStatus() { return status; }
    public List<String> getErrors() { return errors; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
}
