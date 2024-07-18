import {Routes} from '@angular/router';

const breadcrumb = 'pages.product.title';

export const PRODUCT_PAGE_ROUTES: Routes = [
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
        loadChildren: () => import('./').then(m => m.ProductListModule),
    },
    {
        path: 'find/:idIndustry',
        data: {
            breadcrumb
        },
        loadChildren: () => import('./').then(m => m.ProductListModule),
    },
    {
        path: 'industry/:idIndustry',
        data: {
            breadcrumb,
            requireAccess: 'WProduct'
        },
        loadChildren: () => import('./').then(m => m.ProductEditModule),
    },
    {
        path: '0',
        data: {
            breadcrumb,
            requireAccess: 'WProduct'
        },
        loadChildren: () => import('./').then(m => m.ProductEditModule),
    },
    {
        path: ':id',
        data: {
            breadcrumb,
            requireAccess: 'WProduct'
        },
        loadChildren: () => import('./').then(m => m.ProductEditModule),
    },
    {
        path: ':action/:idIndustry',
        data: {
            breadcrumb,
            requireAccess: 'WProduct'
        },
        loadChildren: () => import('./').then(m => m.ProductEditModule),
    },
];
