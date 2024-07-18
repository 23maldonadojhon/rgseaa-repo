import {Routes} from '@angular/router';

const breadcrumb = 'pages.module.title';
const breadcrumbType = 'pages.moduleType.title';

export const MODULE_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },
    {
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.ModuleListModule),
    },
    {
        path: '0',
        data: {
            breadcrumb,
            //requireAccess: 'WModule'
        },
        loadChildren: () => import('./').then(m => m.ModuleEditModule),
    },
    {
        path: ':id',
        data: {
            breadcrumb,
            //requireAccess: 'WModule'
        },
        loadChildren: () => import('./').then(m => m.ModuleEditModule),
    },
    {
        path: 'tipo/consulta',
        data: { breadcrumb: breadcrumbType },
        loadChildren: () => import('./').then(m => m.ModuleTypeListModule),
    },
    {
        path: 'tipo/alta',
        data: {
            breadcrumb: breadcrumbType,
            //requireAccess: 'WModule'
        },
        loadChildren: () => import('./').then(m => m.ModuleTypeEditModule),
    },
    {
        path: 'tipo/:id',
        data: {
            breadcrumb: breadcrumbType,
            //requireAccess: 'WModule'
        },
        loadChildren: () => import('./').then(m => m.ModuleTypeEditModule),
    },
];
