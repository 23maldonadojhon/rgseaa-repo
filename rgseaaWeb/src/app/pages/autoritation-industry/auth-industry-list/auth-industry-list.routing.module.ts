import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {
    AuthIndustryListComponent
} from "@base/pages/autoritation-industry/auth-industry-list/auth-industry-list.component";

const routes: Routes = [
    {
        path: '',
        component: AuthIndustryListComponent,
        title: 'pages.user.list',
        data: {breadcrumb: 'generic.actions.list'}
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AuthIndustryListRoutingModule {
}
