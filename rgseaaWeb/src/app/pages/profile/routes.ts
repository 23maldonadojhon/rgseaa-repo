import {Routes} from '@angular/router';

const breadcrumb = 'perfil';

export const PROFILE_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },
    {
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.ProfileListModule),
    },
    {
        path: '',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.ProfileListModule),
    },
    {
        path: '0',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.ProfileEditModule),
    },
    {
        path: ':id',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.ProfileEditModule),
    },
    {
        path: ':id/documents',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.ProfileEditModule),
    },
    {
        path: ':id/sign',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.ProfileEditModule),
    }
    // {
    //   path: ':id',
    //   data: {
    //     breadcrumb,
    //     requireAccess: 'WField'
    //   },
    //   loadChildren: () => import('./').then(m => m.FieldEditPageModule),
    // }
];
