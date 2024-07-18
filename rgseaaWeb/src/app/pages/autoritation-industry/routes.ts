import {Routes} from "@angular/router";

const breadcrumb = 'auth-industry';

export const AUTH_INDUSTRY_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },{
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.AuthIndustryListModule),
    },{
        path: '',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.AuthIndustryListModule),
    },{
        path: '0',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.AuthIndustryModule),
    },{
        path: ':id',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.AuthIndustryModule),
    }
]
