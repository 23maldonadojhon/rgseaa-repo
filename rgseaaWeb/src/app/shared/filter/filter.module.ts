import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatTooltipModule} from '@angular/material/tooltip';
import {TranslateModule} from '@ngx-translate/core';
import {
    FilterHiddenComponent,
    FiltersContainerActionsComponent,
    FiltersContainerComponent,
    SearchInputComponent,
    SimpleSearchComponent,
} from './components';
import {CustomFilterDirective} from './directives';
import {SearchSelectComponent} from "@base/shared/filter/components/search-select/search-select.component";
import {ExtractModelPathModule} from "@libs/utils/extract-model-path";

const EXPORTED_DECLARATIONS = [
  FilterHiddenComponent,
  FiltersContainerActionsComponent,
  FiltersContainerComponent,
  SearchInputComponent,
  SimpleSearchComponent,
  CustomFilterDirective,
    SearchSelectComponent
];

@NgModule({
    imports: [
        CommonModule,
        MatCardModule,
        MatButtonModule,
        MatDividerModule,
        MatExpansionModule,
        MatIconModule,
        MatInputModule,
        MatSelectModule,
        MatSlideToggleModule,
        MatTooltipModule,
        ReactiveFormsModule,
        TranslateModule,
        ExtractModelPathModule,
    ],
  declarations: EXPORTED_DECLARATIONS,
  exports: EXPORTED_DECLARATIONS
})
export class FilterModule {
}
