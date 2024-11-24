package com.awesomenessstudios.goodenoughstores.repositories;

import com.awesomenessstudios.goodenoughstores.models.Image;
import com.awesomenessstudios.goodenoughstores.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository  extends JpaRepository<Image, Long> {


    List<Image> findByProductId(Long productId);
}
