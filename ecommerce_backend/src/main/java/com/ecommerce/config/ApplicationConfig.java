package com.ecommerce.config;

import com.ecommerce.DTO.ProductOptionDTO;
import com.ecommerce.auditing.ApplicationAuditAware;
import com.ecommerce.entity.Account;
import com.ecommerce.entity.ProductOption;
import com.ecommerce.form.CreateProductOptionForm;
import com.ecommerce.form.UpdateProductOptionForm;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper initModalMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<ProductOption, ProductOptionDTO> typeMap = modelMapper.createTypeMap(ProductOption.class, ProductOptionDTO.class);
        Converter<String, byte[]> toByteArray = ctx -> {
            try {
                return Files.readAllBytes(new File(ctx.getSource()).toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        typeMap.addMappings(
                mapper -> mapper.using(toByteArray)
                .map(ProductOption::getImage, ProductOptionDTO::setImage)
        );

        modelMapper.createTypeMap(UpdateProductOptionForm.class, ProductOption.class).addMappings(mapper -> mapper.skip(ProductOption::setImage));
        modelMapper.createTypeMap(CreateProductOptionForm.class, ProductOption.class).addMappings(mapper -> mapper.skip(ProductOption::setImage));

        return modelMapper;
    }

    @Bean
    public AuditorAware<Account> auditorAware() {
        return new ApplicationAuditAware();
    }
}
