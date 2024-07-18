import {TypeDocument} from "@libs/sdk/type-document";
import {B64EncodedFile} from "@libs/file";

export interface Document {
    id              : number;
    counter         : number;
    name            : string;
    date            : string;
    typeDocument    : TypeDocument;
    b64             : B64EncodedFile;
    update          : number;
}
