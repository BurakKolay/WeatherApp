package com.burakkolay.commonpackage.business.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LogDTO {
    private String username;
    private LocalDateTime createDate;
    private String operations;

    public LogDTO(String username, String operations) {
        this.username = username;
        this.createDate = LocalDateTime.now();
        this.operations = operations;
    }
}
