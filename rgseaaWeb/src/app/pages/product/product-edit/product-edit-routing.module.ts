import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductEditComponent} from './product-edit.component';


const routes: Routes = [
    {
        path: '',
        component: ProductEditComponent,
        title: 'pages.entity.edit',
        data: { breadcrumb: 'generic.actions.edit' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ProductEditRoutingModule {
}
