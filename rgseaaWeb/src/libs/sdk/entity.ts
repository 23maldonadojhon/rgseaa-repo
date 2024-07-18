import {SimpleModel, StatefulModel, TranslatedModel} from './common';
import {AppEntityType} from './entity-type';

export interface AppEntity extends SimpleModel, TranslatedModel, StatefulModel {

    name: string;
    description: string;
    code: string;
    postalCode: string;
    address: string;
    contactPerson: string;
    phone: string;
    email: string;
    rootEntity: boolean;
    parent: AppEntity;
    entityType: AppEntityType;
}

export interface AppEntityForm {
    id: number | null;
    languageId: number | string | null;
    name: string;
    description: string | null;
    code: string;
    postalCode: string | null;
    address: string | null;
    contactPerson: string | null;
    phone: string | null;
    email: string | null;
    entityType: AppEntityType | null;
}
