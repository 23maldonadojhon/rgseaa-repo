import {ChangeDetectorRef, Component, QueryList, ViewChild, ViewChildren} from "@angular/core";
import {FORM_STATUS} from "@base/shared/components/form";
import {ComponentStatus, ControlsOf, FormMapper} from "@libs/commons";
import {EditPageBaseComponent} from "@base/shared/pages/edit-page-base.component";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Industry, IndustryCreate, IndustryList} from "@libs/sdk/industry";
import {ActivatedRoute, Router} from "@angular/router";
import {NamedRoutes} from "@libs/named-routes";
import {NotificationService} from "@base/shared/notification";
import {CrudImplService} from "@libs/crud-api";
import {MatDialog} from "@angular/material/dialog";
import {Authorization} from "@libs/sdk/authorization";
import {SelectionModel} from "@angular/cdk/collections";
import {TypeAction} from "@libs/sdk/type-action";
import {Action} from "@libs/sdk/action";
import {MatTable} from "@angular/material/table";
import {DialogFileComponent} from "@base/pages/industry/dialog-file/dialog-file.component";
import {MatCheckbox} from "@angular/material/checkbox";
import {Country} from "@libs/sdk/country";
import {Province} from "@libs/sdk/province";
import {Location} from "@libs/sdk/location";
import {Key} from "@libs/sdk/key";
import {Activity} from "@libs/sdk/activity";
import {Category} from "@libs/sdk/category";
import {Subactivity} from "@libs/sdk/Subactivity";
import {ActivityCategorySubactivity} from "@libs/sdk/activity-category-subactivity";
import {DialogFindComponent} from "@base/pages/industry/dialog-find/dialog-find.component";

@Component({
    selector: 'tsw-industry-edit-page',
    templateUrl: '/industry-edit.component.html',
    providers: [
        { provide: FORM_STATUS, useValue: new ComponentStatus('IDLE') }
    ]
})
export class IndustryEditComponent extends EditPageBaseComponent<Industry,IndustryCreate>{

    idIndustry : number | undefined;
    displayedColumns: string[] = ['activity', 'category', 'subactivity', 'delete'];
    protected displayedColumnsActuation: string[] = ['date', 'type-name', 'description', 'files','actions'];
    displayedColumnsAuthorization: string[] = ['name', 'select'];
    protected countTypeAction : number = 1;
    protected countActivity : number = 1;
    countryBusiness : Country[] = [];
    provinceBusiness : Province[] = [];
    locationBusiness : Location[] = [];
    countryIndustry : Country[] = [];
    provinceIndustry : Province[] = [];
    locationIndustry : Location[] = [];
    activityIndustry : Activity[] = [];
    categoryIndustry : Category[] = [];
    subactivityIndustry : Subactivity[] = [];
    keyIndustry : Key[] = [];

    authorizationData : Authorization[] = [];
    dataSource : Action[] = [];
    dataSourceACS : ActivityCategorySubactivity[] = [];
    readonly resourceName = 'industries';
    selection = new SelectionModel<any>(true, []);

    disabledButonAddActity : boolean = false;

    @ViewChild('table1') tableLoadDocument: MatTable<Action> | undefined;
    @ViewChild('tableActivity') tableLoadActivity: MatTable<Action> | undefined;
    @ViewChildren(MatCheckbox) checkboxes: QueryList<MatCheckbox> | undefined;
    constructor(
        crudService: CrudImplService<Industry>,
        fb: FormBuilder,
        route: ActivatedRoute,
        router: Router,
        namedRoutes: NamedRoutes,
        notification: NotificationService,
        mapper: FormMapper<Industry,IndustryCreate>,
        dialog : MatDialog,
        crudServiceUtil :CrudImplService,
        private cdr: ChangeDetectorRef
    ) {
        super(crudService, fb, route, router, namedRoutes, notification, mapper,dialog,crudServiceUtil);
    }




