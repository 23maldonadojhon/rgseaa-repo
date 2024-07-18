import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ModuleEditPageRoutingModule} from './module-edit-routing.module';
import {ModuleEditComponent} from './module-edit.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";

@NgModule({
    imports: [
        CommonModule,
        ModuleEditPageRoutingModule,
        AppCommonsModule,
        EditPageModule,
    ],
    declarations: [
        ModuleEditComponent
    ],
})
export class ModuleEditModule {
}
