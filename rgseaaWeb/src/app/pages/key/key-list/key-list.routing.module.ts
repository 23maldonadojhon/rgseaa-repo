import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {
    AuthIndustryListComponent
} from "@base/pages/autoritation-industry/auth-industry-list/auth-industry-list.component";
import {KeyListComponent} from "@base/pages/key/key-list/key-list.component";

const routes: Routes = [
    {
        path: '',
        component: KeyListComponent,
        title: 'pages.key.list',
        data: {breadcrumb: 'generic.actions.list'}
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class KeyListRoutingModule {

}
