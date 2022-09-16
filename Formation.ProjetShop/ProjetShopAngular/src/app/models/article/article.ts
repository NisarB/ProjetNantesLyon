import { Avis } from "./avis";
import { Categorie } from "../categorie";

export class Article {
    constructor(
        private _id?: number,
        private _nom?: string,
        private _categorie?: Categorie,
        private _description?: string,
        private _prix?: number,
        private _note?: number,
        private _stock?: number,
        private _avis?: Avis[]
    ) { }

    public get id(): number | undefined {
        return this._id;
    }

    public set id(value: number | undefined) {
        this._id = value;
    }

    public get nom(): string | undefined {
        return this._nom;
    }

    public set nom(value: string | undefined) {
        this._nom = value;
    }

    public get categorie(): Categorie | undefined {
        return this._categorie;
    }

    public set categorie(value: Categorie | undefined) {
        this._categorie = value;
    }


    public get description(): string | undefined {
        return this._description;
    }

    public set description(value: string | undefined) {
        this._description = value;
    }

    public get prix(): number | undefined {
        return this._prix;
    }

    public set prix(value: number | undefined) {
        this._prix = value;
    }

    public get note(): number | undefined {
        return this._note;
    }

    public set note(value: number | undefined) {
        this._note = value;
    }

    public get stock(): number | undefined {
        return this._stock;
    }

    public set stock(value: number | undefined) {
        this._stock = value;
    }

    public get avis(): Avis[] | undefined {
        return this._avis
    }

    public addAvis(value: Avis) {
        this._avis?.push(value)
    }


}
