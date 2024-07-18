export interface Entitie {
    id          : number;
    languageId  : number;
    state       : number;
    code        : string;
    name        : string;
    description : string;
    postalCode  : string;
    address     : string;
    contactPerson   : string;
    phone       : string;
    email       : string;
    rootEntity  : boolean;
    parent      : Entitie;
}
