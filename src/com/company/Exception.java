package com.company;

import Elements.Element;

class ExceptionCreate extends RuntimeException {
    public void showTheMessage() {
        System.err.println("It Element will be already create");
    }
}

class ExceptionInput extends RuntimeException {

    private String message;

    public ExceptionInput(String string) {
        this.message = string;
    }

    public void showTheMessage() {
        System.err.println("It`s wrong input!");
    }
}

