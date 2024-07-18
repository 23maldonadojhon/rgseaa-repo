import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EntityEditComponent} from './entity-edit.component';


const routes: Routes = [
    {
        path: '',
        component: EntityEditComponent,
        title: 'pages.entity.edit',
        data: { breadcrumb: 'generic.actions.edit' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EntityEditPageRoutingModule {
}
