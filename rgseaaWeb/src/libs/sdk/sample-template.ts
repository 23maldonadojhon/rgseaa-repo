import {SimpleModel, StatefulModel, TranslatedModel} from '@libs/sdk/common';
import {SampleDataset, SampleDatasetSave} from '@libs/sdk/sample-dataset';
import {AppQuerySource} from '../commons';


export interface AppSampleTemplate extends SimpleModel, SampleDataset, StatefulModel, TranslatedModel {
    templateId: number | null;
    datasetId: number | null;
    scopeCode: string | null;

    moduleName: string;
    moduleCode: string;

    seasonName: string;

    name: string;
    sharedAccess: boolean;
}

export interface VAppSampleTemplate extends SimpleModel, StatefulModel, TranslatedModel {
    sampleDatasetId: number;
    name: string;
    sharedAccess: boolean;
    scopeCode: string;
    moduleId: number;
    seasonId: number;
    seasonName: string;
    providerEntity: string;
    useRangeFrom: Date;
    useRangeUntil: Date;
    ownerId: number;
    state: number;
}

export interface AppSampleTemplateSave extends SimpleModel<number | null>, SampleDatasetSave {
    templateId: number | null;
    name: string | null;
    sharedAccess: boolean;
}

export interface AppSampleTemplateFilterForm extends AppQuerySource {
    name?: string,
    sharedAccess?: boolean,
    seasonName?: string,
    useRangeFrom?: string,
    useRangeUntil?: string,
    state?: number[];
}
