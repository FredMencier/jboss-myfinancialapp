package org.fin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Currency {

    private String code;

    private String num;

    private String name;

    private String country;

}
