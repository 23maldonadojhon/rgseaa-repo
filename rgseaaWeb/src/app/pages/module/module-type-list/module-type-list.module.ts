import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {ListPageModule} from '@base/shared/pages/list';
import {NamedRoutesModule} from '@libs/named-routes';
import {ModuleTypeListComponent} from './module-type-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {ModuleTypeListPageRoutingModule} from "@base/pages/module/module-type-list/module-type-list-routing.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";

@NgModule({
    imports: [
        CommonModule,
        ModuleTypeListPageRoutingModule,
        AppCommonsModule,
        ListPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        NamedRoutesModule,
        StateToggleModule,
    ],
  declarations: [
    ModuleTypeListComponent
  ],
})
export class ModuleTypeListModule {
}
