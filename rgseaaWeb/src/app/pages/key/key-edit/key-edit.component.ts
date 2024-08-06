import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";
import {Key, KeyCreate} from "@libs/sdk/key";
import {FormGroup} from "@angular/forms";
import {Component} from "@angular/core";
import {FORM_STATUS} from "@base/shared/components/form";
import {ComponentStatus, ControlsOf} from "@libs/commons";


@Component({
    selector :'tsw-key-edit-page',
    templateUrl :'./key-edit.component.html',
    providers : [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class KeyEditComponent extends EditPageBaseComponent<Key,KeyCreate> {

    readonly resourceName: string ="keysOperations";
    protected allowProduct = [
        {"id": 0, "name": "No"},
        {"id": 1, "name": "Si"}
    ]
    protected public = [
        {"id": 0, "name": "No"},
        {"id": 1, "name": "Si"}
    ]

    protected buildForm(): FormGroup {
        return this.fb.group<ControlsOf<KeyCreate>>({
            id: this.fb.control(null),
            name: this.fb.control(null),
            allowProduct: this.fb.control(null),
            isPublic: this.fb.control(null),
        });
    }

}
