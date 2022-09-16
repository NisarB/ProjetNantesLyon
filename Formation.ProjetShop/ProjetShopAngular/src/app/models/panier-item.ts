import { Article } from "./article/article";

export class PanierItem {
    constructor(
        private _article?: number,
        private _quantite?: number
    ) { }

    public get article(): number | undefined {
        return this._article;
    }

    public set article(value: number | undefined) {
        this._article = value;
    }

    public get quantite(): number | undefined {
        return this._quantite;
    }

    public set quantite(value: number | undefined) {
        this._quantite = value;
    }
}
