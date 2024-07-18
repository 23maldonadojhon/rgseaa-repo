import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ExpedientListComponent} from "@base/pages/expedient/expedient-list/expedient-list.component";

const routes: Routes = [
    {
        path: '',
        component: ExpedientListComponent,
        title: 'pages.expedient.list',
        data: { breadcrumb: 'generic.expedient.list' },
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ExpedientListRoutingModule {

}
