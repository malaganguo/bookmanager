package com.soft1841.book.service;

/**
 * 数据统计分析服务接口
 */
public interface AnalysisService {
    int getTypesCount();

    int getBooksCount();

    int getReadersCount();

    int getAdminsCount();
}
