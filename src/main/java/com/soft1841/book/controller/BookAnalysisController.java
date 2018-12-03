package com.soft1841.book.controller;

import cn.hutool.db.Entity;
import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.dao.TypeDAO;
import com.soft1841.book.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BookAnalysisController implements Initializable {
    @FXML
    private StackPane pieChartPane, barChartPane;

    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();

    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPieChart();
        initBarChart();
    }

    private void initPieChart() {
        List<Entity> typeList = null;
        try {
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Entity entity : typeList) {
            try {
                int count = bookDAO.countByType(entity.getLong("id"));
                pieChartData.add(new PieChart.Data(entity.getStr("type_name"), count));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("按图书类别统计饼图");
        pieChartPane.getChildren().add(chart);
    }

    private void initBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("根据类别统计柱形图");
        xAxis.setLabel("图书类别");
        yAxis.setLabel("图书数量");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2018年统计数据");
        List<Entity> typeList = null;
        try {
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Entity entity : typeList) {
            try {
                int count = bookDAO.countByType(entity.getLong("id"));
                series1.getData().add(new XYChart.Data(entity.getStr("type_name"), count));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        bc.getData().addAll(series1);
        barChartPane.getChildren().add(bc);
    }
}