    protected override afterLoadData() {

        console.log("=== INGRESO AQUI ====")
        super.afterLoadData();


        this.crudServiceUtil.findAll<Key>({
            resourceName : 'industriesKeys'
        }).subscribe((response)=>{
            this.keyIndustry = response.content;
        });

        this.crudServiceUtil.findAll<Country>({
            resourceName: 'industriesCountries'
        }).subscribe((response)=>{
            this.countryBusiness = response.content;
            this.countryIndustry = response.content;

            if(!this.isNew){

                this.idIndustry = this.route.snapshot.params['id'];

                console.log("this.idIndustry="+this.idIndustry)

                let countryInd = this.countryIndustry.find(item=>item.id===this._srcData?.countryIndustry?.id);
                let countryBus = this.countryBusiness.find(item=>item.id===this._srcData?.countryBusiness?.id);
                let keySelect = this.keyIndustry.find(item=>item.id===this._srcData?.key?.id);

                this.form.get("countryIndustry")?.setValue(countryInd);
                this.form.get("countryBusiness")?.setValue(countryBus);
                this.form.get("key")?.setValue(keySelect);
                // @ts-ignore
                this.updateProvinceIndustry(countryInd.id);
                // @ts-ignore
                this.updateProvince(countryBus.id);

            }

        });

        this.crudServiceUtil.findAll<Authorization>({
            resourceName: 'industriesAuthorizations'
        }).subscribe((response)=>{
            this.authorizationData = response.content;
            this.checkAuthorization();
        });

        this.loadTable();

        this.cdr.detectChanges(); // Forzar la detección de cambios

        this.form.get('locationIndustry')?.disable();
        this.form.get('locationBusiness')?.disable();
        this.form.get('provinceIndustry')?.disable();
        this.form.get('provinceBusiness')?.disable();
        this.form.get('activity')?.disable();
        this.form.get('category')?.disable()
        this.form.get('subactivity')?.disable();

        if(!this.isNew){
            this.changeKey();
            this.form.get('activity')?.enable();
        }

    }


    checkAuthorization(){
        console.log("checkAuthorization");

        let authorizationList :Authorization[] = this.form.get("authorizationList")?.value;

        console.log("authorizationList ="+authorizationList);

        if(authorizationList!=null)
            authorizationList.forEach(data=>{
                console.log("DATA A NARCAR ="+data);
                this.selection.setSelection(data);
            })

    }



    isChecked(element : Authorization) : boolean{

        let authorizationList :Authorization[] = this.form.get("authorizationList")?.value;

        if(authorizationList!=null) {
            let response = authorizationList.some(item => {
                return item.id === element.id;
            });
            return response;

        } else {
            return false;
        }

    }

