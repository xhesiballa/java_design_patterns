package com.xhesiballa.designpatterns.view;

import javafx.scene.Scene;

public interface View {
    Scene getScene();

    void restoreView();
}
