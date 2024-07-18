import {Situation} from "@libs/sdk/situation";
import {Key} from "@libs/sdk/key";
import {Country} from "@libs/sdk/country";
import {DenominationSale} from "@libs/sdk/denomination-sale";
import {Entitie} from "@libs/sdk/entitie";
import {FormPresentation} from "@libs/sdk/form-presentation";
import {Action} from "@libs/sdk/action";
import {AppQuerySource} from "@libs/commons";
import {TypeAction} from "@libs/sdk/type-action";

export interface Product {

    id                              : number;
    key                             : Key | null;
    industryNum                     : string | null;
    enrollment                      : string | null;
    numProduct                      : number | null;
    numRegister                     : number | null;
    situation                       : Situation | null;
    denominationSale                : DenominationSale | null;
    brand                           : string | null;
    competentAuthority              : Entitie | null;
    requestDocumentAnnotated        : boolean | null;

    industryId                      : number | null;
    emailResponsible                : string | null;
    countryIndustryResponsible      : Country | null;
    provinceIndustryResponsible     : string | null;
    townIndustryResponsible         : string | null;
    addressIndustryResponsible      : string | null;
    codePostalResponsible           : string | null;

    countryManufacturingKey26       : Country | null;
    countryCommercializedKey26      : Country | null;
    formPresentationKey26           : FormPresentation | null;
    typePackagingKey26              : string | null;
    observationKey26                : string | null;
    ingredientKey26                 : string | null;
    industryNameKey26               : string | null;
    addressKey26                    : string | null;
    emailKey26                      : string | null;
    annotatedDateKey26              : Date | null;
    lastDateKey26                   : Date | null;
    countryNotificationKey26        : Country | null;
    action                          : Action[] | null;
    numBusiness                     : number | null;
}

export interface ProductCreate {

    // Datos de Producto
    id                  : number | null;
    key                 : Key | null;
    industryNum         : string | null;
    enrollment          : string | null;
    numProduct          : number | null;
    numRegister         : number | null;
    situation           : Situation | null;
    denominationSale    : DenominationSale | null;
    brand               : string | null;
    competentAuthority  :  Entitie | null;
    requestDocumentAnnotated   : boolean | null;

    // Datos Empresa Responsable de la Comercialización
    industryId                          : number | null;
    emailResponsible                    : string | null;
    countryIndustryResponsible          : Country | null;
    provinceIndustryResponsible         : string | null;
    townIndustryResponsible             : string | null;
    addressIndustryResponsible          : string | null;
    codePostalResponsible               : string | null;

    // clave 26
    countryManufacturingKey26           : Country | null;
    countryCommercializedKey26          : Country | null;
    formPresentationKey26               : FormPresentation | null;
    typePackagingKey26                  : string | null;
    observationKey26                    : string | null;
    ingredientKey26                     : string | null;
    industryNameKey26                   : string | null;
    addressKey26                        : string | null;
    emailKey26                          : string | null;
    annotatedDateKey26                  : Date | null;
    lastDateKey26                       : Date | null;
    countryNotificationKey26            : Country | null;
    typeAction                          : TypeAction | null;
    action                              : Action[] | null;

    industryName                        : string | null;

}


export interface ProductFilter extends AppQuerySource {
    industryId?             : string;
    numProduct?             : string;
    numRegister?            : string;
    brand?                  : string;
    ingredientKey26?        : string;
    situation?              : string;
    situationSearch?        : string;
    competentAuthority?     : string;
    competentAuthoritySearch?: string;
    productsEntities?       : string;
}
