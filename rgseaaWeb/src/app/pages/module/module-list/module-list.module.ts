import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {ListPageModule} from '@base/shared/pages/list';
import {NamedRoutesModule} from '@libs/named-routes';
import {ModuleListPageRoutingModule} from './module-list-routing.module';
import {ModuleListComponent} from './module-list.component';
import {AppCommonsModule} from "@base/shared/pages/commons.module";
import {StateToggleModule} from "@base/shared/components/state-toggle";

@NgModule({
    imports: [
        ModuleListPageRoutingModule,
        CommonModule,
        AppCommonsModule,
        ListPageModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        NamedRoutesModule,
        StateToggleModule,
    ],
    declarations: [
        ModuleListComponent
    ],
})
export class ModuleListModule {
}
