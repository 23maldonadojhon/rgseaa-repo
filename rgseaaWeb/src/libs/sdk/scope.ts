/* import { TulsaCCAA } from './ccaa'; */
import {BaseModel, SimpleModel, StatefulAltModel, StatefulModel} from './common';
import {AppEntity} from './entity';

/* import { TulsaProvince } from './province.ts'; */


export interface AppScope extends BaseModel, StatefulModel {
    user: number;
    entity: AppEntity;
}

export interface AppScopeView extends SimpleModel<string>, StatefulAltModel {
    email: string;
    entity: number;
    entityName: string;
    isoCode: string;
    languageName: string;
    name: string;
    nif: string;
    phoneNumber: string;
    scopeCode: string;
    stateId: number;
    stateName: string;
    surname2: string;
    surname: string;
    user: number;
}

export interface AppScopeForm {
    user: number | null;
    entity: Partial<AppEntity> | null;
}

export type ScopeIdSrc = AppScope | AppScopeForm | AppScopeView | Partial<AppScope | AppScopeForm | AppScopeView>;

/**
 * Creates a formatted ID from the provided ScopeIdSrc
 */
export const createScopeId = (scope: ScopeIdSrc) => {
    const { user, entity } = scope;
    const userId = user || 0;
    /*   const ccaaId = ccaa == null ? 0 : typeof ccaa === 'number' ? ccaa : ccaa.id;
      const provinceId = province.ts == null ? 0 : typeof province.ts === 'number' ? province.ts : province.ts.id; */
    const entityId = entity == null ? 0 : typeof entity === 'number' ? entity : entity.id;

    return `${ userId },${ entityId }`;
};

export const compareScopeView = (a: AppScopeView, b: AppScopeView) => a?.scopeCode === b?.scopeCode;
