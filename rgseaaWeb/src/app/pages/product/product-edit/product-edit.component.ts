import {Component, ViewChild} from '@angular/core';
import {FormGroup, Validators} from '@angular/forms';
import {FORM_STATUS} from '@base/shared/components/form';
import {EditPageBaseComponent} from '@base/shared/pages/edit-page-base.component';
import {ComponentStatus, ControlsOf} from '@libs/commons';
import {Product, ProductCreate} from "@libs/sdk/product";
import {Action} from "@libs/sdk/action";
import {Country} from "@libs/sdk/country";
import {DialogFileComponent} from "@base/pages/product/dialog-file/dialog-file.component";
import {TypeAction} from "@libs/sdk/type-action";
import {MatTable} from "@angular/material/table";
import {Industry} from "@libs/sdk/industry";


@Component({
    selector: 'tsw-product-edit-page',
    templateUrl: './product-edit.component.html',
    providers: [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class ProductEditComponent extends EditPageBaseComponent<Product, ProductCreate> {

    protected countTypeAction : number = 1;
    protected ELEMENT_DATA: Action[] = [];
    readonly resourceName = 'products';
    protected valueCountry: Country | undefined;
    protected isSpain : boolean = false;
    protected override _createResourceTitle = 'pages.product.add';
    protected override _editResourceTitle = 'pages.product.edit';
    protected displayedColumns: string[] = ['date', 'type-name', 'description', 'files','actions'];
    protected dataSource = this.ELEMENT_DATA;
    protected dataSourceDialog = [];
    protected productId : number = 0;
    protected industryId : number | undefined;
    protected industry : Industry | undefined;
    protected showNue : boolean = false;
    @ViewChild(MatTable) table: MatTable<Action> | undefined;

    override onInit() {

    }

    protected buildForm(): FormGroup<ControlsOf<ProductCreate>> {

        return this.fb.group<ControlsOf<ProductCreate>>({
            id:                         this.fb.control(null),
            key:                        this.fb.control(null, [Validators.required]),
            industryNum:                this.fb.control(null, [Validators.required]),
            enrollment:                 this.fb.control(null, [Validators.required]),
            numProduct:                 this.fb.control(null, [Validators.required]),
            numRegister:                this.fb.control(null, [Validators.required]),
            situation:                  this.fb.control(null, [Validators.required]),
            denominationSale:           this.fb.control(null, [Validators.required]),
            brand:                      this.fb.control(null, [Validators.required]),
            competentAuthority:         this.fb.control(null, [Validators.required]),
            requestDocumentAnnotated:   this.fb.control(null),

            industryId:                     this.fb.control({ value: 0, disabled: true }),
            emailResponsible:               this.fb.control(null, [Validators.required]),
            countryIndustryResponsible:     this.fb.control(null, [Validators.required]),
            provinceIndustryResponsible:    this.fb.control(null),
            townIndustryResponsible:        this.fb.control(null),
            addressIndustryResponsible:     this.fb.control(null, [Validators.required]),
            codePostalResponsible:          this.fb.control(null),

            countryManufacturingKey26:          this.fb.control(null, [Validators.required]),
            countryCommercializedKey26:         this.fb.control(null, [Validators.required]),
            formPresentationKey26:              this.fb.control(null, [Validators.required]),
            typePackagingKey26:                 this.fb.control(null, [Validators.required]),
            observationKey26:                   this.fb.control(null, [Validators.required]),
            ingredientKey26:                    this.fb.control(null, [Validators.required]),
            industryNameKey26:                  this.fb.control(null, [Validators.required]),
            addressKey26:                       this.fb.control(null, [Validators.required]),
            emailKey26:                         this.fb.control(null, [Validators.required]),
            annotatedDateKey26:                 this.fb.control(null, [Validators.required]),
            lastDateKey26:                      this.fb.control(null, [Validators.required]),
            countryNotificationKey26:           this.fb.control(null, [Validators.required]),
            typeAction:                         this.fb.control(null),
            action:                             this.fb.control(null),
            industryName:                       this.fb.control(null),
        });

    }

    protected override afterLoadData() {
        super.afterLoadData();
        this.loadTable();

        if(this._action==='p_industry'){

            this.industryId = this.route.snapshot.params['idIndustry'];

            if(this.industryId!==undefined) {
                this.crudServiceUtil.findById<Industry>(this.industryId, {
                    resourceName: 'industries',
                    pathParams: {
                        id: this.industryId
                    }
                }).subscribe((response) => {

                    this.showNue = true;

                    this.industry = response;

                    this.form.get("key")?.setValue( this.industry.key);
                    this.form.get("industryNum")?.setValue( this.industry.numberIndustry);
                    this.form.get("enrollment")?.setValue( this.industry.enrollment);
                    this.form.get("emailResponsible")?.setValue( this.industry.email);
                    this.form.get("addressIndustryResponsible")?.setValue( this.industry.addressIndustry);
                    this.form.get("industryName")?.setValue( this.industry.nameBusiness);
                    this.form.get("countryIndustryResponsible")?.setValue( this.industry.countryBusiness);
                    this.form.get("numBusiness")?.setValue( this.industry.numBusiness);

                    this.form.get('key')?.disable();
                    this.form.get('industryNum')?.disable();
                    this.form.get('enrollment')?.disable();
                    this.form.get('emailResponsible')?.disable();
                    this.form.get('addressIndustryResponsible')?.disable();
                    this.form.get('industryName')?.disable();
                    this.form.get("countryIndustryResponsible")?.disable();

                });
            }
        }
    }

    addRow() : void {

       let typeAction : TypeAction = this.form.get("typeAction")?.value;

       if(typeAction!=undefined) {
           let action : Action = {
               id           : null,
               typeAction   : typeAction,
               documentList : null,
               description  : null,
               count        : this.countTypeAction++,
               update       : 0
           }

           this.dataSource.push(action);
           this.table?.renderRows();
       }

    }

    deleteRow(count : number) {

        let action = this.dataSource.find(item=>item.id==count);

        if(action){
            action.update=1;
            action.documentList = null;
            action.typeAction = null;
            action.description = null;
        }

        this.table?.renderRows();
    }


    loadTable(){

        let actionList : Action[] = this.form.get("action")?.value;

        if(actionList==null) {
            const actionId : number = 21;
            this.crudServiceUtil.findById<TypeAction>(actionId,{
                resourceName: 'productTypeAction',
                pathParams : {
                    id : actionId
                }
            }).subscribe((response)=>{

                let action : Action = {
                    id              : null,
                    typeAction      : response,
                    documentList    : null,
                    description     : null,
                    count           : this.countTypeAction++,
                    update          : 0
                }

                this.dataSource.push(action);

                this.table?.renderRows();
            });

        } else {
            this.dataSource = actionList;
        }

    }


    openDialog(id : number) {

        const dialogRef = this.dialog.open(DialogFileComponent,{
            width: '75%',
            data: {
                id: id
            }
        });


        dialogRef.afterClosed().subscribe(dataReturn => {

            let item = this.dataSource.find(item=>item.id===id);
            if(item){
                item.documentList = [];
                item.documentList.push(...dataReturn.result);
            }
        });

    }


    chanceCountry(event: any) {
        if(this.valueCountry?.id==1){
            this.isSpain=true;
        } else {
            this.isSpain=false;
        }
    }

    override submitForm() {
        this.form.get('action')?.setValue(this.dataSource);
        this.form.get('industryId')?.setValue(this.industryId);
        super.submitForm();
    }

}



