import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ModuleEditComponent} from './module-edit.component';

const routes: Routes = [
    {
        path: '',
        component: ModuleEditComponent,
        title: 'pages.module.edit',
        data: { breadcrumb: 'generic.actions.edit' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ModuleEditPageRoutingModule {
}
