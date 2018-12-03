package com.soft1841.book.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.book.dao.TypeDAO;
import com.soft1841.book.entity.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {

    @Override
    public Long insertType(Type type) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_type")
                        .set("type_name", type.getTypeName())
        );
    }

    @Override
    public int deleteTypeById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_type").set("id", id)
        );
    }

    @Override
    public int updateType(Type type) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_name", type.getTypeName()), //修改的数据
                Entity.create("t_type").set("id", type.getId()) //删除的where条件
        );
    }

    @Override
    public List<Entity> selectAllTypes() throws SQLException {
        //采用默认的查询
//        return Db.use().findAll("t_type");
        //采用自定义查询语句查询
        return Db.use().query("SELECT * FROM t_type ");
    }

    @Override
    public Entity getTypeById(int id) throws SQLException {
        //采用自定义带参查询语句，返回单个实体
        return Db.use().queryOne("SELECT * FROM t_type WHERE id = ? ", id);
    }
}
