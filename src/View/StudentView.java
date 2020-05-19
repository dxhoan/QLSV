/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.SinhVien;
import View.Chart;
import static View.Main.*;
import static View.Login.*;
import View.Info;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentView {

    public StudentView() throws IOException, SQLException {

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(960);
        root.setPrefHeight(540);

        VBox vBox = new VBox();
        Label label = new Label();

        Button btnInfo = new Button();

        FontAwesomeIcon userIcon = new FontAwesomeIcon();
        userIcon.setFill(Color.valueOf("#ff3030"));
        userIcon.setIconName("USER");

        Button btnChart = new Button();
        FontAwesomeIcon chartIcon = new FontAwesomeIcon();
        chartIcon.setFill(Color.valueOf("#ff3030"));
        chartIcon.setIconName("BAR_CHART");

        Button btnChangePassword = new Button();
        FontAwesomeIcon lockIcon = new FontAwesomeIcon();
        lockIcon.setFill(Color.valueOf("#ff3030"));
        lockIcon.setIconName("LOCK");

        Button btnBack = new Button();
        FontAwesomeIcon backIcon = new FontAwesomeIcon();
        backIcon.setFill(Color.valueOf("#ff3030"));
        backIcon.setIconName("SIGN_OUT");

        Button btnExit = new Button();
        FontAwesomeIcon exitIcon = new FontAwesomeIcon();
        exitIcon.setFill(Color.valueOf("#ff3030"));
        exitIcon.setIconName("SIGN_OUT");

        AnchorPane anchorPane = new AnchorPane();
        
        Info info = new Info();
        anchorPane.getChildren().add(info);
        info.setVisible(true);

        Chart chart = new Chart();
        anchorPane.getChildren().add(chart);
        chart.setVisible(false);

        ChangePassword thayDoiMK = new ChangePassword();
        anchorPane.getChildren().add(thayDoiMK);
        thayDoiMK.setVisible(false);

        Label label0 = new Label();

        vBox.setPrefHeight(540.0);
        vBox.setPrefWidth(170.0);
        vBox.setStyle("-fx-border-color: #ff3030; -fx-border-width: 0px 0px 0px 0px;");
        vBox.getStylesheets().add("/View/stylesheet.css");

        InputStream is = Files.newInputStream(Paths.get(("img/icon.jpg")));
        Image img = new Image(is);
        is.close();
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(162.0);
        imageView.setFitWidth(180.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setPrefHeight(12.0);
        label.setPrefWidth(180.0);
        label.setStyle("-fx-background-color: e4e4e4;");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#bfbfbf"));

        btnInfo.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnInfo.setMnemonicParsing(false);
        btnInfo.setPrefHeight(45.0);
        btnInfo.setPrefWidth(180.0);
        btnInfo.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnInfo.getStyleClass().add("menu_button_horizontal");
        btnInfo.getStylesheets().add("/View/stylesheet.css");
        btnInfo.setText("Thông tin");
        btnInfo.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnInfo.setFont(new Font("System Bold", 15.0));
        btnInfo.setGraphic(userIcon);
        btnInfo.setOnMouseClicked(event -> {
            info.setVisible(true);
            chart.setVisible(false);
            thayDoiMK.setVisible(false);
        });

        btnChart.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnChart.setMnemonicParsing(false);
        btnChart.setPrefHeight(45.0);
        btnChart.setPrefWidth(180.0);
        btnChart.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnChart.getStyleClass().add("menu_button_horizontal");
        btnChart.getStylesheets().add("/View/stylesheet.css");
        btnChart.setText("Tổng kết");
        btnChart.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnChart.setFont(new Font("System Bold", 15.0));
        btnChart.setGraphic(chartIcon);
        btnChart.setOnMouseClicked(event -> {
            info.setVisible(false);
            chart.setVisible(true);
            thayDoiMK.setVisible(false);
        });

        btnChangePassword.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnChangePassword.setMnemonicParsing(false);
        btnChangePassword.setPrefHeight(45.0);
        btnChangePassword.setPrefWidth(180.0);
        btnChangePassword.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnChangePassword.getStyleClass().add("menu_button_horizontal");
        btnChangePassword.getStylesheets().add("/View/stylesheet.css");
        btnChangePassword.setText("Thay đổi mật khẩu");
        btnChangePassword.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnChangePassword.setFont(new Font("System Bold", 15.0));
        btnChangePassword.setGraphic(lockIcon);
        btnChangePassword.setOnMouseClicked(event -> {
            info.setVisible(false);
            chart.setVisible(false);
            thayDoiMK.setVisible(true);
        });

        btnBack.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(45.0);
        btnBack.setPrefWidth(180.0);
        btnBack.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnBack.getStyleClass().add("menu_button_horizontal");
        btnBack.getStylesheets().add("/View/stylesheet.css");
        btnBack.setText("Quay lại");
        btnBack.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnBack.setFont(new Font("System Bold", 15.0));
        btnBack.setGraphic(backIcon);
        btnBack.setOnMouseClicked(event -> {
            window.setScene(menuScene);
        });

        btnExit.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(45.0);
        btnExit.setPrefWidth(180.0);
        btnExit.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnExit.getStyleClass().add("menu_button_horizontal");
        btnExit.getStylesheets().add("/View/stylesheet.css");
        btnExit.setText("Thoát");
        btnExit.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnExit.setFont(new Font("System Bold", 15.0));
        btnExit.setGraphic(exitIcon);
        btnExit.setOnMouseClicked(event -> {
            window.close();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    new Login().start(new Stage());
                                } catch (IOException ex) {
                                    Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
        });

        anchorPane.setLayoutX(184.0);
        anchorPane.setPrefHeight(540.0);
        anchorPane.setPrefWidth(780.0);

        label0.setLayoutX(180.0);
        label0.setLayoutY(-1.0);
        label0.setPrefHeight(540.0);
        label0.setPrefWidth(5.0);
        label0.setStyle("-fx-background-color: ff3030;");

        if (user.getRoleID()==1) {
            vBox.getChildren().addAll(imageView, label, btnInfo, btnChart, btnBack);
        } else {
            vBox.getChildren().addAll(imageView, label, btnInfo, btnChart, btnChangePassword, btnExit);
            
        }
        root.getChildren().add(vBox);
        root.getChildren().add(anchorPane);
        root.getChildren().add(label0);

        studentScene = new Scene(root);
        window.setScene(studentScene);
        window.show();
    }
}
