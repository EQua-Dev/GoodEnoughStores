package com.awesomenessstudios.goodenoughstores.dto;

import com.awesomenessstudios.goodenoughstores.models.Category;
import com.awesomenessstudios.goodenoughstores.models.Image;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int stock;
    private String description;
    private Category category;
    private List<ImageDto> images;


}
