import {NgModule} from '@angular/core';
import {CrudModule, CrudOperationStorage, HttpOperationType, OperationsDefSrc} from '@libs/crud-api';
import {appAppAPI, appAuthAPI} from './app';


export const crudOperationsStorageFactory = () => {

    const apiOperations: OperationsDefSrc = {

        health: {type: HttpOperationType.SIMPLE, path: `/health`},
        provinces: {type: HttpOperationType.READ, path: `/provinces`},
        arbitration: {type: HttpOperationType.CRUD, path: '/arbitration',},
        users: {type: HttpOperationType.CRUD, path: '/users'},
        modules: {type: HttpOperationType.CRUD, path: '/modules'},
        entities: { type: HttpOperationType.CRUD, path: '/entities' },
        entityTypes: { type: HttpOperationType.CRUD, path: '/entity_types' },
        profiles: { type: HttpOperationType.CRUD, path: '/profiles' },
        permissions: { type: HttpOperationType.READ, path: `/permissions` },
        scopes: { type: HttpOperationType.CRUD, path: '/user_scopes' },
        ccaa: {type: HttpOperationType.READ, path: '/CCAAs',},
        country: {type: HttpOperationType.READ, path: '/country.ts'},
        town: {type: HttpOperationType.READ, path: '/town'},
        roadType: {type: HttpOperationType.READ, path: '/road-type'},
        boardType: {type: HttpOperationType.READ, path: '/board-type'},
        province: {type: HttpOperationType.READ, path: '/province.ts'},
        notificationType: {type: HttpOperationType.READ, path: '/notification-type'},
        documentType: {type: HttpOperationType.READ, path: '/document-type'},

        documents: { type: HttpOperationType.CRUD, path: '/documents' },
        products: { type: HttpOperationType.CRUD, path: '/products' },
        productsKeys: { type: HttpOperationType.CRUD, path: '/products/keys?id=26' },
        productsSituations: { type: HttpOperationType.CRUD, path: '/products/situations' },
        productsDenominationSales: { type: HttpOperationType.CRUD, path: '/products/denomination_sales?idkey=26' },
        productsEntities: { type: HttpOperationType.CRUD, path: '/products/entities' },
        productsCountries: { type: HttpOperationType.CRUD, path: '/products/countries' },
        productsPresentation: { type: HttpOperationType.CRUD, path: '/products/form_presentation' },
        productsDocument: { type: HttpOperationType.CRUD, path: '/products/documents' },
        productAction: { type: HttpOperationType.CRUD, path: '/products/actions' },
        productTypeAction: { type: HttpOperationType.CRUD, path: '/products/types_actions' },
        typeDocument: { type: HttpOperationType.CRUD, path: '/products/type_document' },

        industries: { type: HttpOperationType.CRUD, path: '/industries' },
        industriesKeys: { type: HttpOperationType.CRUD, path: '/industries/keys' },
        industriesCountries: { type: HttpOperationType.CRUD, path: '/industries/countries' },
        industriesFinds: { type: HttpOperationType.CRUD, path: '/industries/find' },
        industriesAction: { type: HttpOperationType.CRUD, path: '/industries/actions' },
        industriesLocations: { type: HttpOperationType.CRUD, path: '/industries/locations' },
        industriesProvinces: { type: HttpOperationType.CRUD, path: '/industries/provinces' },
        industriesActivities: { type: HttpOperationType.CRUD, path: '/industries/activities' },
        industriesCategories: { type: HttpOperationType.CRUD, path: '/industries/categories' },
        industriesSubactivities: { type: HttpOperationType.CRUD, path: '/industries/subactivities' },
        industriesDocument: { type: HttpOperationType.CRUD, path: '/industries/documents' },
        industriesAuthorizations: { type: HttpOperationType.CRUD, path: '/industries/authorizations' },

        expedients: { type: HttpOperationType.CRUD, path: '/expedients' },
        expedientsType: { type: HttpOperationType.CRUD, path: '/expedients/types?id=2' },

        authIndustry: { type: HttpOperationType.CRUD, path: '/auth-industry' },

        keysOperations: { type: HttpOperationType.CRUD, path: '/keys' },

        denominationOperations: { type: HttpOperationType.CRUD, path: '/denomination_sales' },
    }


    const authOperations: OperationsDefSrc = {
      authRequest: {type: HttpOperationType.SIMPLE, path: `/auth/user/request`},
      authLogIn: {type: HttpOperationType.SIMPLE, path: `/auth/user/sign_in`},
      authLogOut: {type: HttpOperationType.SIMPLE, path: `/auth/user/sign_out`},
      authDetails: {type: HttpOperationType.SIMPLE, path: `/auth/user/me`},
      fakeLogIn: {type: HttpOperationType.SIMPLE, path: `/auth/user/fake-sign-in`},
    };

    return CrudOperationStorage.from([
      {baseUrl: appAppAPI.apiPath, operations: apiOperations},
      {baseUrl: appAuthAPI.apiPath, operations: authOperations},
    ]);
  }
;


@NgModule({
  imports: [CrudModule.forRoot(crudOperationsStorageFactory)],
  exports: [CrudModule]
})
export class CrudApiConfig {
}
