/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Main.*;
import static View.Login.*;
import Controller.Database;
import Model.HocPhan;
import Controller.HocPhanDAO;
import Controller.SaveToFile;
import Model.SinhVien;
import Controller.SinhVienDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Info extends AnchorPane {

    private EditStudent eStudent = new EditStudent();
    private EditSubject eSubject = new EditSubject();
    private HocPhanDAO hpdao = new HocPhanDAO();
    private SaveToFile stf = new SaveToFile();
    private SinhVienDAO svdao = new SinhVienDAO();

    public Info() throws IOException, SQLException {
        SinhVien sv = new SinhVien();
        sv.setMSSV(mssv);
        setPrefWidth(780);
        setPrefHeight(540);

        VBox vBox = new VBox();
        HBox hBox = new HBox();

        VBox vBox0 = new VBox();
        HBox hBox0 = new HBox();
        HBox hBox1 = new HBox();
        VBox vBox1 = new VBox();
        Label label0 = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        VBox vBox2 = new VBox();

        VBox vBox3 = new VBox();
        Label label8 = new Label();
        Label label9 = new Label();
        Label label10 = new Label();
        Label label11 = new Label();
        VBox vBox4 = new VBox();
        JFXTextField searchTextField = new JFXTextField();
        Label a = new Label();
        Label b = new Label();
        Label c = new Label();
        Label d = new Label();
        Label e = new Label();
        Label f = new Label();
        Label g = new Label();
        Label h = new Label();
        TableView<HocPhan> tableView = new TableView();
        TableColumn<HocPhan, String> mahpColumn = new TableColumn<>();
        TableColumn<HocPhan, String> tenhpColumn = new TableColumn<>();
        TableColumn<HocPhan, String> kyhocColumn = new TableColumn<>();
        TableColumn<HocPhan, String> tinchiColumn = new TableColumn<>();
        TableColumn<HocPhan, String> lophpColumn = new TableColumn<>();
        TableColumn<HocPhan, String> diemqtColumn = new TableColumn<>();
        TableColumn<HocPhan, String> diemckColumn = new TableColumn<>();
        TableColumn<HocPhan, String> diemchuColumn = new TableColumn<>();

        JFXButton btnEditInfo = new JFXButton("Sửa");
        FontAwesomeIcon editIcon = new FontAwesomeIcon();
        editIcon.setFill(Color.valueOf("#ff3030"));
        editIcon.setIconName("EDIT");

        HBox hBox2 = new HBox();
        Label label16 = new Label();

        FontAwesomeIcon searchIcon = new FontAwesomeIcon();
        searchIcon.setFill(Color.valueOf("#ff3030"));
        searchIcon.setIconName("SEARCH");

        searchTextField.setFocusColor(Color.valueOf("#ff3030"));

        JFXButton btnAdd = new JFXButton("Thêm");
        FontAwesomeIcon addIcon = new FontAwesomeIcon();
        addIcon.setFill(Color.valueOf("#ff3030"));
        addIcon.setIconName("PLUS");

        JFXButton btnEditSubject = new JFXButton("Sửa");

        FontAwesomeIcon editIcon1 = new FontAwesomeIcon();
        editIcon1.setFill(Color.valueOf("#ff3030"));
        editIcon1.setIconName("EDIT");

        JFXButton btnDelete = new JFXButton("Xóa");
        FontAwesomeIcon deleteIcon = new FontAwesomeIcon();
        deleteIcon.setFill(Color.valueOf("#ff3030"));
        deleteIcon.setIconName("MINUS");

        JFXButton btnSave = new JFXButton("Lưu");
        FontAwesomeIcon saveIcon = new FontAwesomeIcon();
        saveIcon.setFill(Color.valueOf("#ff3030"));
        saveIcon.setIconName("SAVE");

        vBox.setPrefHeight(540.0);
        vBox.setPrefWidth(780.0);
        vBox.setSpacing(10.0);

        hBox.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        hBox.setPrefHeight(181.0);
        hBox.setPrefWidth(600.0);
        hBox.setSpacing(20.0);

        if (mssv.equals("20173125") || mssv.equals("20172938")) {
            InputStream is = Files.newInputStream(Paths.get(("img/" + mssv + ".jpg")));
            Image img = new Image(is);
            is.close();
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(165.0);
            imageView.setFitWidth(125.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            hBox.getChildren().add(imageView);
        } else {
            ImageView imageView = new ImageView();
            imageView.setFitHeight(165.0);
            imageView.setFitWidth(125.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            hBox.getChildren().add(imageView);
        }

        vBox0.setPrefHeight(181.0);
        vBox0.setPrefWidth(637.0);

        hBox0.setPrefHeight(36.0);
        hBox0.setPrefWidth(488.0);
        hBox0.setSpacing(5.0);

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(143.0);
        hBox1.setPrefWidth(597.0);
        hBox1.setStyle("-fx-border-color: ff3030; -fx-border-width: 0px 0px 5px 0px;");

        vBox1.setPrefHeight(137.0);
        vBox1.setPrefWidth(110.0);

        label0.setPrefHeight(25.0);
        label0.setPrefWidth(58.0);
        label0.setText("Họ tên :");
        label0.setFont(new Font(12.0));

        label1.setPrefHeight(25.0);
        label1.setPrefWidth(44.0);
        label1.setText("MSSV :");
        label1.setFont(new Font(12.0));

        label2.setPrefHeight(25.0);
        label2.setText("Giới Tính :");
        label2.setFont(new Font(12.0));

        label3.setPrefHeight(25.0);
        label3.setText("Ngày Sinh :");
        label3.setFont(new Font(12.0));

        vBox2.setPrefHeight(137.0);
        vBox2.setPrefWidth(150.0);

        a.setPrefHeight(25.0);
        a.setFont(new Font(12.0));

        b.setPrefHeight(25.0);
        b.setFont(new Font(12.0));

        c.setPrefHeight(25.0);
        c.setFont(new Font(12.0));

        d.setPrefHeight(25.0);
        d.setFont(new Font(12.0));

        vBox3.setPrefHeight(137.0);
        vBox3.setPrefWidth(80.0);

        label8.setPrefHeight(25.0);
        label8.setText("Lớp :");
        label8.setFont(new Font(12.0));

        label9.setPrefHeight(25.0);
        label9.setText("Khóa :");
        label9.setFont(new Font(12.0));

        label10.setPrefHeight(25.0);
        label10.setText("Viện");
        label10.setFont(new Font(12.0));

        label11.setPrefHeight(25.0);
        label11.setPrefWidth(35.0);
        label11.setText("Email :");
        label11.setFont(new Font(12.0));

        vBox4.setPrefHeight(137.0);
        vBox4.setPrefWidth(194.0);

        e.setPrefHeight(25.0);
        e.setFont(new Font(12.0));

        f.setPrefHeight(25.0);
        f.setFont(new Font(12.0));

        g.setPrefHeight(25.0);
        g.setPrefWidth(197.0);
        g.setFont(new Font(12.0));

        h.setPrefHeight(25.0);
        h.setFont(new Font(12.0));

        btnEditInfo.setStyle("-fx-border-width: 0px 0px 3px 0px;");
        btnEditInfo.getStyleClass().add("menu_button_vertical");
        btnEditInfo.getStylesheets().add("/View/stylesheet.css");
        btnEditInfo.setGraphic(editIcon);
        btnEditInfo.setFont(new Font("System Bold", 12.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(53.0);
        hBox2.setPrefWidth(780.0);
        hBox2.setSpacing(15.0);

        label16.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label16.setPrefHeight(30.0);
        label16.setPrefWidth(30.0);

        label16.setGraphic(searchIcon);

        btnAdd.setStyle("-fx-border-width: 0px 0px 3px 0px;");
        btnAdd.getStyleClass().add("menu_button_vertical");
        btnAdd.getStylesheets().add("/View/stylesheet.css");

        btnAdd.setGraphic(addIcon);
        btnAdd.setFont(new Font("System Bold", 12.0));

        btnEditSubject.setStyle("-fx-border-width: 0px 0px 3px 0px;");
        btnEditSubject.getStyleClass().add("menu_button_vertical");
        btnEditSubject.getStylesheets().add("/View/stylesheet.css");
        btnEditSubject.setGraphic(editIcon1);
        btnEditSubject.setFont(new Font("System Bold", 12.0));

        btnDelete.setStyle("-fx-border-width: 0px 0px 3px 0px;");
        btnDelete.getStyleClass().add("menu_button_vertical");
        btnDelete.getStylesheets().add("/View/stylesheet.css");

        btnDelete.setGraphic(deleteIcon);
        btnDelete.setFont(new Font("System Bold", 12.0));

        btnSave.setStyle("-fx-border-width: 0px 0px 3px 0px;");
        btnSave.getStyleClass().add("menu_button_vertical");
        btnSave.getStylesheets().add("/View/stylesheet.css");
        btnSave.setGraphic(saveIcon);
        btnSave.setFont(new Font("System Bold", 12.0));

        tableView.setPrefHeight(300.0);
        tableView.setPrefWidth(780.0);

        mahpColumn.setPrefWidth(75.0);
        mahpColumn.setText("Mã Học Phần");

        tenhpColumn.setPrefWidth(75.0);
        tenhpColumn.setText("Tên Học Phần");

        kyhocColumn.setPrefWidth(75.0);
        kyhocColumn.setText("Kỳ Học");

        tinchiColumn.setPrefWidth(75.0);
        tinchiColumn.setText("Tín Chỉ");

        lophpColumn.setPrefWidth(75.0);
        lophpColumn.setText("Lớp HP");

        diemqtColumn.setPrefWidth(75.0);
        diemqtColumn.setText("Điểmm QT");

        diemckColumn.setPrefWidth(75.0);
        diemckColumn.setText("Điểmm CK");

        diemchuColumn.setPrefWidth(75.0);
        diemchuColumn.setText("Điểm Chữ");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        mahpColumn.setCellValueFactory(new PropertyValueFactory<>("MaHP"));
        tenhpColumn.setCellValueFactory(new PropertyValueFactory<>("TenHP"));
        kyhocColumn.setCellValueFactory(new PropertyValueFactory<>("KyHoc"));
        tinchiColumn.setCellValueFactory(new PropertyValueFactory<>("TinChi"));
        lophpColumn.setCellValueFactory(new PropertyValueFactory<>("LopHP"));
        diemqtColumn.setCellValueFactory(new PropertyValueFactory<>("DiemQT"));
        diemckColumn.setCellValueFactory(new PropertyValueFactory<>("DiemCK"));
        diemchuColumn.setCellValueFactory(new PropertyValueFactory<>("DiemChu"));

        ObservableList<HocPhan> data = FXCollections.observableArrayList();
        svdao.loadInfoToLabel(a, b, c, d, e, f, g, h);
        hpdao.loadSubjectFromDatabase(mssv, data);
        tableView.setItems(data);
        tableView.setRowFactory(tv -> new TableRow<HocPhan>() {
            @Override
            public void updateItem(HocPhan item, boolean wrong) {
                super.updateItem(item, wrong);
                if (item == null) {
                    setStyle("");
                } else if (checkInvalid(item)) {
                    setStyle("-fx-background-color: #ff8a8a;");
                } else {
                    setStyle("");
                }
            }
        });

        btnEditInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SinhVien sinhvien = new SinhVien();
                    sinhvien = eStudent.studentBox(mssv, 0);
                    try {
                        svdao.editStudent(sinhvien, sinhvien.getMSSV());
                        svdao.loadInfoToLabel(a, b, c, d, e, f, g, h);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        searchTextField.setOnKeyReleased(event -> {
            if (searchTextField.getText().equals("")) {
                try {
                    svdao.loadInfoToLabel(a, b, c, d, e, f, g, h);
                    hpdao.loadSubjectFromDatabase(mssv, data);
                } catch (SQLException ex) {
                    Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    hpdao.searchSubject(mssv, data, searchTextField.getText());
                    tableView.setItems(data);
                } catch (SQLException ex) {
                    Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    System.out.println(mssv);
                    HocPhan hocphan = new HocPhan();
                    String mahp = new String();
                    hocphan = eSubject.subjectBox(mssv, mahp, 2);
                    try {
                        if (hpdao.check_mahp(mssv, hocphan.getMaHP())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Thông báo");
                            alert.setHeaderText(null);
                            alert.setContentText("Mã học phần đã bị trùng");
                            alert.showAndWait();
                        } else {
                            hpdao.addSubject(mssv, hocphan);
                            hpdao.loadSubjectFromDatabase(mssv, data);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnEditSubject.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x = tableView.getSelectionModel().getSelectedIndex();

                if (x != -1) {
                    try {
                        HocPhan hocphan = tableView.getItems().get(x);
                        HocPhan hp = new HocPhan();
                        hp = eSubject.subjectBox(mssv, hocphan.getMaHP(), 1);
                        //System.out.println(svdao.count_student());
                        for (int i = 0; i < svdao.count_student(); i++) {
                            if (i != x) {
                                //System.out.println(i);
                                if (!(tableView.getItems().get(i)).getMaHP().equals(sv.getMSSV())) {
                                    //System.out.println((tableView.getItems().get(i)).getMSSV());
                                    try {
                                        hpdao.editSubject(mssv,hocphan.getMaHP(), hp, data);
                                        hpdao.loadSubjectFromDatabase(mssv, data);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Thông báo");
                                    alert.setHeaderText(null);
                                    alert.setContentText("MSSV đã bị trùng");
                                    alert.showAndWait();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tableView.getSelectionModel().getSelectedIndex() != -1) {
                    HocPhan hp = tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
                    try {
                        hpdao.deleteSubject(mssv, hp, data);
                        hpdao.loadSubjectFromDatabase(mssv, data);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btnSave.setOnMouseClicked(event -> {
            stf.saveSubjecToFile(mssv);
        });

        vBox0.getChildren().add(hBox0);
        vBox1.getChildren().addAll(label0, label1, label2, label3);
        hBox1.getChildren().add(vBox1);
        vBox2.getChildren().addAll(a, b, c, d);

        hBox1.getChildren().add(vBox2);
        vBox3.getChildren().addAll(label8, label9, label10, label11);
        hBox1.getChildren().add(vBox3);
        vBox4.getChildren().addAll(e, f, g, h);

        hBox1.getChildren().add(vBox4);
        hBox1.getChildren().add(btnEditInfo);
        vBox0.getChildren().add(hBox1);
        hBox.getChildren().add(vBox0);
        vBox.getChildren().add(hBox);
        if (user.getRoleID() == 1) {
            hBox2.getChildren().addAll(label16, searchTextField, btnAdd, btnEditSubject, btnDelete, btnSave);
        } else {
            btnEditInfo.setVisible(false);
            hBox2.getChildren().addAll(label16, searchTextField, btnSave);
        }
        vBox.getChildren().add(hBox2);
        tableView.getColumns().addAll(mahpColumn, tenhpColumn, kyhocColumn, tinchiColumn, lophpColumn, diemqtColumn, diemckColumn, diemchuColumn);
        vBox.getChildren().add(tableView);
        getChildren().add(vBox);
    }

    public boolean checkInvalid(HocPhan hocphan) {
        if (hocphan.getMaHP().length() != 6) {
            if (hocphan.getDiemChu().equals("F") || hocphan.getDiemChu().equals("NULL")) {
                return true;
            } else {
                return false;
            }
        } else {
            if (hocphan.getDiemChu().equals("F") || hocphan.getDiemChu().equals("NULL")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
