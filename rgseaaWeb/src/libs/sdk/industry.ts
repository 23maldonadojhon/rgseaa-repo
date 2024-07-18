import {Key} from "@libs/sdk/key";
import {Situation} from "@libs/sdk/situation";
import {Country} from "@libs/sdk/country";
import {User} from "@libs/sdk/user";
import {Entitie} from "@libs/sdk/entitie";
import {Action} from "@libs/sdk/action";
import {TypeAction} from "@libs/sdk/type-action";
import {Authorization} from "@libs/sdk/authorization";
import {Province} from "@libs/sdk/province";
import {Location} from "@libs/sdk/location";
import {Activity} from "@libs/sdk/activity";
import {Category} from "@libs/sdk/category";
import {Subactivity} from "@libs/sdk/Subactivity";
import {ActivityCategorySubactivity} from "@libs/sdk/activity-category-subactivity";
import {AppQuerySource} from "@libs/commons";

export interface Industry {
    id : number;
    key : Key | null;
    dateRegister : Date | null;
    dateUnregister : Date | null;
    nameBusiness : string | null;
    dateInscription : Date | null;
    enrollment : string | null;
    numberIndustry : number | null;
    addressBusiness : string | null;
    locationBusiness : Location | null;
    postalCodeBusiness : string | null;
    addressIndustry : string | null;
    locationIndustry : Location | null;
    postalCodeIndustry : number | null;
    cif : string | null;
    dateValidation : Date | null;
    dateLastUpdate : Date | null;
    observation : string | null;
    situation : Situation | null;
    provinceIndustry : Province | null;
    provinceBusiness : Province | null;
    countryBusiness : Country | null;
    countryIndustry : Country | null;
    user : User | null;
    numRegCcaa : string | null;
    registered : number | null;
    addressInstallation : string | null;
    ccaaUserAdd: string | null;
    email : string | null;
    numBusiness : number | null;
    migration : string | null;
    UpdateRegister : number | null;
    numRegister : string | null;
    entitie :  Entitie | null;
    locationPrevious : string | null;
    folderMigration : string | null;
    dateRequest : Date | null;
    nameBusinessFormat : string | null;
    addressIndustryFormat : string | null;
    mtPiensos : string | null;
    pageWeb : string | null;

    action                  : Action[] | null;
    authorizationList       : Authorization[] | null;
    industryKeyActivityCategoryList            : ActivityCategorySubactivity[] | null;
}


export interface IndustryCreate {
    id : number;
    numBusiness : number | null;
    key : Key | null;
    numberIndustry : number | null;
    enrollment : string | null;
    numRegCcaa : string | null;
    situation : Situation | null;
    nameBusiness : string | null;
    cif : number | null;

    countryBusiness : Country | null;
    provinceBusiness : Province | null;
    locationBusiness : Location | null;
    postalCodeBusiness : string | null;
    addressBusiness : string | null;

    countryIndustry : Country | null;
    provinceIndustry : Province | null;
    locationIndustry : Location | null;
    postalCodeIndustry : number | null;
    addressIndustry : string | null;
    addressInstallation : string | null;

    activity : Activity | null;
    subactivity : Subactivity | null;
    category : Category | null;
    dateRequest : Date | null;
    dateInscription : Date | null;
    email : string | null;
    observation : string | null;
    pageWeb : string | null;

    typeAction              : TypeAction | null;
    actionList              : Action[] | null;

    authorizationList       : Authorization[] | null;
    industryKeyActivityCategoryList            : ActivityCategorySubactivity[] | null;
}


export interface IndustryFilter extends AppQuerySource {
    numBusiness         : string | null;
    nameBusiness        : string | null;
    key                 : string | null;
    numberIndustry      : string | null;
    enrollment          : string | null;
    numRegCcaa          : string | null;
}


export interface IndustryList {
    id          : number;
    format      : string | null;
    name        : string | null;
    nue         : string | null;
    situation   : string | null;
}
