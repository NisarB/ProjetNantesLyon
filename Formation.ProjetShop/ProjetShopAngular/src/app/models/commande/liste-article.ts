import { Commande } from "./commande";
import { Article } from "../article/article";
import { ListeArticleKey } from "./liste-article-key";

export class ListeArticle {
  public constructor(
    private _listeKey?: ListeArticleKey,
    private _quantite?: number
  ) { }

  public get quantite(): number | undefined {
    return this._quantite;
  }

  public set quantite(value: number | undefined) {
    this._quantite = value;
  }
  public get listeKey(): ListeArticleKey | undefined {
    return this._listeKey;
  }

  public set listeKey(value: ListeArticleKey | undefined) {
    this._listeKey = value;
  }
}
