/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.SinhVien;
import Model.User;
import View.StudentView;
import static View.Login.user;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author hoan.dx173125
 */
public class Main extends Application {

    public static Stage window;
    public static Scene menuScene;
    public static Scene studentScene;
    public static String mssv;
    public static TableView<SinhVien> sinhvienTableView = new TableView<>();
    public static int rowID;
    public static boolean checkMSSV=true;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setWidth(960);
        window.setHeight(540);

        mssv = new String();
        //System.out.println(mssv);
        if (user.getRoleID() == 1) {
            //System.out.println(1);
            //System.out.println(user.getUsername());
            new Menu();
        } else {
            mssv = user.getUsername();
            //System.out.println(1);
            //System.out.println(user.getUsername());
            new StudentView();
        }

        window.setResizable(true);
        window.setTitle("Quản lý điểm sinh viên");
        window.show();
    }

}
