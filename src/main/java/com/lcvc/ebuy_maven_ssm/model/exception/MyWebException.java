package com.lcvc.ebuy_maven_ssm.model.exception;

public class MyWebException extends RuntimeException{
    public MyWebException(){super();}

    public MyWebException(String message){super();}

    public MyWebException(String message,Throwable cause){ super(message, cause);}


    public MyWebException(Throwable cause){ super(cause);}
}
