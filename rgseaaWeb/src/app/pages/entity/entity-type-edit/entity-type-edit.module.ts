import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {EntityTypeEditRoutingModule} from './entity-type-edit-routing.module';
import {EntityTypeEditComponent} from './entity-type-edit.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";

@NgModule({
    imports: [
        CommonModule,
        EntityTypeEditRoutingModule,
        AppCommonsModule,
        EditPageModule,
    ],
    declarations: [
        EntityTypeEditComponent
    ],
})
export class EntityTypeEditModule {
}
