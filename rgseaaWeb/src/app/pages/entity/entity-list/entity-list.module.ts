import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {EntityListRoutingModule} from './entity-list-routing.module';
import {EntityListComponent} from './entity-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ListPageModule} from "@base/shared/pages/list-page.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";

@NgModule({
    imports: [
        CommonModule,
        EntityListRoutingModule,
        AppCommonsModule,
        ListPageModule,
        StateToggleModule,
    ],
    declarations: [
        EntityListComponent
    ],
})
export class EntityListModule {
}
