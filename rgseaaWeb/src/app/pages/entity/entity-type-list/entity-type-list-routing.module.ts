import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EntityTypeListComponent} from './entity-type-list.component';

const routes: Routes = [
    {
        path: '',
        component: EntityTypeListComponent,
        title: 'pages.entityType.title',
        data: { breadcrumb: 'generic.actions.list' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EntityTypeListRoutingModule {
}
