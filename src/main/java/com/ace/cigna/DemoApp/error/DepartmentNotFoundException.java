package com.ace.cigna.DemoApp.error;

public class DepartmentNotFoundException extends Exception{
    public DepartmentNotFoundException(String message){
        super(message);
    }
}
