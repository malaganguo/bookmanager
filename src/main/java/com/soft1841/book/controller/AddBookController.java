package com.soft1841.book.controller;

import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.entity.Book;
import com.soft1841.book.entity.Type;
import com.soft1841.book.service.BookService;
import com.soft1841.book.service.TypeService;
import com.soft1841.book.utils.ServiceFactory;
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
    private TextField bookName, bookAuthor, bookPrice, bookCover, bookStock;
    @FXML
    private TextArea bookSummary;

    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private BookService bookService = ServiceFactory.getBookServiceInstance();

    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    private List<Type> typeList = null;

    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeList = typeService.getAllTypes();
        typeData.addAll(typeList);
        bookType.setItems(typeData);
        bookType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    typeId = newValue.getId();
                }
        );
    }

    public void addBook() {
        String name = bookName.getText();
        String author = bookAuthor.getText();
        String price = bookPrice.getText();
        String stock = bookStock.getText();
        String cover = bookCover.getText();
        String summary = bookSummary.getText();
        System.out.println(stock);
        Book book = new Book();
        book.setTypeId(typeId);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(price));
        book.setStock(Integer.parseInt(stock));
        book.setCover(cover);
        book.setSummary(summary);
        long id = bookService.addBook(book);
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
