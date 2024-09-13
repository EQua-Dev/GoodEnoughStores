package com.awesomenessstudios.goodenoughstores.repositories;

import com.awesomenessstudios.goodenoughstores.models.Image;
import com.awesomenessstudios.goodenoughstores.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
