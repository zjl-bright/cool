/*
 * Copyright (c) 2019. zjl. All rights reserved.
 */

package com.hsb.cool.spring.mongodb;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 领域对象公共属性
 *
 * @Auther: zjl
 * @Date: 2019-09-30
 * @Version: 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    @Id
    private String id;

    /**
     * 状态(-1, 0, 1)
     */
    private Integer status;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 最后一次更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次更新时间
     */
    private LocalDateTime updateTime;
}
