/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Login.user;
import Model.User;
import Controller.UserDAO;
import com.jfoenix.controls.JFXPasswordField;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author hoan.dx173125
 */
public class ChangePassword extends AnchorPane {

    public ChangePassword() throws SQLException {
        UserDAO userdao = new UserDAO();

        setPrefHeight(540);
        setPrefWidth(780);

        Button button = new Button();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        Label label = new Label();
        JFXPasswordField jFXPasswordField = new JFXPasswordField();
        jFXPasswordField.setFocusColor(Color.rgb(255, 48, 48));
        HBox hBox0 = new HBox();
        Label label0 = new Label();
        JFXPasswordField jFXPasswordField0 = new JFXPasswordField();
        jFXPasswordField0.setFocusColor(Color.rgb(255, 48, 48));
        Label label1 = new Label();

        button.setLayoutX(254.0);
        button.setLayoutY(306.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(40.0);
        button.setPrefWidth(90.0);
        button.getStyleClass().add("pink-btn");
        button.getStylesheets().add("/View/stylesheet.css");
        button.setText("Xác nhận");
        button.setFont(new Font("System Bold", 12.0));

        vBox.setLayoutX(93.0);
        vBox.setLayoutY(89.0);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(427.0);
        vBox.setSpacing(20.0);

        hBox.setPrefHeight(50.0);
        hBox.setPrefWidth(300.0);
        hBox.setSpacing(20.0);

        label.setPrefHeight(50.0);
        label.setPrefWidth(142.0);
        label.setText("Mật khẩu mới");

        hBox0.setPrefHeight(50.0);
        hBox0.setPrefWidth(300.0);
        hBox0.setSpacing(20.0);

        label0.setPrefHeight(50.0);
        label0.setPrefWidth(143.0);
        label0.setText("Nhập lại mật khẩu");

        label1.setVisible(false);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(153.0);
        label1.setText("Thay đổi thành công");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#08e838"));
        label1.setFont(new Font("System Bold", 12.0));

        userdao.loadUser(user.getUsername());
        button.setOnMouseClicked(event -> {
            if (jFXPasswordField.getText().equals(jFXPasswordField0.getText())) {
                try {
                    userdao.changePassword(user.getUsername(), jFXPasswordField.getText());
                    userdao.loadUser(user.getUsername());
                    label1.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                jFXPasswordField.setText("");
                jFXPasswordField0.setText("");
                JOptionPane.showMessageDialog(null, "Sửa thất bại");
                label1.setVisible(false);
            }

        });

        getChildren().add(button);
        hBox.getChildren().add(label);
        hBox.getChildren().add(jFXPasswordField);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(jFXPasswordField0);
        vBox.getChildren().add(hBox0);
        vBox.getChildren().add(label1);
        getChildren().add(vBox);
    }
}
