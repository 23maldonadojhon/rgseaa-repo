import {Routes} from '@angular/router';

const breadcrumb = 'usuario';

export const USER_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    }, {
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.UserListModule),
    }, {
        path: '',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.UserListModule),
    }, {
        path: '0',
        data: {
            breadcrumb,
            requireAccess: 'WUser'
        },
        loadChildren: () => import('./').then(m => m.UserEditModule),
    }, {
        path: ':id',
        data: {
            breadcrumb,
            requireAccess: 'WUser'
        },
        loadChildren: () => import('./').then(m => m.UserEditModule),
    },
];
