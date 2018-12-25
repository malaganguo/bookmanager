package com.soft1841.book.controller;

import cn.hutool.db.Entity;
import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.entity.Book;
import com.soft1841.book.service.BookService;
import com.soft1841.book.utils.DAOFactory;
import com.soft1841.book.utils.ServiceFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewBookController implements Initializable {
    @FXML
    private FlowPane bookPane;

    private List<Book> bookList;

    private BookService bookService = ServiceFactory.getBookServiceInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookList = bookService.getAllBooks();
        showBooks(bookList);
    }

    private void showBooks(List<Book> list) {
        ObservableList<Node> observableList = bookPane.getChildren();
        bookPane.getChildren().removeAll(observableList);
        for (Book book : list) {
            VBox vBox = new VBox();
            vBox.setPrefSize(240, 300);
            vBox.getStyleClass().add("box");
            vBox.setSpacing(10);
            vBox.setAlignment(Pos.CENTER);
            ImageView imageView = new ImageView(new Image(book.getCover()));
            imageView.setFitWidth(100);
            imageView.setFitHeight(120);
            Label nameLabel = new Label(book.getName());
            nameLabel.getStyleClass().add("font-title");
            Label authorLabel = new Label("作者：" + book.getAuthor());
            Label priceLabel = new Label("价格：" + book.getPrice());
            Label stockLabel = new Label("库存：" + book.getStock());
            Button delBtn = new Button("删除");
            delBtn.getStyleClass().add("warning-theme");
            vBox.getChildren().addAll(imageView, nameLabel, authorLabel, priceLabel, stockLabel, delBtn);
            bookPane.getChildren().add(vBox);
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    bookService.deleteBook(book.getId());
                    bookPane.getChildren().remove(vBox);
                }
            });
        }
    }
}
