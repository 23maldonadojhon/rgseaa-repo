import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
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
