import {Component} from "@angular/core";
import {FormGroup} from "@angular/forms";
import {FORM_STATUS} from "@base/shared/components/form";
import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";
import {ComponentStatus, ControlsOf} from "@libs/commons";
import {AuthIndustry, AuthIndustryCreate} from "@libs/sdk/AuthIndustry";


@Component({
    selector :'tsw-auth-industry-edit-page',
    templateUrl :'./auth-industry-edit.component.html',
    providers : [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class AuthIndustryEditComponent extends EditPageBaseComponent<AuthIndustry,AuthIndustryCreate> {

    readonly resourceName = 'authIndustry';

    protected buildForm(): FormGroup<ControlsOf<AuthIndustryCreate>> {

        return this.fb.group<ControlsOf<AuthIndustryCreate>>({
            id: this.fb.control(null),
            name: this.fb.control(null),
        });
    }

}
