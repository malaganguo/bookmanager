package com.soft1841.book.dao;

import cn.hutool.db.Entity;
import com.soft1841.book.entity.Reader;

import java.sql.SQLException;
import java.util.List;

/**
 * 读者的DAO接口
 */
public interface ReaderDAO {
    /**
     * 查询所有读者信息
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> selectReaders()throws SQLException;

    /**
     * 根据id删除实体
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(long id) throws SQLException;

    /**
     * 新增一个读者，返回自增主键
     * @param reader
     * @return
     * @throws SQLException
     */
    Long insertReader(Reader reader) throws SQLException;
}
