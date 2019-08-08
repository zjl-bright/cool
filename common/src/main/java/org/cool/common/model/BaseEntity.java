//package org.cool.common.model;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.hshbao.common.api.model.BaseUser;
//import lombok.Data;
//import lombok.experimental.Accessors;
//
//import java.time.LocalDateTime;
//
///**
// * @Auther: zhaojl@hshbao.com
// * @Date: 2018/12/18
// * @Description:
// * @Version: 1.0
// */
//@Data
//@Accessors(chain = true)
//public class BaseEntity implements BaseUser {
//
//    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;
//
//    @TableField(value = "status", fill = FieldFill.INSERT)
//    private Integer status;
//
//    @TableField(value = "created_at", fill = FieldFill.INSERT)
//    private LocalDateTime createdAt;
//
//    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updatedAt;
//}
