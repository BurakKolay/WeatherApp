package com.burakkolay.logservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    private String id;
    private String username;
    private LocalDateTime createDate;
    private String operations;

}
