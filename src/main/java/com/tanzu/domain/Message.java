package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("messages")
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private String userId;
    @TableField(exist = false)
    private String userName;
    private String content;
    @TableField
    private Long  courseId;
    private LocalDateTime time;
}