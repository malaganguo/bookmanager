package com.soft1841.book.controller;

import cn.hutool.db.Entity;
import com.soft1841.book.dao.AdminDAO;
import com.soft1841.book.entity.Admin;
import com.soft1841.book.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private ListView<Admin> adminListView;

    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    private ObservableList<Admin> observableList = FXCollections.observableArrayList();

    private List<Admin> adminList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            adminList = adminDAO.selectAdmins();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        observableList.setAll(adminList);
        adminListView.setItems(observableList);
        adminListView.setCellFactory(new Callback<ListView<Admin>, ListCell<Admin>>() {
            @Override
            public ListCell<Admin> call(ListView<Admin> param) {
                return new ListCell<Admin>() {
                    @Override
                    public void updateItem(Admin item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            HBox container = new HBox();
                            container.setSpacing(20);
                            container.getStyleClass().add("box");
                            container.setMouseTransparent(true);
                            ImageView imageView = new ImageView(new Image(item.getAvatar()));
                            imageView.setFitHeight(100);
                            imageView.setFitWidth(100);
                            Label accountLabel = new Label(item.getAccount());
                            Label nameLabel = new Label(item.getName());
                            container.getChildren().addAll(imageView,accountLabel,nameLabel);
                            setGraphic(container);
                        }
                    }
                };
            }
        });
    }

}
