package com.soft1841.book.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.book.dao.ReaderDAO;
import com.soft1841.book.entity.Reader;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读者DAO的实现类
 */
public class ReaderDAOImpl implements ReaderDAO {
    @Override
    public List<Reader> selectReaders() throws SQLException {
        List<Entity> entityList =  Db.use().query("SELECT * FROM t_reader ");
        List<Reader> readerList = new ArrayList<>();
        for (Entity entity: entityList) {
            readerList.add(convertReader(entity));
        }
        return readerList;
    }

    @Override
    public int deleteById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_reader").set("id", id)
        );
    }

    @Override
    public Long insertReader(Reader reader) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_reader")
                        .set("name", reader.getName())
                        .set("avatar", reader.getAvatar())
                        .set("role", reader.getRole())
                        .set("department", reader.getDepartment())
                        .set("join_date", reader.getJoinDate())
                        .set("email", reader.getEmail())
                        .set("mobile", reader.getMobile())
        );
    }

    @Override
    public int countByRole(String role) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_reader WHERE role = ? ", role).intValue();
    }

    @Override
    public int countByDepartment(String department) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_reader WHERE department = ? ", department).intValue();
    }

    /**
     * 将Entity转换为Reader
     *
     * @param entity
     * @return Reader
     */
    private Reader convertReader(Entity entity) {
        Reader reader = new Reader();
        reader.setId(entity.getLong("id"));
        reader.setName(entity.getStr("name"));
        reader.setAvatar(entity.getStr("avatar"));
        reader.setRole(entity.getStr("role"));
        reader.setDepartment(entity.getStr("department"));
        reader.setEmail(entity.getStr("email"));
        reader.setMobile(entity.getStr("mobile"));
        reader.setJoinDate(entity.getDate("join_date"));
        return reader;
    }
}
