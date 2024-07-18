import {Component} from "@angular/core";
import {FORM_STATUS} from "@base/shared/components/form";
import {ComponentStatus, ControlsOf} from "@libs/commons";
import {DenominationSale, DenominationSaleCreate} from "@libs/sdk/denomination-sale";
import {FormGroup} from "@angular/forms";
import {KeyCreate} from "@libs/sdk/key";
import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";

@Component({
    selector :'tsw-denomination-edit-page',
    templateUrl :'./denomination-edit.componet.html',
    providers : [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class DenominationEditComponent extends EditPageBaseComponent<DenominationSale,DenominationSaleCreate> {

    readonly resourceName: string ="denominationOperations";

    protected buildForm(): FormGroup {
        return this.fb.group<ControlsOf<DenominationSaleCreate>>({
            id: this.fb.control(null),
            name: this.fb.control(null),
            idKey: this.fb.control(null),
            fileType: this.fb.control(null),
            idActivity: this.fb.control(null),
            isPublic: this.fb.control(null),
        });
    }
}
