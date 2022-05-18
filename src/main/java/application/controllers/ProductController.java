package application.controllers;

import application.dtos.ProductDTO;
import application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static application.util.FormatterUtil.toMap;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public Object getAllProducts(@RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
                                 @RequestParam(required = false, name = "limit", defaultValue = "10") Integer limit){
        return toMap("products",productService.getProducts(page, limit));
    }

    @PostMapping()
    public Object addProduct(@Validated @RequestBody ProductDTO productDTO){
        return toMap("product", productService.addProduct(productDTO.toEntity()));
    }

    @PutMapping("/{product_id}")
    public Object updateProduct(@PathVariable(name = "product_id") Long productId, @RequestBody ProductDTO productDTO){
        return toMap("updated_product", productService.updateProduct(productId, productDTO.toEntity()));
    }

}
