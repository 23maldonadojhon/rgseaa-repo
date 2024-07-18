import {SimpleModel, StatefulModel, TranslatedModel} from './common';


export interface AppEntityType extends SimpleModel, TranslatedModel, StatefulModel {
    name: string;
    description: string | null;
}

export interface AppEntityTypeForm {
    id: number | null;
    languageId: number | string | null;
    name: string | null;
    description: string | null;
}
