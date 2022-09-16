import { FactoryOrValue } from "rxjs";
import { Article } from "../article/article";
import { Client } from "../client/client";
import { Facture } from "./facture";
import { ListeArticle } from "./liste-article";

export class Commande {
  constructor(
    private _id?: number,
    private _client?: Client,
    private _date?: Date,
    public _facture?: Facture,
    private _articles?: ListeArticle[]
  ) { }
  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }
  public get client(): Client | undefined {
    return this._client;
  }

  public set client(value: Client | undefined) {
    this._client = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get listeArticle(): ListeArticle[] | undefined {
    return this._articles;
  }

  public set listeArticle(value: ListeArticle[] | undefined) {
    this._articles = value;
  }
  public get facture(): Facture | undefined {
    return this._facture;
  }

  public set facture(value: Facture | undefined) {
    this._facture = value;
  }

}
