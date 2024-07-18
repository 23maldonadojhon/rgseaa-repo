import {Routes} from "@angular/router";

const breadcrumb = 'pages.industry.title';

export const  INDUSTRY_PAGE_ROUTES : Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },
    {
        path: 'consulta',
        data: {
            breadcrumb
        },
        loadChildren: () => import('./').then(m => m.IndustryListModule),
    },{
        path: '0',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.IndustryEditModule),
    },{
        path: ':id',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.IndustryEditModule),
    },{
        path: ':action/:id',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.IndustryEditModule),
    },
]
