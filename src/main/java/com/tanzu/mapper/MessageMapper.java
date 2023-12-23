package com.tanzu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<Message>{
    @Select("SELECT * FROM comments")
    List<Message> selectAllMessage();
    /**
     * 新增一条留言信息
     * @param message
     * @return
     */
    @Insert("INSERT INTO table(id,content,courseId,time)"+
            "VALUES(#{id}, #{content}, #{courseId}, #{time})")
    void insertMessage(Message message);

    @Select("SELECT content FROM table WHERE id = #{id}")
    List<String> selectById(Integer id);

    @Select("SELECT * FROM table WHERE courseId = #{courseId}")
    List<Message> selectByCourseId(Long courseId);

    @Delete("DELETE FROM table WHERE id = #{id}")
    void deleteById(Integer id);
}
