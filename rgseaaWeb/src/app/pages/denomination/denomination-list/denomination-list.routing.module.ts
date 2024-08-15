import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {DenominationListComponent} from "@base/pages/denomination/denomination-list/denomination-list.component";

const routes: Routes = [
    {
        path: '',
        component: DenominationListComponent,
        title: 'pages.denomination.list',
        data: {breadcrumb: 'generic.actions.list'}
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class  DenominationListRoutingModule {
}
