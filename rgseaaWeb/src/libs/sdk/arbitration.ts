import {SimpleModel, StatefulModel, TranslatedModel} from './common';
import {AppQuerySource} from "@libs/commons";

export interface Arbitration extends SimpleModel, StatefulModel, TranslatedModel {

    boardType: Record<string, any> | null;
    claimant: ClaimantForm | null;
    notificationType: Record<string, any> | null;
    claimed: ClaimantForm | null;
    reason: string | null;
    aspiration: string | null;
    observation: string | null;
}


export interface LocationForm {
    id: number | null;
    roadType: Record<string, any> | null;
    address: string | null;
    number: string | null;
    block: string | null;
    portal: string | null;
    ladder: string | null;
    floor: string | null;
    door: string | null;
    town: Record<string, any> | null;
    province: Record<string, any> | null;
    postalCode: string | null;
}

export interface ClaimantForm {
    id: number | null;
    claimantType: number | null;
    name: string | null;
    socialReason: string | null;
    claimantNif: string | null;
    surnames: string | null;
    phone: string | null;
    email: string | null;
    location: LocationForm | null;
}

export interface ArbitrationForm {
    id: number | null;

    boardType: Record<string, any> | null;
    claimant: ClaimantForm | null;
    notificationType: Record<string, any> | null;
    claimed: ClaimantForm | null;
    reason: string | null;
    aspiration: string | null;
    observation: string | null;
}

export interface ArbitrationFilterForm extends AppQuerySource {

    claimedSocialReason?: string;
    claimedNif?: string;
    createdAtGTE?: string;
    createdAtLTE?: string;
    updatedAtGTE?: string;
    updatedAtLTE?: string;
}
