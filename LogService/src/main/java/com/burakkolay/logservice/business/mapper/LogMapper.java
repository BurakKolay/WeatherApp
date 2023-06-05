package com.burakkolay.logservice.business.mapper;

import com.burakkolay.commonpackage.business.dto.response.LogDTO;
import com.burakkolay.logservice.entities.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LogMapper {

    public Log toLog(LogDTO dto){
        Log logs = new Log();
        logs.setCreateDate(dto.getCreateDate());
        logs.setUsername(dto.getUsername());
        logs.setOperations(dto.getOperations());
        logs.setId(UUID.randomUUID().toString());
        return logs;
    }
}
