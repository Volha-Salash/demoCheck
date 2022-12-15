package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.repository.impl.ProductRepositoryImpl;
import com.academy.demoCheck.service.interfaces.ProductReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : Volha Salash
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductReaderService {

    @Override
    public void read(ProductRepositoryImpl productRepository) {
            File products = new File("src/main/resources/products");
            try (Scanner scanner = new Scanner(products)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(" ");
                    Integer id = 1;
                    String name = data[0];
                    Double price = Double.parseDouble(data[1]);
                    int sale = Integer.parseInt(data[2]);
                    productRepository.addProduct(id, name, price, sale);
                }
            } catch (FileNotFoundException e) {
                System.out.println("FILE NOT FOUND");
            }

        }
}



   /*
        implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Override
    public ProductDto getProduct(Integer id) {
        return productMapper.toDto(productRepository.getProductById(id));
    }

    @Override
    public Set<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.getProducts());
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setId(product.getId());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setSale(product.getSale());
        productRepository.addProduct(product);
        log.info("Created new product " + product.getName());
    }

}

    */

