import {FilterComponent} from "@base/shared/filter";
import {ProductFilter} from "@libs/sdk/product";
import {ControlsOf} from "@libs/commons";
import {Component, EventEmitter, Output} from "@angular/core";


@Component({
    selector: 'tsw-product-list-filter',
    templateUrl: './product-list-filter.component.html'
})
export class ProductListFilterComponent extends FilterComponent<ProductFilter> {

    readonly resourceName = 'products';

    @Output() valueSelected = new EventEmitter<number | undefined>();


    protected buildQueryForm() {

        return  this.fb.group<ControlsOf<ProductFilter>>({
             industryId: this.fb.control(null),
             numProduct: this.fb.control(null),
             numRegister: this.fb.control(null),
             brand: this.fb.control(null),
             situation: this.fb.control(null),
             ingredientKey26: this.fb.control(null),
             situationSearch : this.fb.control(null),
             competentAuthority : this.fb.control(null),
             competentAuthoritySearch : this.fb.control(null),
        });

    }

    protected moreData() {

        let valueSituation = this.form.get('situation')?.value;
        let competentAuthority = this.form.get('competentAuthority')?.value;

        if(valueSituation==null)
            this.form.get('situationSearch')?.setValue(``);
        else
            this.form.get('situationSearch')?.setValue(`${valueSituation}__eq`);

        if(competentAuthority==null)
            this.form.get('competentAuthoritySearch')?.setValue(``);
        else
            this.form.get('competentAuthoritySearch')?.setValue(`${competentAuthority}__eq`);
    }

    protected readonly onchange = onchange;
}
