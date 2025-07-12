package com.e_com.rice.services;

import com.e_com.rice.payload.ProductDTO;
import com.e_com.rice.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProductById(Long productId);

    ProductDTO updateProductImage(long productId, MultipartFile image) throws IOException;
}
