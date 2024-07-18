import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {KeyEditComponent} from "@base/pages/key/key-edit/key-edit.component";

const routes: Routes = [
    {
        path: '',
        component: KeyEditComponent,
        title: 'pages.authindustry.edit',
        data: { breadcrumb: 'generic.actions.edit' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class KeyEditRoutingModule {
}
