import {Component} from '@angular/core';
import {Validators} from '@angular/forms';
import {FORM_STATUS} from '@base/shared/components/form';
import {EditPageBaseComponent} from '@base/shared/pages/edit-page-base.component';
import {ComponentStatus, ControlsOf} from '@libs/commons';
import {CreateUser, User} from '@libs/sdk/user';
import {CustomValidators} from '@libs/validators';


@Component({
    selector: 'tsw-user-edit-page',
    templateUrl: './user-edit.component.html',
    styleUrls: ['./user-edit.component.scss'],
    providers: [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class UserEditComponent extends EditPageBaseComponent<User, CreateUser> {
    readonly resourceName = 'users';
    protected override _createResourceTitle = 'pages.user.edit';
    protected override _editResourceTitle = 'pages.user.edit';

    protected buildForm() {
        return this.fb.group<ControlsOf<CreateUser>>({
            id: this.fb.control(null),
            name: this.fb.control(null, [Validators.required, CustomValidators.allowedName]),
            firstSurname: this.fb.control(null, [Validators.required, CustomValidators.allowedName]),
            secondSurname: this.fb.control(null, [CustomValidators.allowedName]),
            nif: this.fb.control(null, [Validators.required]),
            email: this.fb.control(null, [Validators.required, Validators.email]),
            phone: this.fb.control(null, [Validators.required]),
            profile: this.fb.control(null, ),
            modules: this.fb.control([], ),
            entity: this.fb.control(null, ),
        });
    }

}
