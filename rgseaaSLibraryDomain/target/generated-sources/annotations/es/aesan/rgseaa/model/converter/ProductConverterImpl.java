package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActionDto;
import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.model.dto.DenominationSaleDto;
import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.model.dto.EntitieTypeDto;
import es.aesan.rgseaa.model.dto.FormPresentationDto;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.dto.ProductDto;
import es.aesan.rgseaa.model.dto.SituationDto;
import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.model.entity.Action;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.model.entity.DenominationSale;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.model.entity.EntitieType;
import es.aesan.rgseaa.model.entity.FormPresentation;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.model.entity.Product;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.model.entity.TypeAction;
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
public class ProductConverterImpl implements ProductConverter {

    @Override
    public Product dtoToEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setKey( keyDtoToKey( dto.getKey() ) );
        product.setIndustryNum( dto.getIndustryNum() );
        product.setEnrollment( dto.getEnrollment() );
        if ( dto.getNumProduct() != null ) {
            product.setNumProduct( String.valueOf( dto.getNumProduct() ) );
        }
        if ( dto.getNumRegister() != null ) {
            product.setNumRegister( String.valueOf( dto.getNumRegister() ) );
        }
        product.setSituation( situationDtoToSituation( dto.getSituation() ) );
        product.setDenominationSale( denominationSaleDtoToDenominationSale( dto.getDenominationSale() ) );
        product.setBrand( dto.getBrand() );
        product.setCompetentAuthority( entitieDtoToEntitie( dto.getCompetentAuthority() ) );
        product.setRequestDocumentAnnotated( dto.isRequestDocumentAnnotated() );
        product.setIndustryId( dto.getIndustryId() );
        product.setEmailResponsible( dto.getEmailResponsible() );
        product.setCountryIndustryResponsible( countryDtoToCountry( dto.getCountryIndustryResponsible() ) );
        if ( dto.getProvinceIndustryResponsible() != null ) {
            product.setProvinceIndustryResponsible( Long.parseLong( dto.getProvinceIndustryResponsible() ) );
        }
        if ( dto.getTownIndustryResponsible() != null ) {
            product.setTownIndustryResponsible( Long.parseLong( dto.getTownIndustryResponsible() ) );
        }
        product.setAddressIndustryResponsible( dto.getAddressIndustryResponsible() );
        if ( dto.getCodePostalResponsible() != null ) {
            product.setCodePostalResponsible( Long.parseLong( dto.getCodePostalResponsible() ) );
        }
        product.setCountryManufacturingKey26( countryDtoToCountry( dto.getCountryManufacturingKey26() ) );
        product.setCountryCommercializedKey26( countryDtoToCountry( dto.getCountryCommercializedKey26() ) );
        product.setFormPresentationKey26( formPresentationDtoToFormPresentation( dto.getFormPresentationKey26() ) );
        product.setTypePackagingKey26( dto.getTypePackagingKey26() );
        product.setObservationKey26( dto.getObservationKey26() );
        product.setIngredientKey26( dto.getIngredientKey26() );
        product.setIndustryNameKey26( dto.getIndustryNameKey26() );
        product.setAddressKey26( dto.getAddressKey26() );
        product.setEmailKey26( dto.getEmailKey26() );
        product.setAnnotatedDateKey26( dto.getAnnotatedDateKey26() );
        product.setLastDateKey26( dto.getLastDateKey26() );
        product.setCountryNotificationKey26( countryDtoToCountry( dto.getCountryNotificationKey26() ) );
        product.setAction( actionDtoListToActionList( dto.getAction() ) );

