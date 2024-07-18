import {Routes} from '@angular/router';
import {USER_PAGE_ROUTES} from "../pages/user/routes";
import {PROFILE_PAGE_ROUTES} from "@base/pages/profile/routes";
import {ENTITY_PAGE_ROUTES} from "@base/pages/entity/routes";
import {PRODUCT_PAGE_ROUTES} from "@base/pages/product/routes";
import {INDUSTRY_PAGE_ROUTES} from "@base/pages/industry/routes";
import {EXPEDIENT_PAGE_ROUTES} from "@base/pages/expedient/routes";
import {AUTH_INDUSTRY_PAGE_ROUTES} from "@base/pages/autoritation-industry/routes";
import {KEY_PAGE_ROUTES} from "@base/pages/key/routes";
import {DENOMINATION_PAGE_ROUTES} from "@base/pages/denomination/routes";


export const dashboardRoutes: Routes = [
  {
    path: 'inicio',
    loadChildren: () => import('./home-page/home-page.module').then(m => m.HomePageModule),
  },{
        path: 'user',
        data: {
            requireAccess: 'RUser'
        },
        children: USER_PAGE_ROUTES,
    },
    {
        path: 'profile',
        data: {
             requireAccess: 'RProfile'
        },
        children: PROFILE_PAGE_ROUTES,
    },
    {
        path: 'entity',
        data: {
            requireAccess: 'REntity'
        },
        children: ENTITY_PAGE_ROUTES,
    },
    {
        path: 'product',
        data: {
             requireAccess: 'RProduct'
        },
        children: PRODUCT_PAGE_ROUTES,
    },
    {
        path: 'industry',
        data: {
            requireAccess: 'RIndustry'
        },
        children: INDUSTRY_PAGE_ROUTES,
    }, {
        path: 'expedient',
        data: {
            //requireAccess: 'RIndustry'
        },
        children: EXPEDIENT_PAGE_ROUTES,
    }, {
        path: 'auth-industry',
        data: {
            //requireAccess: 'RIndustry'
        },
        children: AUTH_INDUSTRY_PAGE_ROUTES,
    },{
        path: 'keys',
        data: {
            //requireAccess: 'RIndustry'
        },
        children: KEY_PAGE_ROUTES,
    },{
        path: 'denomination_sales',
        data: {
            //requireAccess: 'RIndustry'
        },
        children: DENOMINATION_PAGE_ROUTES,
    },

];
