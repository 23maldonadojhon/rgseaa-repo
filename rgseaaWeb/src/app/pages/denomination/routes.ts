import {Routes} from "@angular/router";

const breadcrumb = 'denomination';

export const DENOMINATION_PAGE_ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'consulta',
        pathMatch: 'full',
    },{
        path: 'consulta',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.DenominationListModule),
    },{
        path: '',
        data: { breadcrumb },
        loadChildren: () => import('./').then(m => m.DenominationListModule),
    },{
        path: '0',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.DenominationEditModule),
    },{
        path: ':id',
        data: {
            breadcrumb,
            // requireAccess: 'WField'
        },
        loadChildren: () => import('./').then(m => m.DenominationEditModule),
    }
]
