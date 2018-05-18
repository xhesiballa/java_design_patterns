package com.xhesiballa.designpatterns.service;

import com.xhesiballa.designpatterns.view.View;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;

public class ViewManagerService {
    private final Set<View> viewSet = new HashSet<>();
    private final Stage stage;

    public ViewManagerService(Stage stage) {
        this.stage = stage;
    }

    public void registerView(View view) {
        viewSet.add(view);
    }

    public void showView(Class viewClass) {
        Optional<View> viewOptional = viewSet.stream().filter(v -> v.getClass().equals(viewClass)).findFirst();
        if (viewOptional.isPresent()) {
            View currentView = viewOptional.get();
            stage.setScene(currentView.getScene());
            stage.show();
        } else {
            throw new UnsupportedOperationException(
                    format("View $s is not registered in the view manager.", viewClass.getName()));
        }
    }
}
