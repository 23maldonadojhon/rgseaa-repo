import {Component, ElementRef, Input, TemplateRef, ViewChild} from '@angular/core';
import {MatFormFieldControl} from '@angular/material/form-field';
import {MatSelect} from '@angular/material/select';
import {ComboValue, CustomSelectBaseComponent} from '@base/shared/select';

@Component({
    selector: 'tsw-search-select',
    templateUrl: './search-select.component.html',
    providers: [
        {
            provide: MatFormFieldControl,
            useExisting: SearchSelectComponent
        },
    ]
})
export class SearchSelectComponent <T = ComboValue> extends CustomSelectBaseComponent<T> {

    static nextId = 0;

    @Input() triggerTmpl: TemplateRef<any> | undefined;
    @Input() optionTmpl: TemplateRef<any> | undefined;

    @ViewChild(MatSelect, { static: true }) selectElm: MatSelect | undefined;

    @ViewChild(MatSelect, { read: ElementRef, static: true })
    set selectRef(elm: ElementRef) {
        this.elementRef = elm;
    }

    override openSelectionOptions(): void {
        super.openSelectionOptions();
        this.selectElm?.open();
    }

    getComponentId(): string {
        return `tsw-search-select-${ SearchSelectComponent.nextId++ }`;
    }

}
