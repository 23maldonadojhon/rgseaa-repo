import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";
import {Component, ViewChild} from "@angular/core";
import {FORM_STATUS} from "@base/shared/components/form";
import {ComponentStatus, ControlsOf} from "@libs/commons";
import {FormGroup} from "@angular/forms";
import {Expedient, ExpedientCreate} from "@libs/sdk/expedient";
import {ProductCreate} from "@libs/sdk/product";
import {Action} from "@libs/sdk/action";
import {ActivityCategorySubactivity} from "@libs/sdk/activity-category-subactivity";
import {Activity} from "@libs/sdk/activity";
import {Category} from "@libs/sdk/category";
import {Subactivity} from "@libs/sdk/Subactivity";
import {Key} from "@libs/sdk/key";
import {Country} from "@libs/sdk/country";
import {MatTable} from "@angular/material/table";
import {TypeAction} from "@libs/sdk/type-action";

@Component({
    selector: 'tsw-expedient-edit-page',
    templateUrl: './expedient-edit.component.html',
    providers: [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class ExpedientEditComponent extends EditPageBaseComponent<Expedient,ExpedientCreate> {

    readonly resourceName = 'expedients';
    protected displayedColumnsActuation: string[] = ['date', 'type-name', 'description', 'files','actions'];
    dataSource : Action[] = [];
    dataSourceACS : ActivityCategorySubactivity[] = [];
    disabledButonAddActity : boolean = false;
    displayedColumns: string[] = ['activity', 'category', 'subactivity', 'delete'];
    activityIndustry : Activity[] = [];
    categoryIndustry : Category[] = [];
    subactivityIndustry : Subactivity[] = [];
    keyIndustry : Key[] = [];
    protected countTypeAction : number = 1;
    protected countActivity : number = 1;

    @ViewChild('table1') tableLoadDocument: MatTable<Action> | undefined;
    @ViewChild('tableActivity') tableLoadActivity: MatTable<Action> | undefined;

    protected buildForm(): FormGroup<ControlsOf<ExpedientCreate>> {

        return this.fb.group<ControlsOf<ExpedientCreate>>({
            id:                         this.fb.control(null),
            numberExpedient:            this.fb.control(null),
            key:                        this.fb.control(null),
            numberIndustry:             this.fb.control(null),
            enrollment:                 this.fb.control(null),
            situation:                  this.fb.control(null),
            dateInspection:             this.fb.control(null),
            dateRequestChange:          this.fb.control(null),
            dateLastRequest:            this.fb.control(null),
            dateReport:                 this.fb.control(null),
            nameBusiness:               this.fb.control(null),
            addressBusiness:            this.fb.control(null),
            industryPhone:              this.fb.control(null),
            emailResponsible:           this.fb.control(null),
            country:                    this.fb.control(null),
            denominationSale:           this.fb.control(null),
            brand:                      this.fb.control(null),
            observation:                this.fb.control(null),
            countryFabrication  :       this.fb.control(null),
            countryCommercialization :  this.fb.control(null),
            otherCountry        :       this.fb.control(null),
            formPresentation        :   this.fb.control(null),
            otherForms        :         this.fb.control(null),
            ingredient  :         this.fb.control(null),
            typeContainer :         this.fb.control(null),
            socialReasonKey26 :         this.fb.control(null),
            countryIaKey26 :         this.fb.control(null),
            addressKey26 :         this.fb.control(null),
            productNameIaKey26 :         this.fb.control(null),
            emailKey26 :         this.fb.control(null),
            phoneIaCode26 :         this.fb.control(null),
            dateAdmission :         this.fb.control(null),
            dateEstiResolution :         this.fb.control(null),
            dateOfDenial :         this.fb.control(null),
            dateResponseAesan :         this.fb.control(null),

            activity:               this.fb.control(null),
            category:               this.fb.control(null),
            subactivity:            this.fb.control(null),

            typeAction:             this.fb.control(null),
            actionList:             this.fb.control(null),
            authorizationList:      this.fb.control(null),
            industryKeyActivityCategoryList: this.fb.control(null),
        });
    }


    protected override afterLoadData() {
        let idIndustry = this.route.snapshot.params["idIndustry"];
        console.log("idIndustry="+idIndustry);

        this.crudServiceUtil.findAll<Key>({
            resourceName : 'industriesKeys'
        }).subscribe((response)=>{
            this.keyIndustry = response.content;
        });

        this.loadTable();

    }


    loadTable(){

        let actionList : Action[] = this.form.get("actionList")?.value;
        let keyActivityCategoryList : ActivityCategorySubactivity[] = this.form.get("industryKeyActivityCategoryList")?.value;

        if(keyActivityCategoryList!=null){

            keyActivityCategoryList.forEach((item : ActivityCategorySubactivity, index : number) => {
                item.count = index + 1;
                this.countActivity = index;
            });

            this.dataSourceACS = keyActivityCategoryList;
        }

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

                this.tableLoadDocument?.renderRows();
            });

        } else {
            this.dataSource = actionList;
        }

    }

    changeKey() {
        let key : Key = this.form.get("key")?.value;

        if(key.id!=null){
            this.updateActivity(key.id);
        }
    }

    updateActivity(id : number) {
        this.crudServiceUtil.findAllList<Activity>({
            resourceName :'industriesActivities',
            queryParams : {
                id : id
            }
        }).subscribe((response)=>{
            this.activityIndustry = response;
            this.form.get('activity')?.enable();
        });

    }

    updateCategory(id : number) : void {
        this.crudServiceUtil.findAllList<Category>({
            resourceName :'industriesCategories',
            queryParams : {
                id : id
            }
        }).subscribe((response)=>{
            this.categoryIndustry = response;
            this.subactivityIndustry = [];
            this.form.get('category')?.enable();
            this.form.get('subactivity')?.disable();
            this.disabledButonAddActity = true;
        });
    }

    updateSubactivity( id : number) : void {
        this.crudServiceUtil.findAllList<Subactivity>({
            resourceName :'industriesSubactivities',
            queryParams : {
                id : id
            }
        }).subscribe((response)=>{
            this.subactivityIndustry = response;
            this.form.get('subactivity')?.enable();
        });
    }

    addRow() {

    }

    openDialog(id : number) {

    }

    deleteRow(id : number) {

    }

    addActivity() {
        let activity : Activity = this.form.get("activity")?.value;
        let category : Category = this.form.get("category")?.value
        let subactivity : Subactivity = this.form.get("subactivity")?.value;
        let key : Key = this.form.get("key")?.value;

        let record : ActivityCategorySubactivity = {
            id : null,
            key : key,
            activity : activity,
            category : category,
            count   : this.countActivity++,
            subActivity : subactivity
        }

        this.dataSourceACS.push(record);
        this.tableLoadActivity?.renderRows();
    }

    deleteActivityRow(count : number) {
        console.log("register = "+count);
        this.dataSourceACS = this.dataSourceACS.filter(register=>register.count !== count);
        this.tableLoadActivity?.renderRows();
    }

    changeActivity() {
        let activity : Activity = this.form.get("activity")?.value;

        if(activity.id!=null)
            this.updateCategory(activity.id);
    }

    changeCategory() {

        let category : Category = this.form.get("category")?.value;

        if(category.id!=null)
            this.updateSubactivity(category.id);
    }


}
