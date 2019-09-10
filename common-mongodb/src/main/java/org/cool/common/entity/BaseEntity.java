package org.cool.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
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
