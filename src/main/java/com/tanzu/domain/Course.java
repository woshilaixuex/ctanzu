package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("courses")
public class Course {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("course_name")
    private String courseName;
    @TableField("video_url")
    private String videoUrl;
    @TableField("image_url")
    private String imageUrl;
    private String origin;
    @TableField("sub_name")
    private String subName;
    @TableField(exist = false)
    private List<Message> messages;
}
