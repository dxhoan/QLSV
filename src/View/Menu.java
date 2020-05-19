/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.Login;
import static View.Main.*;
import Model.SinhVien;
import Model.HocPhan;
import static View.Login.user;
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

public class Menu {

    public static SinhVien sv = new SinhVien();
    public static HocPhan hp = new HocPhan();

    public Menu() throws IOException, SQLException {
        AnchorPane root = new AnchorPane();
        root.setPrefWidth(960);
        root.setPrefHeight(540);

        VBox vBox = new VBox();
        Label label = new Label();
        Button btnHome = new Button();

        FontAwesomeIcon fontAwesomeIcon = new FontAwesomeIcon();
        fontAwesomeIcon.setFill(Color.valueOf("#ff3030"));
        fontAwesomeIcon.setIconName("HOME");

        Button btnChangePassword = new Button();
        FontAwesomeIcon fontAwesomeIcon0 = new FontAwesomeIcon();
        fontAwesomeIcon0.setFill(Color.valueOf("#ff3030"));
        fontAwesomeIcon0.setIconName("LOCK");

        Button btnExit = new Button();
        FontAwesomeIcon fontAwesomeIcon1 = new FontAwesomeIcon();
        fontAwesomeIcon1.setFill(Color.valueOf("#ff3030"));
        fontAwesomeIcon1.setIconName("SIGN_OUT");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setLayoutX(184.0);
        anchorPane.setPrefHeight(540.0);
        anchorPane.setPrefWidth(780.0);

        ListView search = new ListView();
        anchorPane.getChildren().add(search);
        search.setVisible(true);

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

        btnHome.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        btnHome.setMnemonicParsing(false);
        btnHome.setPrefHeight(45.0);
        btnHome.setPrefWidth(180.0);
        btnHome.setStyle("-fx-background-color: ffffff; -fx-border-width: 0px 0px 0px 5px;");
        btnHome.getStyleClass().add("menu_button_horizontal");
        btnHome.getStylesheets().add("/View/stylesheet.css");
        btnHome.setText("Trang chủ");
        btnHome.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        btnHome.setFont(new Font("System Bold", 15.0));
        btnHome.setGraphic(fontAwesomeIcon);
        btnHome.setOnMouseClicked(event -> {
            search.setVisible(true);
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
        btnChangePassword.setGraphic(fontAwesomeIcon0);
        btnChangePassword.setOnMouseClicked(event -> {
            search.setVisible(false);
            thayDoiMK.setVisible(true);
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
        btnExit.setGraphic(fontAwesomeIcon1);
        btnExit.setOnMouseClicked(event -> {
            window.close();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new Login().start(new Stage());
                    } catch (IOException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        });

        label0.setLayoutX(180.0);
        label0.setLayoutY(-1.0);
        label0.setPrefHeight(540.0);
        label0.setPrefWidth(5.0);
        label0.setStyle("-fx-background-color: ff3030;");

        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);
        vBox.getChildren().add(btnHome);
        vBox.getChildren().add(btnChangePassword);
        vBox.getChildren().add(btnExit);
        root.getChildren().add(vBox);
        root.getChildren().add(anchorPane);
        root.getChildren().add(label0);

        menuScene = new Scene(root);
        window.setScene(menuScene);
    }
}
