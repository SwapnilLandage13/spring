package org.example.Exception;

public class ErrorHandler extends  RuntimeException{
    private static final long serialVersionUID=1L;

    private String message;
    private Integer code;

    public ErrorHandler(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ErrorHandler() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
