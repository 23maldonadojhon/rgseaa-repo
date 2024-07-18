import {Routes} from "@angular/router";

const breadcrumb = 'pages.expedient.title';

export const  EXPEDIENT_PAGE_ROUTES : Routes = [
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
        loadChildren: () => import('./').then(m => m.ExpedientListModule),
    },
    {
        path: 'find/:idIndustry',
        data: {
            breadcrumb
        },
        loadChildren: () => import('./').then(m => m.ExpedientListModule),
    },
    {
        path: 'add/:idIndustry',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.ExpedientEditModule),
    },
    {
        path: ':id',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.ExpedientEditModule),
    },
    {
        path: ':action/:id',
        data: {
            breadcrumb,
            requireAccess: 'WIndustry'
        },
        loadChildren: () => import('./').then(m => m.ExpedientEditModule),
    },
    {
        path: ':action/:idIndustry',
        data: {
            breadcrumb,
            requireAccess: 'WProduct'
        },
        loadChildren: () => import('./').then(m => m.ExpedientEditModule),
    },
];
