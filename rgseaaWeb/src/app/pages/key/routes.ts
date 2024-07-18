import {Routes} from "@angular/router";

const breadcrumb = 'key';

export const KEY_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },{
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.KeyListModule),
    },{
        path: '',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.KeyListModule),
    },{
        path: '0',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.KeyEditModule),
    },{
        path: ':id',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.KeyEditModule),
    }
]
