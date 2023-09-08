package com.example.socketserver.service;

import com.example.socketserver.entity.AiBusinessWarnRecord;

import java.util.List;

public interface AlarmPlatformService {

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    List<AiBusinessWarnRecord> getList(String date);
}
