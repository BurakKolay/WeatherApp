package com.burakkolay.apiconnector.business.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetWeatherDTO {
    private String cod;
    private LinkedList<List> list;

    @Getter
    @Setter
    private static class List{
        private Main main;
        private String dt_txt;
    }

    @Getter
    @Setter
    private static class Main{
        private double temp;
        private double temp_min;
        private double temp_max;
    }
}
