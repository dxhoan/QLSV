/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Database;
import static View.Main.*;
import Controller.SaveToFile;
import Model.SinhVien;
import Controller.SinhVienDAO;
import View.EditStudent;
import View.EditStudent;
import View.StudentView;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ListView extends AnchorPane {

    private EditStudent eStudent = new EditStudent();
    private SinhVienDAO svdao = new SinhVienDAO();
    private SaveToFile stf = new SaveToFile();

    public ListView() throws SQLException {
        setPrefWidth(780);
        setPrefHeight(540);
        
        SinhVien sinhvien = new SinhVien();

        Pane pane = new Pane();
        VBox vBox = new VBox();
        Label label = new Label();
        HBox hBox = new HBox();
        Label label0 = new Label();
        TextField searchTextField = new TextField();

        TableColumn<SinhVien, String> mssvColumn = new TableColumn<>();
        TableColumn<SinhVien, String> hotenColumn = new TableColumn<>();
        TableColumn<SinhVien, String> gioitinhColumn = new TableColumn<>();
        TableColumn<SinhVien, String> lopColumn = new TableColumn<>();
        TableColumn<SinhVien, String> khoaColumn = new TableColumn<>();
        TableColumn<SinhVien, String> vienColumn = new TableColumn<>();

        FontAwesomeIcon searchIcon = new FontAwesomeIcon();
        searchIcon.setFill(Color.valueOf("#ff3030"));
        searchIcon.setIconName("SEARCH");

        JFXButton btnAdd = new JFXButton("Thêm");
        FontAwesomeIcon addIcon = new FontAwesomeIcon();
        addIcon.setFill(Color.valueOf("#ff3030"));
        addIcon.setIconName("PLUS");

        JFXButton btnEdit = new JFXButton("Sửa");
        FontAwesomeIcon editIcon = new FontAwesomeIcon();
        editIcon.setFill(Color.valueOf("#ff3030"));
        editIcon.setIconName("EDIT");

        JFXButton btnDelete = new JFXButton("Xóa");
        FontAwesomeIcon deleteIcon = new FontAwesomeIcon();
        deleteIcon.setFill(Color.valueOf("#ff3030"));
        deleteIcon.setIconName("CLOSE");

        JFXButton btnSave = new JFXButton("Lưu");
        FontAwesomeIcon saveIcon = new FontAwesomeIcon();
        saveIcon.setFill(Color.valueOf("#ff3030"));
        saveIcon.setIconName("SAVE");

        pane.setPrefHeight(540.0);
        pane.setPrefWidth(780.0);

        vBox.setPrefHeight(540.0);
        vBox.setPrefWidth(780.0);
        vBox.setSpacing(10.0);

        label.setPrefHeight(110.0);
        label.setPrefWidth(780.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(62.0);
        hBox.setPrefWidth(780.0);
        hBox.setSpacing(15.0);

        label0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(30.0);
        label0.setGraphic(searchIcon);

        searchTextField.setPrefHeight(25.0);
        searchTextField.setPrefWidth(154.0);
        searchTextField.setStyle("-fx-border-radius: 20px;");

        btnAdd.setStyle("-fx-border-width: 0px 0px 5px 0px;");
        btnAdd.getStyleClass().add("menu_button_vertical");
        btnAdd.getStylesheets().add("/View/stylesheet.css");
        btnAdd.setGraphic(addIcon);
        btnAdd.setFont(new Font("System Bold", 12.0));

        btnEdit.setStyle("-fx-border-width: 0px 0px 5px 0px;");
        btnEdit.getStyleClass().add("menu_button_vertical");
        btnEdit.getStylesheets().add("/View/stylesheet.css");
        btnEdit.setGraphic(editIcon);
        btnEdit.setFont(new Font("System Bold", 12.0));

        btnDelete.setStyle("-fx-border-width: 0px 0px 5px 0px;");
        btnDelete.getStyleClass().add("menu_button_vertical");
        btnDelete.getStylesheets().add("/View/stylesheet.css");
        btnDelete.setGraphic(deleteIcon);
        btnDelete.setFont(new Font("System Bold", 12.0));

        btnSave.setStyle("-fx-border-width: 0px 0px 5px 0px;");
        btnSave.getStyleClass().add("menu_button_vertical");
        btnSave.getStylesheets().add("/View/stylesheet.css");
        btnSave.setGraphic(saveIcon);
        btnSave.setFont(new Font("System Bold", 12.0));

        sinhvienTableView.setPrefHeight(347.0);
        sinhvienTableView.setPrefWidth(780.0);

        mssvColumn.setPrefWidth(95.0);
        mssvColumn.setText("MSSV");
        hotenColumn.setMinWidth(200.0);
        hotenColumn.setPrefWidth(152.0);
        hotenColumn.setText("Họ Tên");
        gioitinhColumn.setMinWidth(100.0);
        gioitinhColumn.setPrefWidth(115.0);
        gioitinhColumn.setText("Giới Tính");
        lopColumn.setMinWidth(100.0);
        lopColumn.setPrefWidth(87.0);
        lopColumn.setText("Lớp");
        khoaColumn.setMinWidth(36.0);
        khoaColumn.setPrefWidth(112.0);
        khoaColumn.setText("Khóa");
        vienColumn.setMinWidth(150.0);
        vienColumn.setPrefWidth(86.0);
        vienColumn.setText("Viện");
        mssvColumn.setCellValueFactory(new PropertyValueFactory<>("MSSV"));
        hotenColumn.setCellValueFactory(new PropertyValueFactory<>("HoTen"));
        gioitinhColumn.setCellValueFactory(new PropertyValueFactory<>("GioiTinh"));
        lopColumn.setCellValueFactory(new PropertyValueFactory<>("Lop"));
        khoaColumn.setCellValueFactory(new PropertyValueFactory<>("Khoa"));
        vienColumn.setCellValueFactory(new PropertyValueFactory<>("Vien"));
        sinhvienTableView.setRowFactory(tv -> new TableRow<SinhVien>() {
            @Override
            public void updateItem(SinhVien item, boolean wrong) {
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

        //Load dữ liệu
        ObservableList<SinhVien> data = FXCollections.observableArrayList();
        svdao.loadSinhVienFromDatabase(data);
        sinhvienTableView.setItems(data);

        //Xử lý sự kiện
        searchTextField.setOnKeyReleased(e -> {
            try {
                if (searchTextField.getText().equals("")) {
                    //System.out.println(svdao.count_student());
                    svdao.loadSinhVienFromDatabase(data);
                } else {
                    //System.out.println(svdao.count_student());
                    svdao.searchStudent(data, searchTextField.getText());
                    sinhvienTableView.setItems(data);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SinhVien sv1 = new SinhVien();
                    String masv = new String();
                    sv1 = eStudent.studentBox(masv, 2);
                    try {
                        if (svdao.check_mssv(sv1.getMSSV())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Thông báo");
                            alert.setHeaderText(null);
                            alert.setContentText("MSSV đã bị trùng");
                            alert.showAndWait();
                        } else {
                            svdao.addStudent(sv1);
                            svdao.loadSinhVienFromDatabase(data);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println(tableView.getSelectionModel().getSelectedIndex());
                int x = sinhvienTableView.getSelectionModel().getSelectedIndex();
                rowID = x;
                if (x != -1) {
                    try {
                        SinhVien sinhvien = sinhvienTableView.getItems().get(x);
                        mssv = sinhvien.getMSSV();
                        SinhVien sv2 = new SinhVien();
                        sv2 = eStudent.studentBox(mssv, 1);
                        //System.out.println(svdao.count_student());
                        for (int i = 0; i < svdao.count_student(); i++) {
                            if (i != x) {
                                System.out.println(i);
                                System.out.println(x + 100);
                                System.out.println(rowID + 100);

                                if (!(sinhvienTableView.getItems().get(i)).getMSSV().equals(sv2.getMSSV())) {
                                    //System.out.println((tableView.getItems().get(i)).getMSSV());
                                    try {
                                        svdao.editStudent(sv2, sinhvien.getMSSV());
                                        svdao.loadSinhVienFromDatabase(data);
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
                if (sinhvienTableView.getSelectionModel().getSelectedIndex() != -1) {
                    SinhVien sinhvien = sinhvienTableView.getItems().get(sinhvienTableView.getSelectionModel().getSelectedIndex());
                    try {
                        svdao.deleteStudent(sinhvien);
                        svdao.loadSinhVienFromDatabase(data);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btnSave.setOnMouseClicked(event -> {
            stf.saveStudentToFile();
        });

        sinhvienTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(sinhvienTableView.getSelectionModel().getSelectedIndex());
                    try {
                        if (!checkInvalid(sinhvienTableView.getItems().get(sinhvienTableView.getSelectionModel().getSelectedIndex()))) {
                            System.out.print(checkInvalid(sinhvienTableView.getItems().get(sinhvienTableView.getSelectionModel().getSelectedIndex())));
                            mssv = (sinhvienTableView.getItems().get(sinhvienTableView.getSelectionModel().getSelectedIndex())).getMSSV();
                            System.out.println(mssv);
                            new StudentView();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        getChildren().add(pane);
        vBox.getChildren().add(label);
        hBox.getChildren().add(label0);
        hBox.getChildren().add(searchTextField);
        hBox.getChildren().add(btnAdd);
        hBox.getChildren().add(btnEdit);
        hBox.getChildren().add(btnDelete);
        hBox.getChildren().add(btnSave);
        vBox.getChildren().add(hBox);
        sinhvienTableView.getColumns().add(mssvColumn);
        sinhvienTableView.getColumns().add(hotenColumn);
        sinhvienTableView.getColumns().add(gioitinhColumn);
        sinhvienTableView.getColumns().add(lopColumn);
        sinhvienTableView.getColumns().add(khoaColumn);
        sinhvienTableView.getColumns().add(vienColumn);
        vBox.getChildren().add(sinhvienTableView);
        getChildren().add(vBox);
    }

    public boolean checkInvalid(SinhVien sinhvien) {
        if (sinhvien.getMSSV().length() != 8) {
            return true;
        } else {
            return false;
        }
    }
}