        return product;
    }

    @Override
    public ProductDto entityToDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setKey( keyToKeyDto( entity.getKey() ) );
        productDto.setIndustryNum( entity.getIndustryNum() );
        productDto.setEnrollment( entity.getEnrollment() );
        if ( entity.getNumProduct() != null ) {
            productDto.setNumProduct( Integer.parseInt( entity.getNumProduct() ) );
        }
        if ( entity.getNumRegister() != null ) {
            productDto.setNumRegister( Integer.parseInt( entity.getNumRegister() ) );
        }
        productDto.setSituation( situationToSituationDto( entity.getSituation() ) );
        productDto.setDenominationSale( denominationSaleToDenominationSaleDto( entity.getDenominationSale() ) );
        productDto.setBrand( entity.getBrand() );
        productDto.setCompetentAuthority( entitieToEntitieDto( entity.getCompetentAuthority() ) );
        productDto.setRequestDocumentAnnotated( entity.isRequestDocumentAnnotated() );
        productDto.setIndustryId( entity.getIndustryId() );
        productDto.setEmailResponsible( entity.getEmailResponsible() );
        productDto.setCountryIndustryResponsible( countryToCountryDto( entity.getCountryIndustryResponsible() ) );
        if ( entity.getProvinceIndustryResponsible() != null ) {
            productDto.setProvinceIndustryResponsible( String.valueOf( entity.getProvinceIndustryResponsible() ) );
        }
        if ( entity.getTownIndustryResponsible() != null ) {
            productDto.setTownIndustryResponsible( String.valueOf( entity.getTownIndustryResponsible() ) );
        }
        productDto.setAddressIndustryResponsible( entity.getAddressIndustryResponsible() );
        if ( entity.getCodePostalResponsible() != null ) {
            productDto.setCodePostalResponsible( String.valueOf( entity.getCodePostalResponsible() ) );
        }
        productDto.setCountryManufacturingKey26( countryToCountryDto( entity.getCountryManufacturingKey26() ) );
        productDto.setCountryCommercializedKey26( countryToCountryDto( entity.getCountryCommercializedKey26() ) );
        productDto.setFormPresentationKey26( formPresentationToFormPresentationDto( entity.getFormPresentationKey26() ) );
        productDto.setTypePackagingKey26( entity.getTypePackagingKey26() );
        productDto.setObservationKey26( entity.getObservationKey26() );
        productDto.setIngredientKey26( entity.getIngredientKey26() );
        productDto.setIndustryNameKey26( entity.getIndustryNameKey26() );
        productDto.setAddressKey26( entity.getAddressKey26() );
        productDto.setEmailKey26( entity.getEmailKey26() );
        productDto.setAnnotatedDateKey26( entity.getAnnotatedDateKey26() );
        productDto.setLastDateKey26( entity.getLastDateKey26() );
        productDto.setCountryNotificationKey26( countryToCountryDto( entity.getCountryNotificationKey26() ) );
        productDto.setAction( actionListToActionDtoList( entity.getAction() ) );

        return productDto;
    }

    @Override
    public List<ProductDto> mapEntityToDtoList(List<Product> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entityList.size() );
        for ( Product product : entityList ) {
            list.add( entityToDto( product ) );
        }

        return list;
    }

    @Override
    public List<Product> mapDtoToEntityList(List<ProductDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtoList.size() );
        for ( ProductDto productDto : dtoList ) {
            list.add( dtoToEntity( productDto ) );
        }

        return list;
    }

    protected Key keyDtoToKey(KeyDto keyDto) {
        if ( keyDto == null ) {
            return null;
        }

        Key key = new Key();

        key.setState( keyDto.getState() );
        key.setId( keyDto.getId() );
        key.setName( keyDto.getName() );
        key.setDateRegister( keyDto.getDateRegister() );
        key.setDateUnregister( keyDto.getDateUnregister() );
        key.setAllowProduct( keyDto.getAllowProduct() );
        key.setIsPublic( keyDto.getIsPublic() );

        return key;
    }

    protected Situation situationDtoToSituation(SituationDto situationDto) {
        if ( situationDto == null ) {
            return null;
        }

        Situation situation = new Situation();

        situation.setId( situationDto.getId() );
        situation.setName( situationDto.getName() );
        situation.setTypeIndustryProduct( situationDto.getTypeIndustryProduct() );
        situation.setNewOption( situationDto.getNewOption() );
        situation.setNoDelete( situationDto.getNoDelete() );
        situation.setVisibleRgsa( situationDto.getVisibleRgsa() );
        situation.setVisibleUe( situationDto.getVisibleUe() );

        return situation;
    }

    protected DenominationSale denominationSaleDtoToDenominationSale(DenominationSaleDto denominationSaleDto) {
        if ( denominationSaleDto == null ) {
            return null;
        }

        DenominationSale denominationSale = new DenominationSale();

        denominationSale.setState( denominationSaleDto.getState() );
        denominationSale.setId( denominationSaleDto.getId() );
        denominationSale.setName( denominationSaleDto.getName() );
        denominationSale.setFileType( denominationSaleDto.getFileType() );
        denominationSale.setIsPublic( denominationSaleDto.getIsPublic() );
        denominationSale.setDateRegister( denominationSaleDto.getDateRegister() );
        denominationSale.setDateUnregister( denominationSaleDto.getDateUnregister() );
        denominationSale.setActive( denominationSaleDto.getActive() );

        return denominationSale;
    }

    protected EntitieType entitieTypeDtoToEntitieType(EntitieTypeDto entitieTypeDto) {
        if ( entitieTypeDto == null ) {
            return null;
        }

        EntitieType entitieType = new EntitieType();

        entitieType.setState( entitieTypeDto.getState() );
        entitieType.setId( entitieTypeDto.getId() );
        entitieType.setName( entitieTypeDto.getName() );
        entitieType.setDescription( entitieTypeDto.getDescription() );

        return entitieType;
    }

    protected Entitie entitieDtoToEntitie(EntitieDto entitieDto) {
        if ( entitieDto == null ) {
            return null;
        }

        Entitie entitie = new Entitie();

        entitie.setState( entitieDto.getState() );
        entitie.setId( entitieDto.getId() );
        entitie.setName( entitieDto.getName() );
        entitie.setCode( entitieDto.getCode() );
        entitie.setDescription( entitieDto.getDescription() );
        entitie.setPostalCode( entitieDto.getPostalCode() );
        entitie.setAddress( entitieDto.getAddress() );
        entitie.setContactPerson( entitieDto.getContactPerson() );
        entitie.setPhone( entitieDto.getPhone() );
        entitie.setEmail( entitieDto.getEmail() );
        entitie.setRootEntity( entitieDto.isRootEntity() );
        entitie.setEntityType( entitieTypeDtoToEntitieType( entitieDto.getEntityType() ) );

        return entitie;
    }

    protected Country countryDtoToCountry(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDto.getId() );
        country.setName( countryDto.getName() );
        country.setEnrollment( countryDto.getEnrollment() );
        country.setNoDelete( countryDto.getNoDelete() );

        return country;
    }

    protected FormPresentation formPresentationDtoToFormPresentation(FormPresentationDto formPresentationDto) {
        if ( formPresentationDto == null ) {
            return null;
        }

        FormPresentation formPresentation = new FormPresentation();

        formPresentation.setId( formPresentationDto.getId() );
        formPresentation.setName( formPresentationDto.getName() );
        formPresentation.setType( formPresentationDto.getType() );
        formPresentation.setDateRegister( formPresentationDto.getDateRegister() );
        formPresentation.setDateUnregister( formPresentationDto.getDateUnregister() );

        return formPresentation;
    }

    protected TypeAction typeActionDtoToTypeAction(TypeActionDto typeActionDto) {
        if ( typeActionDto == null ) {
            return null;
        }

        TypeAction typeAction = new TypeAction();

        typeAction.setId( typeActionDto.getId() );
        typeAction.setName( typeActionDto.getName() );
        typeAction.setNoDelete( typeActionDto.getNoDelete() );
        typeAction.setVisibleCcaa( typeActionDto.getVisibleCcaa() );

        return typeAction;
    }

    protected Action actionDtoToAction(ActionDto actionDto) {
        if ( actionDto == null ) {
            return null;
        }

        Action action = new Action();

        action.setId( actionDto.getId() );
        action.setDescription( actionDto.getDescription() );
        action.setTypeAction( typeActionDtoToTypeAction( actionDto.getTypeAction() ) );

        return action;
    }

    protected List<Action> actionDtoListToActionList(List<ActionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Action> list1 = new ArrayList<Action>( list.size() );
        for ( ActionDto actionDto : list ) {
            list1.add( actionDtoToAction( actionDto ) );
        }

        return list1;
    }

    protected KeyDto keyToKeyDto(Key key) {
        if ( key == null ) {
            return null;
        }

        KeyDto keyDto = new KeyDto();

        keyDto.setId( key.getId() );
        keyDto.setName( key.getName() );
        keyDto.setDateRegister( key.getDateRegister() );
        keyDto.setDateUnregister( key.getDateUnregister() );
        keyDto.setAllowProduct( key.getAllowProduct() );
        keyDto.setIsPublic( key.getIsPublic() );
        keyDto.setState( key.getState() );

        return keyDto;
    }

    protected SituationDto situationToSituationDto(Situation situation) {
        if ( situation == null ) {
            return null;
        }

        SituationDto situationDto = new SituationDto();

        situationDto.setId( situation.getId() );
        situationDto.setName( situation.getName() );
        situationDto.setTypeIndustryProduct( situation.getTypeIndustryProduct() );
        situationDto.setNewOption( situation.getNewOption() );
        situationDto.setNoDelete( situation.getNoDelete() );
        situationDto.setVisibleRgsa( situation.getVisibleRgsa() );
        situationDto.setVisibleUe( situation.getVisibleUe() );

        return situationDto;
    }

    protected DenominationSaleDto denominationSaleToDenominationSaleDto(DenominationSale denominationSale) {
        if ( denominationSale == null ) {
            return null;
        }

        DenominationSaleDto denominationSaleDto = new DenominationSaleDto();

        denominationSaleDto.setId( denominationSale.getId() );
        denominationSaleDto.setName( denominationSale.getName() );
        denominationSaleDto.setFileType( denominationSale.getFileType() );
        denominationSaleDto.setIsPublic( denominationSale.getIsPublic() );
        denominationSaleDto.setDateRegister( denominationSale.getDateRegister() );
        denominationSaleDto.setDateUnregister( denominationSale.getDateUnregister() );
        denominationSaleDto.setActive( denominationSale.getActive() );
        denominationSaleDto.setState( denominationSale.getState() );

        return denominationSaleDto;
    }

    protected EntitieTypeDto entitieTypeToEntitieTypeDto(EntitieType entitieType) {
        if ( entitieType == null ) {
            return null;
        }

        EntitieTypeDto entitieTypeDto = new EntitieTypeDto();

        entitieTypeDto.setId( entitieType.getId() );
        entitieTypeDto.setName( entitieType.getName() );
        entitieTypeDto.setDescription( entitieType.getDescription() );
        entitieTypeDto.setState( entitieType.getState() );

        return entitieTypeDto;
    }

    protected EntitieDto entitieToEntitieDto(Entitie entitie) {
        if ( entitie == null ) {
            return null;
        }

        EntitieDto entitieDto = new EntitieDto();

        entitieDto.setId( entitie.getId() );
        entitieDto.setState( entitie.getState() );
        entitieDto.setCode( entitie.getCode() );
        entitieDto.setName( entitie.getName() );
        entitieDto.setDescription( entitie.getDescription() );
        entitieDto.setPostalCode( entitie.getPostalCode() );
        entitieDto.setAddress( entitie.getAddress() );
        entitieDto.setContactPerson( entitie.getContactPerson() );
        entitieDto.setPhone( entitie.getPhone() );
        entitieDto.setEmail( entitie.getEmail() );
        entitieDto.setRootEntity( entitie.isRootEntity() );
        entitieDto.setEntityType( entitieTypeToEntitieTypeDto( entitie.getEntityType() ) );

        return entitieDto;
    }

    protected CountryDto countryToCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( country.getId() );
        countryDto.setName( country.getName() );
        countryDto.setEnrollment( country.getEnrollment() );
        countryDto.setNoDelete( country.getNoDelete() );

        return countryDto;
    }

    protected FormPresentationDto formPresentationToFormPresentationDto(FormPresentation formPresentation) {
        if ( formPresentation == null ) {
            return null;
        }

        FormPresentationDto formPresentationDto = new FormPresentationDto();

        formPresentationDto.setId( formPresentation.getId() );
        formPresentationDto.setName( formPresentation.getName() );
        formPresentationDto.setType( formPresentation.getType() );
        formPresentationDto.setDateRegister( formPresentation.getDateRegister() );
        formPresentationDto.setDateUnregister( formPresentation.getDateUnregister() );

        return formPresentationDto;
    }

    protected TypeActionDto typeActionToTypeActionDto(TypeAction typeAction) {
        if ( typeAction == null ) {
            return null;
        }

        TypeActionDto typeActionDto = new TypeActionDto();

        typeActionDto.setId( typeAction.getId() );
        typeActionDto.setName( typeAction.getName() );
        typeActionDto.setNoDelete( typeAction.getNoDelete() );
        typeActionDto.setVisibleCcaa( typeAction.getVisibleCcaa() );

        return typeActionDto;
    }

    protected ActionDto actionToActionDto(Action action) {
        if ( action == null ) {
            return null;
        }

        ActionDto actionDto = new ActionDto();

        actionDto.setId( action.getId() );
        actionDto.setDescription( action.getDescription() );
        actionDto.setTypeAction( typeActionToTypeActionDto( action.getTypeAction() ) );

        return actionDto;
    }

    protected List<ActionDto> actionListToActionDtoList(List<Action> list) {
        if ( list == null ) {
            return null;
        }

        List<ActionDto> list1 = new ArrayList<ActionDto>( list.size() );
        for ( Action action : list ) {
            list1.add( actionToActionDto( action ) );
        }

        return list1;
    }
}
