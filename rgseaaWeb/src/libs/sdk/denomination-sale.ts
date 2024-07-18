export interface DenominationSale {
    id : number;
    name : string;
    idKey : number;
    fileType : string;
    idActivity : string;
    isPublic : number;
    dateRegister : Date;
    dateUnregister : Date;
    active : number;
    state : number;
}


export interface DenominationSaleCreate {
    id : number;
    name : string;
    idKey : number;
    fileType : string;
    idActivity : string;
    isPublic : number;
}
