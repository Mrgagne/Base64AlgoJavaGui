package com.example.base64algo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea stringToEncode;
    @FXML
    private TextArea encodedStringBox;
    @FXML
    private Button encodeButton;

    @FXML
    protected void printEncodedString() {
        encodedStringBox.setText(Main.encode(stringToEncode.getText()));
    }
}