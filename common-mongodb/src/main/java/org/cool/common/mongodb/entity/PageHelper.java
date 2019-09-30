/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.mongodb.entity;

import org.cool.common.model.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Demo class
 *
 * @author zhaojl@hshbao.com
 * @date 2019-09-12
 */
public class PageHelper<T extends BaseEntity> {

    private MongoTemplate mongoTemplate;

    private Class<T> tClass;

    public PageHelper(MongoTemplate mongoTemplate, Class<T> tClass){
        this.mongoTemplate = mongoTemplate;
        this.tClass = tClass;
    }

    public static PageHelper getInstance(MongoTemplate mongoTemplate, Class tClass){
        return new PageHelper(mongoTemplate, tClass);
    }


    public Page<T> page(Criteria criteria, Integer pageSize, Integer pageNum){
        if (pageNum <= 0) {
            pageNum = 1;
        }
        int skip = pageSize * (pageNum - 1);
        Query query = Query.query(criteria).skip(skip).limit(pageSize);
        List<T> list = mongoTemplate.find(query, tClass);

        return new Page(pageNum, pageSize, list);

    }

    public Page<T> page(Criteria criteria, Sort sort, Integer pageSize, Integer pageNum){
        if (pageNum <= 0) {
            pageNum = 1;
        }
        int skip = pageSize * (pageNum - 1);
        Query query = Query.query(criteria).with(sort).skip(skip).limit(pageSize);
        List<T> list = mongoTemplate.find(query, tClass);
        return new Page(pageNum, pageSize, list);

    }

}