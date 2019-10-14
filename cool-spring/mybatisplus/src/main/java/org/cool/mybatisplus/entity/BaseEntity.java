/*
 * Copyright (c) 2019~2021. zjl. All rights reserved.
 */
package org.cool.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cool.mybatisplus.BaseUser;

import java.time.LocalDateTime;

/**
 * @Auther: zhaojl@hshbao.com
 * @Date: 2018/12/18
 * @Description:
 * @Version: 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity implements BaseUser {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
