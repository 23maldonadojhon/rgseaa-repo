import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ModuleListComponent} from './module-list.component';

const routes: Routes = [
    {
        path: '',
        component: ModuleListComponent,
        title: 'pages.module.list',
        data: { breadcrumb: 'generic.actions.list' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ModuleListPageRoutingModule {
}
