package com.ecommerce.service;


import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductOption;
import com.ecommerce.form.CreateProductOptionForm;
import com.ecommerce.form.UpdateProductOptionForm;
import com.ecommerce.repository.IProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductOptionService implements IProductOptionService{

    @Autowired
    public ProductService productService;
    private final String FOLDER_SAVED_IMG = "../resources/images/";
    private IProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionService(IProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public List<ProductOption> getProductOptionsByProductId(int id) {
        List<ProductOption> productOptions = productOptionRepository.findAllByProductId(id);

        return productOptions;
    }

    @Override
    public ProductOption createNewProductOption(CreateProductOptionForm productOption) {
        ProductOption productOption1 = new ProductOption();
        Product product = productService.getProductById(productOption.getProductId());
        productOption1.setProduct(product);
        productOption1.setImage(productOption.getImage());
        productOption1.setColor(productOption.getColor());
        productOption1.setPrice(productOption.getPrice());
        productOption1.setPriceSale(productOption.getPriceSale());
        productOption1.setRam(productOption.getRam());
        productOption1.setQuantity(productOption.getQuantity());
        productOptionRepository.save(productOption1);
        return productOption1;
    }

    @Override
    @Transactional
    public ProductOption updateProductOption(int id, UpdateProductOptionForm form) {
        ProductOption existingProduct = productOptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such product option with id: " + id));
        existingProduct.setColor(form.getColor());
        existingProduct.setPrice(form.getPrice());
        existingProduct.setPriceSale(form.getPriceSale());
        existingProduct.setRam(form.getRam());
        existingProduct.setImage(form.getImage());
        productOptionRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    @Transactional
    public void deleteProductOptionById(int id) {
        ProductOption existingProduct = productOptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such product option with id: " + id));
        productOptionRepository.delete(existingProduct);
    }

    @Override
    @Transactional
    public void deleteProductOptionByProductId(int productId) {
        List<ProductOption> productOptions = getProductOptionsByProductId(productId);
        productOptionRepository.deleteAllInBatch(productOptions);
    }

    @Override
    public String saveImage(MultipartFile file) {
        String fileName = UUID.randomUUID().toString();
        String filePath = FOLDER_SAVED_IMG + fileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }
}
