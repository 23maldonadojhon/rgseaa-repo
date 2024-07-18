import {Route, Router, RouterModule} from "@angular/router";
import {ExpedientEditComponent} from "@base/pages/expedient/expedient-edit/expedient-edit.component";
import {NgModule} from "@angular/core";

const routes: Route[] = [
    {
        path : '',
        component : ExpedientEditComponent,
        title: 'pages.entity.edit',
        data: {breadcrumb: 'generic.actions.edit'},
    }
]

@NgModule({
    imports : [RouterModule.forChild(routes)],
    exports : [RouterModule]
})
export class ExpedientEditRoutingModule {

}
