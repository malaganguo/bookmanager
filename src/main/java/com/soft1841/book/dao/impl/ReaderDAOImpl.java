package com.soft1841.book.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.book.dao.ReaderDAO;
import com.soft1841.book.entity.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * 读者DAO的实现类
 */
public class ReaderDAOImpl implements ReaderDAO {
    @Override
    public List<Entity> selectReaders() throws SQLException {
        return Db.use().query("SELECT * FROM t_reader ");
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
                        .set("avatar",reader.getAvatar())
                        .set("role",reader.getRole())
                        .set("department",reader.getDepartment())
                        .set("join_date",reader.getJoinDate())
                        .set("email",reader.getEmail())
                        .set("mobile",reader.getMobile())
        );
    }
}
