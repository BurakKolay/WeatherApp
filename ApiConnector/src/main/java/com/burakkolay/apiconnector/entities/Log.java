package com.burakkolay.apiconnector.entities;

import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.UUID;

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
