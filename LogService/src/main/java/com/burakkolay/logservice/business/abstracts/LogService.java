package com.burakkolay.logservice.business.abstracts;

import com.burakkolay.logservice.entities.Log;

import java.util.List;

public interface LogService {
    void add(Log log);
    List<Log> getAll();
    Log getById(String id);
    void deleteById(String id);
}
