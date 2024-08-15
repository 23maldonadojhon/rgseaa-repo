export interface Key {
    id : number;
    name : string;
    dateRegister : Date;
    dateUnregister : Date;
    allowProduct : number;
    isOld : boolean;
    isPublic : number;
    state : number | null;
}


export interface KeyCreate {
    id : number;
    name : string;
    allowProduct : number;
    isPublic : number;
}
