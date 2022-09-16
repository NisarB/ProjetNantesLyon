import { Client } from "../client/client";
import { Article } from "./article";

export class AvisKey {
    constructor(
        private _client?: Client,
        private _article?: Article
    ) { }

    public get client(): Client | undefined {
        return this._client;
    }

    public set client(value: Client | undefined) {
        this._client = value;
    }

    public get article(): Article | undefined {
        return this._article;
    }

    public set article(value: Article | undefined) {
        this._article = value;
    }
}
