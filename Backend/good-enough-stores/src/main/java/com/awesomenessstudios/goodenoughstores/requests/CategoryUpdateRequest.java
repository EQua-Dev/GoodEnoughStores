package com.awesomenessstudios.goodenoughstores.requests;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private Long id;
    private String name;
}
