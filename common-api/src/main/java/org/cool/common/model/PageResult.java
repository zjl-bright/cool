/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页
 *
 * @author zhaojl@hshbao.com
 * @date 2019-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    /**
     * 页码，从1开始
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

//    /**
//     * 总数
//     */
//    private Integer total;
//
//    /**
//     * 总页数
//     */
//    private Integer pages;

    /**
     * 数据
     */
    private List<T> data;
}
