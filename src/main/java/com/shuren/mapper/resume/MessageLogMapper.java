package com.shuren.mapper.resume;

import com.shuren.pojo.resume.MessageLog;

public interface MessageLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageLog record);

    int insertSelective(MessageLog record);

    MessageLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageLog record);

    int updateByPrimaryKeyWithBLOBs(MessageLog record);

    int updateByPrimaryKey(MessageLog record);
}