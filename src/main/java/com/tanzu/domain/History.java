package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("histories")
public class History {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private String userId;
    private Long carElectricity;
    private Long homeElectricity;
    private Long num;
    private Long trees;

}
