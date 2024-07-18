package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.ProductDto;
import es.aesan.rgseaa.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter extends BaseConverter<Product,ProductDto> {

}
