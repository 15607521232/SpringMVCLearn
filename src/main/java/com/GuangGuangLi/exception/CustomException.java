package com.GuangGuangLi.exception;


/**
 * 系统自定义异常类，针对预期的异常，需要在程序中抛出此类的异常
 */
public class CustomException  extends Exception{

    public String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(String message){
        super(message);
        this.message = message;
    }
}