    toggleSelection(item: any) {
        this.selection.toggle(item);
        this.cdr.detectChanges();
        // No es estrictamente necesario llamar a detectChanges aquí si estás dentro de la zona de Angular
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

    protected buildForm(): FormGroup<ControlsOf<IndustryCreate>> {

        return this.fb.group<ControlsOf<IndustryCreate>>({
            id:             this.fb.control(null),
            numBusiness:    this.fb.control({ value: 0, disabled: true }),
            key:            this.fb.control(null),
            numberIndustry: this.fb.control(null),
            enrollment:     this.fb.control(null),
            numRegCcaa:     this.fb.control(null),
            situation:      this.fb.control(null),
            nameBusiness:   this.fb.control(null),
            cif:            this.fb.control(null),

            countryBusiness:        this.fb.control(null),
            provinceBusiness:       this.fb.control(null),
            locationBusiness:       this.fb.control(null),
            postalCodeBusiness:     this.fb.control(null),
            addressBusiness:        this.fb.control(null),

            countryIndustry:        this.fb.control(null),
            provinceIndustry:       this.fb.control(null),
            locationIndustry:       this.fb.control(null),
            postalCodeIndustry:     this.fb.control(null),
            addressIndustry:        this.fb.control(null),
            addressInstallation:    this.fb.control(null),

            activity:               this.fb.control(null),
            category:               this.fb.control(null),
            subactivity:            this.fb.control(null),

            dateRequest:            this.fb.control(null),
            dateInscription:        this.fb.control(null),
            email:                  this.fb.control(null),
            observation:            this.fb.control(null),
            pageWeb:                this.fb.control(null),

            typeAction:             this.fb.control(null),
            actionList:             this.fb.control(null),
            authorizationList:      this.fb.control(null),
            industryKeyActivityCategoryList: this.fb.control(null),
        });

    }

    // Método para verificar si todos los elementos están seleccionados (útil para select all)
    isAllSelected() {
        const numSelected = this.selection.selected.length;
        const numRows = this.dataSource.length;
        return numSelected === numRows;
    }

    // Método para seleccionar/deseleccionar todos los elementos
    masterToggle() {
        this.isAllSelected() ?
            this.selection.clear() :
            this.dataSource.forEach(row => this.selection.select(row));
    }

    checkboxLabel(row?: any): string {
        if (!row) {
            return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
        }
        return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id}`;
    }

    openDialog(id : number) {

        console.log("openDialog="+id);

        const dialogRef = this.dialog.open(DialogFileComponent,{
            //width: '75%',
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


    addActivity() : void {

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
            this.tableLoadDocument?.renderRows();
        }
    }


    deleteActivityRow(count : number) {
        console.log("register = "+count);
        this.dataSourceACS = this.dataSourceACS.filter(register=>register.count !== count);
        this.tableLoadActivity?.renderRows();
    }

    deleteRow(count : number) {

        let action = this.dataSource.find(item=>item.id==count);

        if(action){
            action.update=1;
            action.documentList = null;
            action.typeAction = null;
            action.description = null;
        }

        this.tableLoadDocument?.renderRows();
    }

    override submitForm() {
        this.form.get('authorizationList')?.setValue(this.selection.selected);
        this.form.get('actionList')?.setValue(this.dataSource);
        this.form.get('industryKeyActivityCategoryList')?.setValue(this.dataSourceACS);

        super.submitForm();
    }


    changeCategory() : void {

        let category : Category = this.form.get("category")?.value;

        if(category.id!=null)
            this.updateSubactivity(category.id);
    }

    changeActivity() : void {

        let activity : Activity = this.form.get("activity")?.value;

        if(activity.id!=null)
            this.updateCategory(activity.id);
    }

    changeKey() {
        let key : Key = this.form.get("key")?.value;

        if(key.id!=null){
            this.updateActivity(key.id);
        }
    }

    changeCountry(){
        let country : Country = this.form.get("countryBusiness")?.value;

        if (country.id == 1) {
            this.form.get("provinceBusiness")?.enable();
            this.updateProvince(country.id);
        } else {
            this.form.get("provinceBusiness")?.setValue(null);
            this.form.get("locationBusiness")?.setValue(null);
            this.form.get("provinceBusiness")?.disable();
            this.form.get("locationBusiness")?.disable();
        }
    }

    changeCountryIndustry(){
        let country : Country = this.form.get("countryIndustry")?.value;

        if (country.id == 1) {
            this.form.get("provinceIndustry")?.enable();
            this.updateProvinceIndustry(country.id);
        } else {
            this.form.get("provinceIndustry")?.setValue(null);
            this.form.get("locationIndustry")?.setValue(null);
            this.form.get("provinceIndustry")?.disable();
            this.form.get("locationIndustry")?.disable();
        }
    }

    changeProvince(){

        let province : Country = this.form.get("provinceBusiness")?.value;

        if (province.id != null) {
            this.form.get("locationBusiness")?.enable();
            this.updateLocation(province.id);
        } else {
            this.form.get("locationBusiness")?.disable();
        }
    }


    changeProvinceIndustr(){

        let province : Country = this.form.get("provinceIndustry")?.value;

        if (province.id != null) {
            this.form.get("locationIndustry")?.enable();
            this.updateLocationIndustry(province.id);
        } else {
            this.form.get("locationIndustry")?.disable();
        }
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

    updateProvince(id : number) {

        this.crudServiceUtil.findAll<Province>({
            resourceName: 'industriesProvinces',
            queryParams : {
                id : id
            }
        }).subscribe((response)=>{
            this.provinceBusiness = response.content;

            if(!this.isNew){
                let province = this.provinceBusiness.find(item=>item.id===this._srcData?.provinceBusiness?.id);
                this.form.get("provinceBusiness")?.setValue(province);

                // @ts-ignore
                this.updateLocation(province?.id);
            }
        });

    }

    updateProvinceIndustry(id : number) {

        this.crudServiceUtil.findAll<Province>({
            resourceName: 'industriesProvinces',
            queryParams : {
                id : id
            }
        }).subscribe((response)=>{
            this.provinceIndustry = response.content;

            if(!this.isNew){
                let provinceInd = this.provinceIndustry.find(item=>item.id===this._srcData?.provinceIndustry?.id);
                this.form.get("provinceIndustry")?.setValue(provinceInd);

                // @ts-ignore
                this.updateLocationIndustry(provinceInd?.id);
            }

        });

    }


    updateLocation(id : number){

        this.crudServiceUtil.findAll<Location>({
            resourceName: 'industriesLocations',
            queryParams : {
                provinceId : id
            }
        }).subscribe((response)=>{
            this.locationBusiness = response.content;

            if(!this.isNew){
                let location = this.locationBusiness.find(item=>item.id===this._srcData?.locationBusiness?.id);
                this.form.get("locationBusiness")?.setValue(location);
            }

        });
    }

    updateLocationIndustry(id : number){

        this.crudServiceUtil.findAll<Location>({
            resourceName: 'industriesLocations',
            queryParams : {
                provinceId : id
            }
        }).subscribe((response)=>{
            this.locationIndustry = response.content;

            if(!this.isNew){
                let location = this.locationIndustry.find(item=>item.id===this._srcData?.locationIndustry?.id);
                this.form.get("locationIndustry")?.setValue(location);
            }
        });
    }


    lostFocus() {

        let nameBusiness : string = this.form.get("nameBusiness")?.value;

        this.crudServiceUtil.findAllList<IndustryList>({
            resourceName: 'industriesFinds',
            queryParams : {
                name : nameBusiness
            }
        }).subscribe((response)=>{
            console.log("dato="+response)
            if(response.length>0){
                const dialogRef = this.dialog.open(DialogFindComponent,{
                    //width: '75%',
                    data: {
                        response: response
                    }
                });
            }
        });

    }

}
