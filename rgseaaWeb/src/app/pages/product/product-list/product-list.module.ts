import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ProductListRoutingModule} from './product-list-routing.module';
import {ProductListComponent} from './product-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";
import {UserListModule} from "@base/pages/user";
import {ProductListFilterComponent} from "@base/pages/product/product-list-filter/product-list-filter.component";
import {MatInputModule} from "@angular/material/input";
import {TswSelectModule} from "@base/shared/select";
import {FormExtensionModule} from "@base/shared/components/form";
import {SectionModule} from "@base/shared/components/section";

@NgModule({
    imports: [
        CommonModule,
        ProductListRoutingModule,
        AppCommonsModule,
        ListPageModule,
        StateToggleModule,
        UserListModule,
        MatInputModule,
        TswSelectModule,
        FormExtensionModule,
        SectionModule,
    ],
    exports: [

    ],
    declarations: [
        ProductListComponent,
        ProductListFilterComponent
    ],
})
export class ProductListModule {
}
