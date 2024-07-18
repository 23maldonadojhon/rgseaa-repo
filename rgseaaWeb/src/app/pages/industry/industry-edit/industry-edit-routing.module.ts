import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {IndustryEditComponent} from "@base/pages/industry/industry-edit/industry-edit.component";

const routes : Routes = [
    {
        path: '',
        component: IndustryEditComponent,
        title: 'pages.entity.edit',
        data: {breadcrumb: 'generic.actions.edit'},
    }
]

@NgModule({
    imports : [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class IndustryEditRoutingModule {

}
