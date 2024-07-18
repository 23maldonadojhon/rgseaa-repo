import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {EditPageModule} from '@base/shared/pages/edit-page.module';
import {ModuleTypeEditRoutingModule} from './module-type-edit-routing.module';
import {ModuleTypeEditComponent} from './module-type-edit.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";

@NgModule({

    imports: [
        CommonModule,
        ModuleTypeEditRoutingModule,
        AppCommonsModule,
        EditPageModule,
    ],
    declarations: [
        ModuleTypeEditComponent
    ],
})
export class ModuleTypeEditModule {
}
