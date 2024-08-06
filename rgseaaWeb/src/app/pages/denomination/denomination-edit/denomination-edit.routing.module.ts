import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {DenominationEditComponent} from "@base/pages/denomination/denomination-edit/denomination-edit.component";

const routes: Routes = [
    {
        path: '',
        component: DenominationEditComponent,
        title: 'pages.authindustry.edit',
        data: { breadcrumb: 'generic.actions.edit' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DenominationEditRoutingModule {
}
