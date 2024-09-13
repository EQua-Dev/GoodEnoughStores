package com.awesomenessstudios.goodenoughstores.services.image;

import com.awesomenessstudios.goodenoughstores.dto.ImageDto;
import com.awesomenessstudios.goodenoughstores.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long imageId);
    void deleteImageById(Long imageId);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
