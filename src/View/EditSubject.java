/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.HocPhan;
import Controller.HocPhanDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author hoan.dx173125
 */
public class EditSubject {

    private ObservableList<String> comboKyHoc = FXCollections.observableArrayList("20171", "20172", "20173", "20181", "20182", "20183", "20191", "20192");
    private ObservableList<String> comboTinChi = FXCollections.observableArrayList("2", "3", "4", "5");
    private HocPhanDAO hpdao = new HocPhanDAO();

    public HocPhan subjectBox(String mssv, String mahp, int status) throws SQLException {
        Stage editBox = new Stage();
        editBox.setWidth(500);
        editBox.setHeight(250);

        HocPhan tmp = new HocPhan();
        VBox root = new VBox();
        root.setPrefWidth(500);
        root.setPrefHeight(250);
        root.getStyleClass().add("pane");
        root.getStylesheets().add("/View/stylesheet.css");
        root.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        HBox hBox = new HBox();
        VBox vBox = new VBox();
        HBox hBox0 = new HBox();
        Label label = new Label();
        JFXTextField txtMaHP = new JFXTextField(mahp);
        txtMaHP.setFocusColor(Color.rgb(255, 48, 48));
        Label lbMaHP = new Label(mahp);

        HBox hBox1 = new HBox();
        Label label0 = new Label();
        JFXTextField txtTenHP = new JFXTextField();
        txtTenHP.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox2 = new HBox();
        Label label1 = new Label();
        JFXComboBox txtKyHoc = new JFXComboBox();
        txtKyHoc.setPrefHeight(50.0);
        txtKyHoc.setPrefWidth(137.0);
        txtKyHoc.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox3 = new HBox();
        Label label2 = new Label();

        VBox vBox0 = new VBox();
        HBox hBox4 = new HBox();
        Label label3 = new Label();

        JFXTextField txtLopHP = new JFXTextField();
        txtLopHP.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox5 = new HBox();
        Label label4 = new Label();

        JFXComboBox txtTinChi = new JFXComboBox();
        txtTinChi.setPrefHeight(50.0);
        txtTinChi.setPrefWidth(137.0);
        txtTinChi.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox6 = new HBox();
        Label label5 = new Label();

        JFXTextField txtDiemQT = new JFXTextField();
        txtDiemQT.setPrefHeight(50.0);
        txtDiemQT.setPrefWidth(137.0);
        txtDiemQT.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox7 = new HBox();
        Label label6 = new Label();

        JFXTextField txtDiemCK = new JFXTextField();
        txtDiemCK.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox8 = new HBox();
        JFXButton btnXacnhan = new JFXButton("Xác Nhận");
        JFXButton btnHuy = new JFXButton("Hủy");

        hBox.setPrefHeight(185.0);
        hBox.setPrefWidth(500.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(263.0);
        vBox.setPrefWidth(250.0);

        hBox0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox0.setPrefHeight(50.0);
        hBox0.setPrefWidth(260.0);

        label.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label.setPrefHeight(30.0);
        label.setPrefWidth(60.0);
        label.setText("Mã HP");

        hBox1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox1.setPrefHeight(50.0);
        hBox1.setPrefWidth(260.0);

        label0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(60.0);
        label0.setText("Tên HP");

        hBox2.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox2.setPrefHeight(50.0);
        hBox2.setPrefWidth(200.0);

        label1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label1.setPrefHeight(30.0);
        label1.setPrefWidth(60.0);
        label1.setText("Kỳ Học");

        hBox3.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox3.setPrefHeight(50.0);
        hBox3.setPrefWidth(260.0);

        vBox.setOpaqueInsets(new Insets(0.0));
        vBox.setPadding(new Insets(0.0, 0.0, 10.0, 20.0));

        vBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox0.setPrefHeight(263.0);
        vBox0.setPrefWidth(250.0);

        hBox4.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox4.setPrefHeight(50.0);
        hBox4.setPrefWidth(260.0);

        label3.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label3.setPrefHeight(30.0);
        label3.setPrefWidth(60.0);
        label3.setText("Lớp HP");

        hBox5.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox5.setPrefHeight(50.0);
        hBox5.setPrefWidth(260.0);

        label4.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label4.setPrefHeight(30.0);
        label4.setPrefWidth(60.0);
        label4.setText("Tín Chỉ");

        hBox6.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox6.setPrefHeight(50.0);
        hBox6.setPrefWidth(200.0);

        label5.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label5.setPrefHeight(30.0);
        label5.setPrefWidth(60.0);
        label5.setText("Điểm QT");

        hBox7.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox7.setPrefHeight(50.0);
        hBox7.setPrefWidth(260.0);

        label6.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label6.setPrefHeight(30.0);
        label6.setPrefWidth(60.0);
        label6.setText("Điểm CK");

        vBox0.setOpaqueInsets(new Insets(0.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 10.0, 20.0));

        hBox8.setAlignment(javafx.geometry.Pos.CENTER);
        hBox8.setPrefHeight(52.0);
        hBox8.setPrefWidth(500.0);
        hBox8.setSpacing(80.0);

        txtKyHoc.setItems(comboKyHoc);
        txtTinChi.setItems(comboTinChi);

        btnXacnhan.setPrefWidth(100);
        btnXacnhan.setPrefHeight(40);
        btnXacnhan.getStyleClass().add("pink-btn");
        btnXacnhan.getStylesheets().add("/View/stylesheet.css");
        btnXacnhan.setFont(new Font("System Bold", 15.0));
        btnXacnhan.setOnMouseClicked(event -> {
            if (!(txtMaHP.getText().equals("") || txtTenHP.getText().equals("") || txtKyHoc.getValue().toString().equals("") || txtLopHP.getText().equals("") || txtTinChi.getValue().toString().equals("") || txtDiemQT.getText().equals("") || txtDiemCK.getText().equals(""))) {
                String[] a = {"0", "0.0", "0.25", "0.5", "0.75",
                    "1", "1.0", "1.25", "1.5", "1.75",
                    "2", "2.0", "2.25", "2.5", "2.75",
                    "3", "3.0", "3.25", "3.5", "3.75",
                    "4", "4.0", "4.25", "4.5", "4.75",
                    "5", "5.0", "5.25", "5.5", "5.75",
                    "6", "6.0", "6.25", "6.5", "6.75",
                    "7", "7.0", "7.25", "7.5", "7.75",
                    "8", "8.0", "8.25", "8.5", "8.75",
                    "9", "9.0", "9.25", "9.5", "9.75",
                    "10", "10.0"};
                tmp.setMaHP(txtMaHP.getText());
                tmp.setTenHP(txtTenHP.getText());
                tmp.setKyHoc((txtKyHoc.getValue().toString()));
                tmp.setLopHP(txtLopHP.getText());
                tmp.setTinChi(txtTinChi.getValue().toString());
                tmp.setDiemQT(txtDiemQT.getText());
                tmp.setDiemCK(txtDiemCK.getText());
                /*
                for (int i = 0; i < 41; i++) {
                    if (txtDiemQT.getText().equals(a[i])) {
                        tmp.setDiemQT(txtDiemQT.getText());
                        break;
                    } else {
                        tmp.setDiemQT("0");
                    }
                }
                for (int i = 0; i < 41; i++) {
                    if (txtDiemCK.getText().equals(a[i])) {
                        tmp.setDiemCK(txtDiemCK.getText());
                        break;
                    } else {
                        tmp.setDiemCK("0");
                    }
                }
                 */
                for (int i = 0; i < 52; i++) {
                    if (!(txtDiemCK.getText().equals(a[i])) && txtDiemQT.getText().equals(a[i])) {
                        tmp.setDiemQT("0");
                        tmp.setDiemCK("0");
                    } else {
                        tmp.setDiemQT(txtDiemQT.getText());
                        tmp.setDiemCK(txtDiemCK.getText());
                        System.out.println((txtDiemCK.getText().equals(a[i])) && txtDiemQT.getText().equals(a[i]));
                        break;
                    }
                }
                System.out.println(txtDiemQT.getText());
                System.out.println(tmp.getDiemQT());
                System.out.println(tmp.getDiemCK());
                editBox.close();
            }
        });

        btnHuy.setPrefWidth(100);
        btnHuy.setPrefHeight(40);
        btnHuy.getStyleClass().add("pink-btn");
        btnHuy.getStylesheets().add("/View/stylesheet.css");
        btnHuy.setFont(new Font("System Bold", 15.0));
        btnHuy.setOnMouseClicked(event -> {
            editBox.close();
        });

        hBox0.getChildren().add(label);
        if (status == 1) {
            txtMaHP.setText(mahp);
            txtTenHP.setText(hpdao.loadInfoSubject(mssv, mahp).getTenHP());
            txtLopHP.setText(hpdao.loadInfoSubject(mssv, mahp).getLopHP());
            hBox0.getChildren().add(txtMaHP);
        } else if (status == 2) {
            txtMaHP.setText("");
            txtTenHP.setText("");
            txtLopHP.setText("");
            txtDiemQT.setText("");
            txtDiemCK.setText("");
            hBox0.getChildren().add(txtMaHP);
        } else {
            hBox0.getChildren().add(lbMaHP);
        }
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(label0);
        hBox1.getChildren().add(txtTenHP);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(label1);
        hBox2.getChildren().add(txtKyHoc);
        vBox.getChildren().add(hBox2);
        hBox3.getChildren().add(label2);
        vBox.getChildren().add(hBox3);
        hBox.getChildren().add(vBox);
        hBox4.getChildren().add(label3);
        hBox4.getChildren().add(txtLopHP);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(label4);
        hBox5.getChildren().add(txtTinChi);
        vBox0.getChildren().add(hBox5);
        hBox6.getChildren().add(label5);
        hBox6.getChildren().add(txtDiemQT);
        vBox0.getChildren().add(hBox6);
        hBox7.getChildren().add(label6);
        hBox7.getChildren().add(txtDiemCK);
        vBox0.getChildren().add(hBox7);
        hBox.getChildren().add(vBox0);
        root.getChildren().add(hBox);
        hBox8.getChildren().add(btnXacnhan);
        hBox8.getChildren().add(btnHuy);
        root.getChildren().add(hBox8);

        Scene scene = new Scene(root);
        editBox.setScene(scene);
        editBox.showAndWait();

        return tmp;
    }
}
