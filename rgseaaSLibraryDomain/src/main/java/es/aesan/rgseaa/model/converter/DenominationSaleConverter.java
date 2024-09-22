package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.DenominationSaleDto;
import es.aesan.rgseaa.model.entity.DenominationSale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        uses = {
            KeyConverter.class,
            ActivityConverter.class,
            TypeExpedientConverter.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DenominationSaleConverter extends BaseConverter<DenominationSale,DenominationSaleDto> {

}
