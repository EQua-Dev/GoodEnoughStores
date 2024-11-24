package com.awesomenessstudios.goodenoughstores.services.product;

import com.awesomenessstudios.goodenoughstores.dto.ProductDto;
import com.awesomenessstudios.goodenoughstores.models.Product;
import com.awesomenessstudios.goodenoughstores.requests.AddProductRequest;
import com.awesomenessstudios.goodenoughstores.requests.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest product);

    Product getProductById(Long id);

    void deleteProductById(Long Id);

    Product updateProduct(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductByCategoryAndBrand(String category, String brand);

    List<Product> getProductByName(String name);

    List<Product> getProductByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
}
