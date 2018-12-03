package com.soft1841.book.dao;

import cn.hutool.db.Entity;
import com.soft1841.book.entity.Type;
import com.soft1841.book.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOTest {
    //通过DAO工厂获得TypeDAO的实例
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    @Test
    public void insertType() throws SQLException {
        Type type = new Type();
        type.setTypeName("测试类别");
        System.out.println(typeDAO.insertType(type));
    }

    @Test
    public void deleteTypeById() throws SQLException {
        typeDAO.deleteTypeById(7);
    }

    @Test
    public void updateType() throws SQLException {
        Type type = new Type();
        type.setId(9);
        type.setTypeName("小说");
        typeDAO.updateType(type);
    }

    @Test
    public void selectAllTypes() throws SQLException {
        List<Entity> typeList = typeDAO.selectAllTypes();
        typeList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void getTypeById() throws SQLException {
        Entity entity = typeDAO.getTypeById(1);
        System.out.println(entity);
    }
}