import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {EntityTypeListRoutingModule} from './entity-type-list-routing.module';
import {EntityTypeListComponent} from './entity-type-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";

@NgModule({
    imports: [
        CommonModule,
        EntityTypeListRoutingModule,
        AppCommonsModule,
        ListPageModule,
        StateToggleModule,
    ],
    declarations: [
        EntityTypeListComponent
    ],
})
export class EntityTypeListModule {
}
