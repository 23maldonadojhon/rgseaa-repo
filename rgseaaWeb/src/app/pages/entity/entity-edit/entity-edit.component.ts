import {Component} from '@angular/core';
import {FormGroup, Validators} from '@angular/forms';
import {FORM_STATUS} from '@base/shared/components/form';
import {EditPageBaseComponent} from '@base/shared/pages/edit-page-base.component';
import {ComponentStatus, ControlsOf} from '@libs/commons';
import {AppEntity, AppEntityForm} from "@libs/sdk/entity";

@Component({
    selector: 'tsw-entity-edit-page',
    templateUrl: './entity-edit.component.html',
    providers: [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class EntityEditComponent extends EditPageBaseComponent<AppEntity, AppEntityForm> {

    readonly resourceName = 'entities';

    protected override _createResourceTitle = 'pages.entity.add';
    protected override _editResourceTitle = 'pages.entity.edit';

    protected buildForm(): FormGroup<ControlsOf<AppEntityForm>> {
        return this.fb.group<ControlsOf<AppEntityForm>>({
            id: this.fb.control(null),
            languageId: this.fb.control(1),
            name: this.fb.control('', [Validators.required]),
            description: this.fb.control('', []),
            code: this.fb.control('', [Validators.required]),
            postalCode: this.fb.control('', []),
            address: this.fb.control('', []),
            contactPerson: this.fb.control('', []),
            phone: this.fb.control('', []),
            email: this.fb.control('', [Validators.email]),
            entityType: this.fb.control(null, [Validators.required])
        });
    }
}



