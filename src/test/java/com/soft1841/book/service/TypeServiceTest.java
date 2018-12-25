package com.soft1841.book.service;

import com.soft1841.book.entity.Type;
import com.soft1841.book.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;


public class TypeServiceTest {
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    @Test
    public void selectAllTypes() {
        List<Type> typeList = typeService.getAllTypes();
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void getType() {
        System.out.println(typeService.getType(1));
    }

    @Test
    public void addType() {
        Type type = new Type();
        type.setTypeName("测试新类别");
        typeService.addType(type);
    }

    @Test
    public void deleteType() {
        typeService.deleteType(9);
    }
}