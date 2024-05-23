package com.mes.project.ktw.staff.dto;

public class JsonResponse {
    private boolean success;
    private String message;

    public JsonResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResponse [success=" + success + ", message=" + message + ", isSuccess()=" + isSuccess()
				+ ", getMessage()=" + getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
     
}
