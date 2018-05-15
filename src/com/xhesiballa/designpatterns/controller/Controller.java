package com.xhesiballa.designpatterns.controller;

import com.xhesiballa.designpatterns.model.Model;
import com.xhesiballa.designpatterns.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}
