import {NgModule} from '@angular/core';
import {NamedRoutesModule, NamedRouteSource} from '@libs/named-routes';

const routes: NamedRouteSource[] = [
    { key: 'home', value: '/app/inicio' },
    { key: 'login', value: '/auth/login' },
    { key: 'logout', value: '/auth/logout' },
    { key: 'user', value: '/auth/user' },

    { key: 'userManagementCreate', value: '/app/user/0' },
    { key: 'userManagementList', value: '/app/user' },
    { key: 'userManagementEdit', value: '/app/user/:id' },

    { key: 'productManagementCreate', value: '/app/product/0' },
    { key: 'productIndustryManagementCreate', value: '/app/product/industry/:idIndustry' },
    { key: 'productManagementList', value: '/app/product' },
    { key: 'productIndustryManagementList', value: '/app/product/find/:idIndustry' },
    { key: 'productManagementEdit', value: '/app/product/:id' },
    { key: 'productManagementAction', value: '/app/product/:action/:idIndustry' },

    { key: 'industryManagementCreate', value: '/app/industry/0' },
    { key: 'industryManagementList', value: '/app/industry' },
    { key: 'industryManagementEdit', value: '/app/industry/:id' },
    { key: 'industryManagementCopy', value: '/app/industry/:action/:id' },

    { key: 'expedientManagementCreate', value: '/app/expedient/add/:idIndustry' },
    { key: 'expedientManagementList', value: '/app/expedient' },
    { key: 'expedientIndustryManagementList', value: '/app/expedient/find/:idIndustry' },
    { key: 'expedientManagementEdit', value: '/app/expedient/:id' },
    { key: 'expedientManagementCopy', value: '/app/expedient/:action/:id' },
    { key: 'expedientManagementAction', value: '/app/expedient/:action/:idIndustry' },

    { key: 'profileManagementList', value: '/app/profile/consulta' },
    { key: 'profileManagementCreate', value: '/app/profile/0' },
    { key: 'profileManagementEdit', value: '/app/profile/:id' },

    { key: 'entityManagementCreate', value: '/app/entity/0' },
    { key: 'entityManagementList', value: '/app/entity' },
    { key: 'entityManagementEdit', value: '/app/entity/:id' },
    { key: 'entityTypeManagementList', value: '/app/entity/tipo/consulta' },
    { key: 'entityTypeManagementCreate', value: '/app/entity/tipo/0' },
    { key: 'entityTypeManagementEdit', value: '/app/entity/tipo/:id' },

    { key: 'moduleManagementCreate', value: '/app/module/0' },
    { key: 'moduleManagementList', value: '/app/module' },
    { key: 'moduleManagementEdit', value: '/app/module/:id' },
    { key: 'moduleTypeManagementList', value: '/app/module/tipo/consulta' },
    { key: 'moduleTypeManagementCreate', value: '/app/module/tipo/0' },
    { key: 'moduleTypeManagementEdit', value: '/app/module/tipo/:id' },


    { key: 'authIndustryAdminCreate', value: '/app/auth-industry/0' },
    { key: 'authIndustryAdminList', value: '/app/auth-industry' },
    { key: 'authIndustryAdminEdit', value: '/app/auth-industry/:id' },

    { key: 'keyAdminCreate', value: '/app/keys/0' },
    { key: 'keyAdminList', value: '/app/keys' },
    { key: 'keyAdminEdit', value: '/app/keys/:id' },

    { key: 'denominationAdminCreate', value: '/app/denomination_sales/0' },
    { key: 'denominationAdminList', value: '/app/denomination_sales' },
    { key: 'denominationAdminEdit', value: '/app/denomination_sales/:id' },
];


@NgModule({
  imports: [NamedRoutesModule.forRoot(routes)],
  exports: [NamedRoutesModule],
})
export class NamedRoutesConfig {
}
