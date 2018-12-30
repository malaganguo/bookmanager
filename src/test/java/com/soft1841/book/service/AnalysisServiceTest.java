package com.soft1841.book.service;

import com.soft1841.book.utils.ServiceFactory;
import org.junit.Test;

public class AnalysisServiceTest {
    private AnalysisService analysisService = ServiceFactory.getAnalysisServiceInstance();

    @Test
    public void getTypesCount() {
        int n = analysisService.getTypesCount();
        System.out.println(n);
    }

    @Test
    public void getBooksCount() {
        int n = analysisService.getBooksCount();
        System.out.println(n);
    }

    @Test
    public void getReadersCount() {
        int n = analysisService.getReadersCount();
        System.out.println(n);
    }

    @Test
    public void getAdminsCount() {
        int n = analysisService.getAdminsCount();
        System.out.println(n);
    }


}