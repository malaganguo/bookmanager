package com.soft1841.book.dao;

import cn.hutool.db.Entity;
import com.soft1841.book.entity.Reader;
import com.soft1841.book.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ReaderDAOTest {
    //从工厂中获取到ReaderDAO的实例
    private ReaderDAO readerDAO = DAOFactory.getReaderDAOInstance();

    @Test
    public void selectReaders() throws SQLException {
        List<Reader> readerList = readerDAO.selectReaders();
        readerList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void deleteById() throws SQLException {
        readerDAO.deleteById(12);
    }

    @Test
    public void countByRole() throws SQLException {
        int count = readerDAO.countByRole("学生");
        System.out.println(count);
    }

    @Test
    public void countByDepartment() throws SQLException {
        int count = readerDAO.countByDepartment("计算机与软件学院");
        System.out.println(count);
    }

    @Test
    public void countReaders() throws SQLException {
        int count = readerDAO.countReaders();
        System.out.println(count);
    }
}