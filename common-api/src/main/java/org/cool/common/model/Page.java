/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package org.cool.common.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

/**
 * 分页
 *
 * @author zhaojl@hshbao.com
 * @date 2019-09-12
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

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

    public static <T> Page<T> empty(){
        return new Page(0, 0, Collections.emptyList());
    }
}
