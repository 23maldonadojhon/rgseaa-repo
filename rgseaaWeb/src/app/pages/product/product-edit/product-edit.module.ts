import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ProductEditRoutingModule} from './product-edit-routing.module';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {ProductEditComponent} from "@base/pages/product/product-edit/product-edit.component";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from '@angular/material/core';
import {MatTableModule} from "@angular/material/table";

@NgModule({
    imports: [
        ProductEditRoutingModule,
        CommonModule,
        AppCommonsModule,
        EditPageModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatTableModule
    ],
    declarations: [
        ProductEditComponent
    ],
})
export class ProductEditModule {
}
