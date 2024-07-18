import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthIndustryEditComponent} from "./auth-industry-edit.component";

const routes: Routes = [
    {
        path: '',
        component: AuthIndustryEditComponent,
        title: 'pages.authindustry.edit',
        data: { breadcrumb: 'generic.actions.edit' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AuthIndustryRoutingModule {
}
