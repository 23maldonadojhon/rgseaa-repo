import {Component, Inject, OnInit, ViewChild} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {TswSelectModule} from "@base/shared/select";
import {MatTable, MatTableModule} from "@angular/material/table";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {DatePipe} from "@angular/common";
import {Document} from "@libs/sdk/document";
import {fileToB64} from "@libs/file";
import {DialogService} from "@base/pages/industry/dialog-file/dialog-file.service";
import {ActionDocument} from "@libs/sdk/action";


const ELEMENT_DATA: Document[] = [];

@Component({
    selector: 'dialog-file-industry',
    templateUrl: './dialog-file.component.html',
    standalone: true,
    imports: [
        MatDialogModule,
        MatButtonModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        TswSelectModule,
        MatTableModule,
        ReactiveFormsModule,
        MatIconModule,
        DatePipe
    ]
})
export class DialogFileComponent implements OnInit{

    private url = '';

    private contadorId = 1;

    displayedColumns: string[] = ['date','out','type','description','openFile','delete'];
    dataSource = [...ELEMENT_DATA];
    form: FormGroup;
    selectedFile : File | undefined;
    @ViewChild(MatTable) table: MatTable<Document> | undefined;



    constructor(
            private dialogService : DialogService,
            private fb: FormBuilder,
            public dialogRef: MatDialogRef<DialogFileComponent>,
            @Inject(MAT_DIALOG_DATA) public data: any
        ) {

        this.form = this.fb.group({
            name : this.fb.control(null),
            typeDocument : this.fb.control(null),
            date : this.fb.control(null),
        });
    }

    ngOnInit(): void {
        console.log("Industry=>ngOnInit")
        if (this.data && this.data.id) {
            console.log("Industry=>ngOnInit=>DATA")
            this.dialogService.getDocumentList(this.data.id).subscribe(
                (response) => {
                    this.dataSource = response;
                    this.table?.renderRows();
                }
            );
        }

    }


    onFileSelected(event: any): void {
        this.selectedFile = event.target.files[0];
    }

    addFile() : void {

        let nuevoRegistro: Document = this.form.value;

        if (this.selectedFile) {

            fileToB64(this.selectedFile).then(result=>{
                nuevoRegistro.b64 = result;
            });

        }

        const pipe = new DatePipe('en-US');

        nuevoRegistro.counter =  this.contadorId++;

        this.dataSource.push(nuevoRegistro);

        this.table?.renderRows();

        this.form.reset();
    }


    deleteFile(counter : number) : void {
        this.dataSource = this.dataSource.filter(register=>register.counter !== counter);
        this.table?.renderRows();
        this.form.reset();
    }


    downloadFile(id : number) {

        const register = this.dataSource.find(item=>item.id==id);
        const reader = new FileReader();

        if(register?.b64.data!=undefined){
         const file = this.base64AFile(register?.b64.data, register?.b64.name);

            if(file!=undefined) {
                const url = URL.createObjectURL(file);
                const a = document.createElement('a');
                a.href = url;
                a.download = file.name; // Esto le dará al archivo el mismo nombre que tenía originalmente
                document.body.appendChild(a);
                a.click();
                window.URL.revokeObjectURL(url);
                a.remove();
            }

        }
    }

    closeDialog(): void {

        let dataReturn : ActionDocument  = {
            id : this.data.id,
            result : this.dataSource
        };

        this.dialogRef.close(dataReturn);
    }

    base64AFile(base64: string, name : string) : File {

        // Elimina el prefijo de la cadena Base64 si existe
        const base64SinPrefijo = base64.split(';base64,').pop();

        // Convierte la cadena Base64 a un array de bytes
        const contenido = base64SinPrefijo ? atob(base64SinPrefijo) : '';
        const arrayBytes = new Uint8Array(contenido.length);

        for (let i = 0; i < contenido.length; i++) {
            arrayBytes[i] = contenido.charCodeAt(i);
        }

        // Crea el blob a partir del array de bytes
        const blob = new Blob([arrayBytes], { type: 'tipo/mime' }); // Reemplaza 'tipo/mime' con el tipo MIME real del archivo

        // Crea y retorna el objeto File
        return new File([blob], name, { type: 'tipo/mime' });

    }



}
