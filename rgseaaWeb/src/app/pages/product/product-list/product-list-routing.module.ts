import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductListComponent} from './product-list.component';

const routes: Routes = [
    {
        path: '',
        component: ProductListComponent,
        title: 'pages.product.list',
        data: { breadcrumb: 'generic.actions.list' },
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ProductListRoutingModule {
}
