import {Industry} from "@libs/sdk/industry";
import {Product} from "@libs/sdk/product";
import {DenominationSale} from "@libs/sdk/denomination-sale";
import {Situation} from "@libs/sdk/situation";
import {Key} from "@libs/sdk/key";
import {State} from "@libs/sdk/state";
import {Country} from "@libs/sdk/country";
import {Province} from "@libs/sdk/province";
import {User} from "@libs/sdk/user";
import {TypeExpedient} from "@libs/sdk/typeExpedient";
import {FormPresentation} from "@libs/sdk/form-presentation";
import {TypeChangeExpedient} from "@libs/sdk/TypeChangeExpedient";
import {Activity} from "@libs/sdk/activity";
import {Subactivity} from "@libs/sdk/Subactivity";
import {Category} from "@libs/sdk/category";
import {Action} from "@libs/sdk/action";
import {Authorization} from "@libs/sdk/authorization";
import {ActivityCategorySubactivity} from "@libs/sdk/activity-category-subactivity";
import {TypeAction} from "@libs/sdk/type-action";

export interface Expedient {
    id                  : number;
    numberExpedient     : string | null;
    industry            : Industry | null;
    nameBusiness        : string | null;
    product             : Product | null;
    denominationSale    : DenominationSale | null;
    brand               : string | null;
    situation           : Situation | null;
    key                 : Key | null;
    numberIndustry      : number | null;
    addressBusiness     : string | null;
    dateAdmission       : Date | null;
    dateEstiResolution  : Date | null;
    dateReport          : Date | null;
    dateResolution      : Date | null;
    stateExpedient      : State | null;
    electronicFlow      : number | null;
    country             : Country | null;
    province            : Province | null;
    userAssigned        : User | null;
    userReport          : User | null;
    typeExpedient       :TypeExpedient  | null;
    dateAuthorization   : Date | null;
    observation         : string | null;
    fountain            : string | null;
    location            : string | null;
    enrollmentKey27     : string | null;
    countryLocation     : Location | null;
    dateDoce            : Date | null;
    countryFabrication  : Country | null;
    countryCommercialization : Country | null;
    otherCountry        : string | null;
    typeContainer       : string | null;
    ingredient          : string | null;
    formPresentation    : FormPresentation | null;
    descriptionCountryLocation : string | null;
    socialReasonKey26   : string | null;
    productNameIaKey26  : string | null;
    countryIaKey26      : Country | null;
    addressKey26        : string | null;
    emailKey26          : string | null;
    phoneIaCode26       : string | null;
    dateRequestChange   : Date | null;
    dateLastRequest     : Date | null;
    dateInspection      : Date | null;
    dateOfDenial        : Date | null;
    dateResponseAesan   : Date | null;
    authority           : string | null;
    typeChangeExpedient : TypeChangeExpedient | null;
    productUpdated       : number | null;
    signatureApplication : number | null;
    enrollment          : string | null;
    typeSubstance       : number | null;
    emailResponsible    : string | null;
    industryPhone       : string | null;
    otherCountryComer   : string | null;
    otherForms          : string | null;
    migration           : string | null;
}


export interface ExpedientCreate {
    id                  : number;
    numberExpedient     : string | null;

    key                 : Key | null;
    numberIndustry      : number | null;
    enrollment          : string | null;

    situation           : Situation | null;
    dateInspection      : Date | null;
    dateRequestChange   : Date | null;
    dateLastRequest     : Date | null;
    dateReport          : Date | null;

    nameBusiness        : string | null;
    addressBusiness     : string | null;
    industryPhone       : string | null;
    emailResponsible    : string | null;
    country             : Country | null;
    denominationSale    : DenominationSale | null;
    brand               : string | null;
    observation         : string | null;

    countryFabrication  : Country | null;
    countryCommercialization : Country | null;
    otherCountry        : string | null;
    formPresentation    : FormPresentation | null;
    otherForms          : string | null;
    ingredient          : string | null;
    typeContainer       : string | null;
    socialReasonKey26   : string | null;
    countryIaKey26      : Country | null;
    addressKey26        : string | null;
    productNameIaKey26  : string | null;
    emailKey26          : string | null;
    phoneIaCode26       : string | null
    dateAdmission       : Date | null;
    dateEstiResolution  : Date | null;
    dateOfDenial        : Date | null;
    dateResponseAesan   : Date | null;

    activity : Activity | null;
    subactivity : Subactivity | null;
    category : Category | null;

    typeAction              : TypeAction | null;
    actionList              : Action[] | null;

    authorizationList       : Authorization[] | null;
    industryKeyActivityCategoryList            : ActivityCategorySubactivity[] | null;
}
