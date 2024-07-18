import {FilterComponent} from "@base/shared/filter";
import {ControlsOf} from "@libs/commons";
import {Component, EventEmitter, Output} from "@angular/core";
import {IndustryFilter} from "@libs/sdk/industry";


@Component({
    selector: 'tsw-industry-list-filter',
    templateUrl: './industry-list-filter.component.html'
})
export class IndustryListFilterComponent extends FilterComponent<IndustryFilter> {

    readonly resourceName = 'industries';

    @Output() valueSelected = new EventEmitter<number | undefined>();


    protected buildQueryForm() {

        return  this.fb.group<ControlsOf<IndustryFilter>>({
            numBusiness: this.fb.control(null),
            nameBusiness: this.fb.control(null),
            key: this.fb.control(null),
            numberIndustry: this.fb.control(null),
            enrollment: this.fb.control(null),
            numRegCcaa: this.fb.control(null),
        });

    }

    protected moreData() {

    }

    protected readonly onchange = onchange;
}
