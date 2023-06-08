package com.burakkolay.logservice.business.concretes;

import com.burakkolay.logservice.entities.Log;
import com.burakkolay.logservice.repository.LogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;


@ExtendWith(MockitoExtension.class)
class LogManagerTest {

    @Mock
    private LogRepository repository;

    @InjectMocks
    private LogManager manager;

    @Test
    void add() {
        Log log = new Log("1","burak", LocalDateTime.now(),"add log");
        Mockito.when(repository.save(Mockito.any())).thenReturn(log);
        Log add = manager.add(log);
        Assertions.assertEquals(log,add);
    }

    @Test
    void getAll() {
        Log log1 = new Log("1","burak1", LocalDateTime.now(),"add log1");
        Log log2 = new Log("2","burak2", LocalDateTime.now(),"add log2");
        List<Log> logList = new ArrayList<>();
        logList.add(log1);
        logList.add(log2);
        Mockito.when(repository.findAll()).thenReturn(logList);
        List<Log> all = manager.getAll();
        Assertions.assertEquals(logList,all);
    }

    @Test
    void getById() {
        Log log1 = new Log("1","burak1", LocalDateTime.now(),"add log1");
        Mockito.when(repository.findById("1")).thenReturn(Optional.of(log1));
        Log log2 = manager.getById("1");
        Assertions.assertEquals(log1,log2);
    }

}