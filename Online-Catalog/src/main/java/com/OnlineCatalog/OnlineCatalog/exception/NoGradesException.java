package com.OnlineCatalog.OnlineCatalog.exception;

public class NoGradesException extends Exception {
    public NoGradesException() {
        super("The grades list is empty");
    }
}
