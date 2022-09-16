import { AvisKey } from "./avis-key";

export class Avis {
    constructor(
        private _avisKey?: AvisKey,
        private _avis?: string,
        private _note?: number
    ) { }

    public get avisKey(): AvisKey | undefined {
        return this._avisKey;
    }

    public set avisKey(value: AvisKey | undefined) {
        this._avisKey = value;
    }

    public get avis(): string | undefined {
        return this._avis;
    }

    public set avis(value: string | undefined) {
        this._avis = value;
    }

    public get note(): number | undefined {
        return this._note;
    }

    public set note(value: number | undefined) {
        this._note = value;
    }
}
