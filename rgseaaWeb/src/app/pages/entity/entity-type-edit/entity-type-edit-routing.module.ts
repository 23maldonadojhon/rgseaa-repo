import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EntityTypeEditComponent} from './entity-type-edit.component';

const routes: Routes = [
    {
        path: '',
        component: EntityTypeEditComponent,
        title: 'pages.entityType.edit',
        data: { breadcrumb: 'generic.actions.edit' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EntityTypeEditRoutingModule {
}
