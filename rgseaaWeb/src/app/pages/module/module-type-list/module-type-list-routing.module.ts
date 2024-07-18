import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ModuleTypeListComponent} from './module-type-list.component';


const routes: Routes = [
    {
        path: '',
        component: ModuleTypeListComponent,
        title: 'pages.moduleType.list',
        data: { breadcrumb: 'generic.actions.list' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ModuleTypeListPageRoutingModule {
}
