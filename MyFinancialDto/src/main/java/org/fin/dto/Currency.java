package org.fin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Currency {

    private String code;

    private String num;

    private String name;

    private String country;

    public Currency(String code, String num, String name, String country) {
        this.code = code;
        this.num = num;
        this.name = name;
        this.country = country;
    }
}
