import {Activity} from "@libs/sdk/activity";
import {Category} from "@libs/sdk/category";
import {Subactivity} from "@libs/sdk/Subactivity";
import {Key} from "@libs/sdk/key";

export interface ActivityCategorySubactivity {
    id      : number | null;
    key     : Key | null;
    activity : Activity | null;
    category : Category | null;
    subActivity : Subactivity | null;
    count : number;
}
