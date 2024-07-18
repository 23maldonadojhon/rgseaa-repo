import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ModuleTypeEditComponent} from './module-type-edit.component';

const routes: Routes = [
    {
        path: '',
        component: ModuleTypeEditComponent,
        title: 'pages.moduleType.edit',
        data: { breadcrumb: 'generic.actions.edit' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ModuleTypeEditRoutingModule {
}
