import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {EntityEditPageRoutingModule} from './entity-edit-routing.module';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {EditPageModule} from "@base/shared/pages/edit-page.module";
import {EntityEditComponent} from "@base/pages/entity/entity-edit/entity-edit.component";

@NgModule({
    imports: [
        CommonModule,
        EntityEditPageRoutingModule,
        AppCommonsModule,
        EditPageModule,
    ],
    declarations: [
        EntityEditComponent
    ],
})
export class EntityEditModule {
}
