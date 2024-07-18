package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.CompanyDto;
import es.aesan.rgseaa.model.dto.CompanyFindDto;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.model.entity.Location;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.model.entity.id.Company;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T08:06:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class CompanyConverterImpl implements CompanyConverter {

    @Override
    public Company dtoToEntity(CompanyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( dto.getId() );
        company.setNif( dto.getNif() );
        company.setName( dto.getName() );
        company.setEmail( dto.getEmail() );
        company.setPageWeb( dto.getPageWeb() );
        company.setObservation( dto.getObservation() );
        company.setAddress( dto.getAddress() );
        company.setPostalCode( dto.getPostalCode() );

        return company;
    }

    @Override
    public List<CompanyDto> mapEntityToDtoList(List<Company> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>( entityList.size() );
        for ( Company company : entityList ) {
            list.add( entityToDto( company ) );
        }

        return list;
    }

    @Override
    public List<Company> mapDtoToEntityList(List<CompanyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Company> list = new ArrayList<Company>( dtoList.size() );
        for ( CompanyDto companyDto : dtoList ) {
            list.add( dtoToEntity( companyDto ) );
        }

        return list;
    }

    @Override
    public CompanyFindDto dtoToEntityFind(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyFindDto companyFindDto = new CompanyFindDto();

        companyFindDto.setId( company.getId() );
        companyFindDto.setName( company.getName() );
        companyFindDto.setSituation( companySituationName( company ) );

        return companyFindDto;
    }

    @Override
    public CompanyDto entityToDto(Company entity) {
        if ( entity == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setCountryId( entityCountryId( entity ) );
        companyDto.setProvinceId( entityProvinceId( entity ) );
        companyDto.setLocationId( entityLocationId( entity ) );
        companyDto.setSituationId( entitySituationId( entity ) );
        companyDto.setId( entity.getId() );
        companyDto.setNif( entity.getNif() );
        companyDto.setName( entity.getName() );
        companyDto.setEmail( entity.getEmail() );
        companyDto.setPageWeb( entity.getPageWeb() );
        companyDto.setObservation( entity.getObservation() );
        companyDto.setAddress( entity.getAddress() );
        companyDto.setPostalCode( entity.getPostalCode() );

        return companyDto;
    }

    @Override
    public List<CompanyFindDto> dtoToEntityFindList(List<Company> company) {
        if ( company == null ) {
            return null;
        }

        List<CompanyFindDto> list = new ArrayList<CompanyFindDto>( company.size() );
        for ( Company company1 : company ) {
            list.add( dtoToEntityFind( company1 ) );
        }

        return list;
    }

    private String companySituationName(Company company) {
        if ( company == null ) {
            return null;
        }
        Situation situation = company.getSituation();
        if ( situation == null ) {
            return null;
        }
        String name = situation.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityCountryId(Company company) {
        if ( company == null ) {
            return null;
        }
        Country country = company.getCountry();
        if ( country == null ) {
            return null;
        }
        Long id = country.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityProvinceId(Company company) {
        if ( company == null ) {
            return null;
        }
        Province province = company.getProvince();
        if ( province == null ) {
            return null;
        }
        Long id = province.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityLocationId(Company company) {
        if ( company == null ) {
            return null;
        }
        Location location = company.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entitySituationId(Company company) {
        if ( company == null ) {
            return null;
        }
        Situation situation = company.getSituation();
        if ( situation == null ) {
            return null;
        }
        Long id = situation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
