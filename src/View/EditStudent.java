/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Main.*;
import Model.SinhVien;
import Controller.SinhVienDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
public class EditStudent {

    private ObservableList<String> comboGioiTinh = FXCollections.observableArrayList("Nam", "Nữ");
    private ObservableList<String> comboKhoa = FXCollections.observableArrayList("59", "60", "61", "62", "63", "64");
    private ObservableList<String> comboVien = FXCollections.observableArrayList("Viện CNTT và TT", "Viện Điện", "Viện KT và QL", "Viện TUD và TH", "Viện ĐTVT", "Viện KHMT", "Viện Cơ Khí");
    private SinhVienDAO svdao = new SinhVienDAO();

    public SinhVien studentBox(String mssv, int status) throws SQLException {
        Stage editBox = new Stage();
        editBox.setWidth(500);
        editBox.setHeight(250);

        SinhVien temp = new SinhVien();
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
        JFXTextField txtHoten = new JFXTextField();
        txtHoten.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox1 = new HBox();
        Label label0 = new Label();
        JFXTextField txtMSSV = new JFXTextField(mssv);
        txtMSSV.setFocusColor(Color.rgb(255, 48, 48));
        Label lbMSSV = new Label(mssv);

        HBox hBox2 = new HBox();
        Label label1 = new Label();
        JFXComboBox txtGioiTinh = new JFXComboBox();
        txtGioiTinh.setPrefHeight(50.0);
        txtGioiTinh.setPrefWidth(137.0);
        txtGioiTinh.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox3 = new HBox();
        Label label2 = new Label();

        JFXTextField txtNgaySinh = new JFXTextField();
        txtNgaySinh.setFocusColor(Color.rgb(255, 48, 48));

        VBox vBox0 = new VBox();
        HBox hBox4 = new HBox();
        Label label3 = new Label();

        JFXTextField txtLop = new JFXTextField();
        txtLop.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox5 = new HBox();
        Label label4 = new Label();

        JFXComboBox txtKhoa = new JFXComboBox();
        txtKhoa.setPrefHeight(50.0);
        txtKhoa.setPrefWidth(137.0);
        txtKhoa.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox6 = new HBox();
        Label label5 = new Label();

        JFXComboBox txtVien = new JFXComboBox();
        txtVien.setPrefHeight(50.0);
        txtVien.setPrefWidth(137.0);
        txtVien.setFocusColor(Color.rgb(255, 48, 48));

        HBox hBox7 = new HBox();
        Label label6 = new Label();

        JFXTextField txtEmail = new JFXTextField();
        txtEmail.setFocusColor(Color.rgb(255, 48, 48));

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
        label.setText("Họ Tên");

        hBox1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox1.setPrefHeight(50.0);
        hBox1.setPrefWidth(260.0);

        label0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(60.0);
        label0.setText("MSSV");

        hBox2.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox2.setPrefHeight(50.0);
        hBox2.setPrefWidth(200.0);

        label1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label1.setPrefHeight(30.0);
        label1.setPrefWidth(60.0);
        label1.setText("Giới Tính");

        hBox3.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox3.setPrefHeight(50.0);
        hBox3.setPrefWidth(260.0);

        label2.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label2.setPrefHeight(30.0);
        label2.setPrefWidth(60.0);
        label2.setText("Ngày sinh");

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
        label3.setText("Lớp");

        hBox5.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox5.setPrefHeight(50.0);
        hBox5.setPrefWidth(260.0);

        label4.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label4.setPrefHeight(30.0);
        label4.setPrefWidth(60.0);
        label4.setText("Khóa");

        hBox6.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox6.setPrefHeight(50.0);
        hBox6.setPrefWidth(200.0);

        label5.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label5.setPrefHeight(30.0);
        label5.setPrefWidth(60.0);
        label5.setText("Viện");

        hBox7.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox7.setPrefHeight(50.0);
        hBox7.setPrefWidth(260.0);

        label6.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label6.setPrefHeight(30.0);
        label6.setPrefWidth(60.0);
        label6.setText("Email");

        vBox0.setOpaqueInsets(new Insets(0.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 10.0, 20.0));

        hBox8.setAlignment(javafx.geometry.Pos.CENTER);
        hBox8.setPrefHeight(52.0);
        hBox8.setPrefWidth(500.0);
        hBox8.setSpacing(80.0);

        txtGioiTinh.setItems(comboGioiTinh);
        txtGioiTinh.setValue("Nam");
        txtKhoa.setValue("59");
        txtKhoa.setItems(comboKhoa);
        txtVien.setValue("Viện CNTT và TT");
        txtVien.setItems(comboVien);

        btnXacnhan.setPrefWidth(100);
        btnXacnhan.setPrefHeight(40);
        btnXacnhan.getStyleClass().add("pink-btn");
        btnXacnhan.getStylesheets().add("/View/stylesheet.css");
        btnXacnhan.setFont(new Font("System Bold", 15.0));
        btnXacnhan.setOnMouseClicked(event -> {
            if (!(txtMSSV.getText().equals("") || txtHoten.getText().equals("") || txtGioiTinh.getValue().toString().equals("") || txtNgaySinh.getText().equals("")
                    || txtLop.getText().equals("") || txtKhoa.getValue().toString().equals("") || txtVien.getValue().toString().equals("") || txtEmail.getText().equals(""))) {
                temp.setMSSV(txtMSSV.getText());
                temp.setHoTen(txtHoten.getText());
                temp.setGioiTinh(txtGioiTinh.getValue().toString());
                temp.setNgaySinh(txtNgaySinh.getText());
                temp.setLop(txtLop.getText());
                temp.setKhoa(txtKhoa.getValue().toString());
                temp.setVien(txtVien.getValue().toString());
                temp.setEmail(txtEmail.getText());
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
        hBox0.getChildren().add(txtHoten);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(label0);
        if (status == 1) {
            txtHoten.setText(svdao.loadInfoStudent(mssv).getHoTen());
            txtMSSV.setText(mssv);
            txtNgaySinh.setText(svdao.loadInfoStudent(mssv).getNgaySinh());
            txtLop.setText(svdao.loadInfoStudent(mssv).getLop());
            txtEmail.setText(svdao.loadInfoStudent(mssv).getEmail());
            hBox1.getChildren().add(txtMSSV);
        } else if (status == 2) {
            txtHoten.setText("");
            txtHoten.setText("");
            txtMSSV.setText("");
            txtNgaySinh.setText("");
            txtLop.setText("");
            txtEmail.setText("");
            hBox1.getChildren().add(txtMSSV);
        } else {
            txtHoten.setText(svdao.loadInfoStudent(mssv).getHoTen());
            txtMSSV.setText(mssv);
            txtNgaySinh.setText(svdao.loadInfoStudent(mssv).getNgaySinh());
            txtLop.setText(svdao.loadInfoStudent(mssv).getLop());
            txtEmail.setText(svdao.loadInfoStudent(mssv).getEmail());
            hBox1.getChildren().add(lbMSSV);
        }
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(label1);
        hBox2.getChildren().add(txtGioiTinh);
        vBox.getChildren().add(hBox2);
        hBox3.getChildren().add(label2);
        hBox3.getChildren().add(txtNgaySinh);
        vBox.getChildren().add(hBox3);
        hBox.getChildren().add(vBox);
        hBox4.getChildren().add(label3);
        hBox4.getChildren().add(txtLop);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(label4);
        hBox5.getChildren().add(txtKhoa);
        vBox0.getChildren().add(hBox5);
        hBox6.getChildren().add(label5);
        hBox6.getChildren().add(txtVien);
        vBox0.getChildren().add(hBox6);
        hBox7.getChildren().add(label6);
        hBox7.getChildren().add(txtEmail);
        vBox0.getChildren().add(hBox7);
        hBox.getChildren().add(vBox0);
        root.getChildren().add(hBox);
        hBox8.getChildren().add(btnXacnhan);
        hBox8.getChildren().add(btnHuy);
        root.getChildren().add(hBox8);

        Scene scene = new Scene(root);
        editBox.setScene(scene);
        editBox.showAndWait();

        return temp;
    }
}
