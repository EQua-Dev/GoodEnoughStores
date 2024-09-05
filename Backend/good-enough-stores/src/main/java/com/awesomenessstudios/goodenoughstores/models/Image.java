package com.awesomenessstudios.goodenoughstores.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;

    @Lob
    private Blob image;
    private String downloadURL;

    // Table Relationships

    @ManyToOne //many images belong to one product
    @JoinColumn(name = "product_id") //should replace the column with the details of the product with the id
    private Product product;
}
