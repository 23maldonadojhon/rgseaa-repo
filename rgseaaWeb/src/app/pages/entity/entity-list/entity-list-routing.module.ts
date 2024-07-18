import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EntityListComponent} from './entity-list.component';

const routes: Routes = [
    {
        path: '',
        component: EntityListComponent,
        title: 'pages.entity.list',
        data: { breadcrumb: 'generic.actions.list' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EntityListRoutingModule {
}
