package com.tanzu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.Message;
import com.tanzu.service.MessageService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
public interface MessageMapper extends BaseMapper<Message>{
    @Select("SELECT mess.id,ui.name,mess.content,mess.time" +
            " FROM messages mess " +
            "INNER JOIN user_mess um ON mess.id = um.mess_id INNER JOIN user_informs ui ON um.user_id = ui.id" +
            " WHERE course_id = #{courseId}")
    List<Message> selectByCourseId(Long courseId);
    @Select("SELECT MAX(id) FROM messages")
    Integer selectMaxId();
}
