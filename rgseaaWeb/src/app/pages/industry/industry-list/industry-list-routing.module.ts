import {RouterModule, Routes} from "@angular/router";
import {IndustryListComponent} from "@base/pages/industry/industry-list/industry-list.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
    {
        path: '',
        component: IndustryListComponent,
        title: 'pages.industry.list',
        data: { breadcrumb: 'generic.industry.list' },
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class IndustryListRoutingModule {

}
