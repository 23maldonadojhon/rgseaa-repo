import {Routes} from '@angular/router';

const breadcrumb = 'pages.entity.title';
const breadcrumbType = 'pages.entityType.title';

export const ENTITY_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },
    {
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.EntityListModule),
    },
    {
        path: '0',
        data: {
            breadcrumb,
            //requireAccess: 'WEntity'
        },
        loadChildren: () => import('./').then(m => m.EntityEditModule),
    },
    {
        path: ':id',
        data: {
            breadcrumb,
            //requireAccess: 'WEntity'
        },
        loadChildren: () => import('./').then(m => m.EntityEditModule),
    },
    {
        path: 'tipo/consulta',
        data: { breadcrumb: breadcrumbType },
        loadChildren: () => import('./').then(m => m.EntityTypeListModule),
    },
    {
        path: 'tipo/alta',
        data: {
            breadcrumb: breadcrumbType,
            //requireAccess: 'WEntity'
        },
        loadChildren: () => import('./').then(m => m.EntityTypeEditModule),
    },
    {
        path: 'tipo/:id',
        data: {
            breadcrumb: breadcrumbType,
            //requireAccess: 'WEntity'
        },
        loadChildren: () => import('./').then(m => m.EntityTypeEditModule),
    },
];
