package View;


import Model.User;
import Controller.UserDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
    
    public static User user;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setWidth(375);
        stage.setHeight(500);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(500);
        anchorPane.setPrefWidth(375);
        anchorPane.getStyleClass().add("pane");
        anchorPane.getStylesheets().add("/View/stylesheet.css");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(52.0);
        vbox.setPrefHeight(500.0);
        vbox.setPrefWidth(280.0);

        InputStream is = Files.newInputStream(Paths.get(("img/login.png")));
        Image img = new Image(is);
        is.close();
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(181.0);
        imageView.setFitWidth(231.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(50.0);
        hbox.setPrefWidth(280.0);

        Label label = new Label();
        label.setAlignment(Pos.BOTTOM_LEFT);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        label.setPrefHeight(50.0);
        label.setPrefWidth(80.0);
        label.setText("User Name :");
        label.setFont(new Font("System Bold", 12.0));

        Label label2 = new Label();
        label2.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        label2.setPrefHeight(37.0);
        label2.setPrefWidth(12.0);
        label2.setText("*");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#ff3030"));
        label2.setVisible(false);

        hbox.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        HBox hbox0 = new HBox();
        hbox0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hbox0.setPrefHeight(50.0);
        hbox0.setPrefWidth(280.0);

        Label label0 = new Label();
        label0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        label0.setPrefHeight(50.0);
        label0.setPrefWidth(80.0);
        label0.setText("Password    : ");
        label0.setFont(new Font("System Bold", 12.0));

        Label label3 = new Label();
        label3.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        label3.setPrefHeight(17.0);
        label3.setPrefWidth(12.0);
        label3.setText("*");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#ff3030"));
        label3.setVisible(false);

        hbox0.setOpaqueInsets(new Insets(0.0));
        hbox0.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        HBox hbox1 = new HBox();
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);
        hbox1.setPrefHeight(100.0);
        hbox1.setPrefWidth(200.0);
        hbox1.setSpacing(30.0);

        JFXTextField txtUsername = new JFXTextField();
        txtUsername.setPrefWidth(173);
        txtUsername.setPrefHeight(55);
        txtUsername.setAlignment(Pos.BOTTOM_LEFT);
        txtUsername.setFocusColor(Color.rgb(255, 48, 48));

        JFXPasswordField txtPassword = new JFXPasswordField();
        txtPassword.setPrefWidth(173);
        txtPassword.setPrefHeight(55);
        txtPassword.setAlignment(Pos.BOTTOM_LEFT);
        txtPassword.setFocusColor(Color.rgb(255, 48, 48));

        user = new User();
        UserDAO userdao = new UserDAO();

        JFXButton btnLogin = new JFXButton("Login");
        btnLogin.setPrefWidth(90);
        btnLogin.setPrefHeight(40);
        btnLogin.getStyleClass().add("pink-btn");
        btnLogin.getStylesheets().add("/View/stylesheet.css");
        btnLogin.setFont(new Font("System Bold", 15.0));
        btnLogin.setOnMouseClicked(event -> {
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText());

            if (txtUsername.getText().equals("")) {
                label2.setVisible(true);
            } else if (txtPassword.getText().equals("")) {
                label3.setVisible(true);
            } else {
                try {
                    if (userdao.check_login(user)) {
                        stage.close();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {

                                try {
                                    if (userdao.isAdmin(user)) {
                                        user.setRoleID(1);
                                        //System.out.println("Day la admin");
                                        new Main().start(new Stage());
                                    } else {
                                        user.setRoleID(0);
                                        //System.out.println("Day ko phai la admin");
                                        new Main().start(new Stage());
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else {
                        txtUsername.setText("");
                        txtPassword.setText("");
                        label2.setVisible(false);
                        label3.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JFXButton btnCancel = new JFXButton("Exit");
        btnCancel.setPrefWidth(90);
        btnCancel.setPrefHeight(40);
        btnCancel.getStyleClass().add("pink-btn");
        btnCancel.getStylesheets().add("/View/stylesheet.css");
        btnCancel.setFont(new Font("System Bold", 15.0));
        btnCancel.setOnMouseClicked(event -> {
            System.exit(0);
        });

        vbox.getChildren().add(imageView);
        hbox.getChildren().add(label);
        hbox.getChildren().add(txtUsername);
        hbox.getChildren().add(label2);
        vbox.getChildren().add(hbox);
        hbox0.getChildren().add(label0);
        hbox0.getChildren().add(txtPassword);
        hbox0.getChildren().add(label3);
        vbox.getChildren().add(hbox0);
        hbox1.getChildren().add(btnLogin);
        hbox1.getChildren().add(btnCancel);
        vbox.getChildren().add(hbox1);
        anchorPane.getChildren().add(vbox);

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

}
