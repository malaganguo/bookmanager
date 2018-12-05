package com.soft1841.book.dao;

import cn.hutool.db.Entity;
import com.soft1841.book.entity.Book;
import com.soft1841.book.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BookDAOTest {
    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();

    @Test
    public void insertBook() throws SQLException {
        Book book = new Book();
        book.setTypeId(1);
        book.setName("测试书籍");
        book.setAuthor("匿名");
        book.setCover("https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2511831665.jpg");
        book.setPrice(68.8);
        book.setSummary("测试书籍摘要测试书籍摘要测试书籍摘要测试书籍摘要测试书籍摘要");
        book.setStock(100);
        System.out.println(bookDAO.insertBook(book));
    }

    @Test
    public void deleteBookById() throws SQLException {
        bookDAO.deleteBookById(40);
    }

    @Test
    public void updateBook() throws SQLException {
        Book book = new Book();
        book.setId(40);
        book.setPrice(11.1);
        book.setStock(99);
        bookDAO.updateBook(book);
    }

    @Test
    public void selectAllBooks() throws SQLException {
        List<Entity> bookList = bookDAO.selectAllBooks();
        bookList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getBookById() throws SQLException {
        Entity entity = bookDAO.getBookById(1);
        System.out.println(entity);
    }

    @Test
    public void selectBooksLike() throws SQLException {
        List<Entity> bookList = bookDAO.selectBooksLike("少");
        bookList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void selectBooksByTypeId() throws SQLException {
        List<Entity> bookList = bookDAO.selectBooksByTypeId(1);
        bookList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void countByType() throws SQLException {
        int n = bookDAO.countByType(1);
        System.out.println(n);
    }
}