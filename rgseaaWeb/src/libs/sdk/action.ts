import {TypeAction} from "@libs/sdk/type-action";
import {Document} from "@libs/sdk/document";

export interface Action {
    id                  : number | null;
    description         : string | null;
    typeAction          : TypeAction | null;
    documentList        : Document[] | null;
    count               : number | null;
    update              : number;
}


export interface ActionDocument {
    id        : number | null;
    result    : Document[] | null;
}
