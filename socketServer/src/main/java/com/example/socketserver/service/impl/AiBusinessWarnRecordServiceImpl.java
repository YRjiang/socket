package com.example.socketserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.socketserver.entity.AiBusinessWarnRecord;
import com.example.socketserver.mapper.AiBusinessWarnRecordMapper;
import com.example.socketserver.service.AiBusinessWarnRecordService;
import org.springframework.stereotype.Service;

/**
 * (AiBusinessWarn)表服务实现类
 *
 * @author makejava
 * @since 2022-08-16 17:37:14
 */
@Service("aiBusinessWarnService")
public class AiBusinessWarnRecordServiceImpl extends ServiceImpl<AiBusinessWarnRecordMapper, AiBusinessWarnRecord>
        implements AiBusinessWarnRecordService {

}
