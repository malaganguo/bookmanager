package com.soft1841.book.controller;

import cn.hutool.db.Entity;
import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.dao.TypeDAO;
import com.soft1841.book.entity.Book;
import com.soft1841.book.entity.Type;
import com.soft1841.book.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    private ObservableList<Book> bookData = FXCollections.observableArrayList();

    public ObservableList<Book> getBookData() {
        return bookData;
    }

    public void setBookData(ObservableList<Book> bookData) {
        this.bookData = bookData;
    }

    @FXML
    private ComboBox<Type> bookType;

    @FXML
    private TextField bookName, bookAuthor, bookPrice, bookCover;
    @FXML
    private TextArea bookSummary;

    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();

    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    private List<Entity> entityList = null;

    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            entityList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Entity entity : entityList) {
            Type type = new Type();
            type.setId(entity.getLong("id"));
            type.setTypeName(entity.getStr("type_name"));
            typeData.add(type);
        }
        bookType.setItems(typeData);
        bookType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    typeId = newValue.getId();
                }
        );
    }

    public void addBook() throws Exception {
        String name = bookName.getText();
        String author = bookAuthor.getText();
        String price = bookPrice.getText();
        String cover = bookCover.getText();
        String summary = bookSummary.getText();
        Book book = new Book();
        book.setTypeId(typeId);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(price));
        book.setCover(cover);
        book.setSummary(summary);
        long id = bookDAO.insertBook(book);
        book.setId(id);
        this.getBookData().add(book);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增图书成功!");
        alert.showAndWait();
        Stage stage = (Stage) bookName.getScene().getWindow();
        stage.close();
    }
}
