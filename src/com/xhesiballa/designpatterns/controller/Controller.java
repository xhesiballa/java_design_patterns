package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.Model;
import com.xhesiballa.designpatterns.view.HelloWorldListener;
import com.xhesiballa.designpatterns.view.View;

public class Controller implements HelloWorldListener {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World!");
    }
}
