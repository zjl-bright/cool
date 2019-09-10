/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */
//package org.cool.common.handler;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;

//@Component
//public class MyMetaObjectHandler implements MetaObjectHandler {
//
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        //新增填充
//        setFieldValByName("status", 1, metaObject);
//        setFieldValByName("createdAt", LocalDateTime.now(), metaObject);
//        setFieldValByName("updatedAt", LocalDateTime.now(), metaObject);
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        //更新填充
//        setFieldValByName("updatedAt", LocalDateTime.now(), metaObject);
//    }
//}
//
