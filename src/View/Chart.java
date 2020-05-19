package View;

import static View.Main.*;
import Controller.Database;
import Model.TongKet;
import Model.TongKet;
import Controller.TongKetDAO;
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
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Chart extends AnchorPane {

    private TongKetDAO tkdao = new TongKetDAO();

    public Chart() throws IOException, SQLException {

        setPrefWidth(780);
        setPrefHeight(540);

        VBox vBox = new VBox();
        HBox hBox = new HBox();
        VBox vBox0 = new VBox();
        HBox hBox0 = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();

        TableView<TongKet> tableView = new TableView();
        TableColumn<TongKet, String> hockyColumn = new TableColumn<>();
        TableColumn<TongKet, String> gpaColumn = new TableColumn<>();
        TableColumn<TongKet, String> cpaColumn = new TableColumn<>();
        CategoryAxis categoryAxis = new CategoryAxis();
        NumberAxis numberAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<String, Number>(categoryAxis, numberAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

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

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setPrefHeight(177.0);
        hBox1.setPrefWidth(637.0);
        hBox1.setStyle("-fx-border-color: ff3030; -fx-border-width: 0px 0px 5px 0px;");

        ObservableList<TongKet> data = FXCollections.observableArrayList();
        tableView.setPrefHeight(135.0);
        tableView.setPrefWidth(300.0);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        tkdao.loadDataFromDatabase(data, series);
                        tableView.setItems(data);
                    } catch (SQLException ex) {
                        Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        hockyColumn.setMinWidth(100.0);
        hockyColumn.setPrefWidth(75.0);
        hockyColumn.setText("Kỳ Học");

        gpaColumn.setMinWidth(100.0);
        gpaColumn.setPrefWidth(75.0);
        gpaColumn.setText("GPA");

        cpaColumn.setMinWidth(100.0);
        cpaColumn.setPrefWidth(75.0);
        cpaColumn.setText("CPA");
        hockyColumn.setCellValueFactory(new PropertyValueFactory<>("KyHoc"));
        gpaColumn.setCellValueFactory(new PropertyValueFactory<>("GPA"));
        cpaColumn.setCellValueFactory(new PropertyValueFactory<>("CPA"));

        tkdao.loadDataFromDatabase(data, series);
        tableView.setItems(data);

        hBox1.setPadding(new Insets(0.0, 0.0, 0.0, 30.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(327.0);
        hBox2.setPrefWidth(780.0);

        numberAxis.setPrefHeight(245.0);
        numberAxis.setPrefWidth(37.0);
        numberAxis.setSide(javafx.geometry.Side.LEFT);
        numberAxis.setUpperBound(4.0);
        lineChart.setPrefHeight(326.0);
        lineChart.setPrefWidth(546.0);
        lineChart.getData().add(series);

        vBox0.getChildren().add(hBox0);
        tableView.getColumns().add(hockyColumn);
        tableView.getColumns().add(gpaColumn);
        tableView.getColumns().add(cpaColumn);
        hBox1.getChildren().add(tableView);
        vBox0.getChildren().add(hBox1);
        hBox.getChildren().add(vBox0);
        vBox.getChildren().add(hBox);
        hBox2.getChildren().add(lineChart);
        vBox.getChildren().add(hBox2);
        getChildren().add(vBox);
    }
}
