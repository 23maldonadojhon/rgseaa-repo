package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyEstablishmentViewConverter
        extends BaseConverter<CompanyEstablishmentView, CompanyEstablishmentViewDto>{

}
