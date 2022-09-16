import { Adresse } from "./adresse";
import { Commande } from "../commande/commande";
import { Utilisateur } from "../utilisateur";

export class Client extends Utilisateur {
  public constructor(
    id?: number,
    username?: string,
    password?: string,
    private _nom?: string,
    private _prenom?: string,
    private _mail?: string,
    private _tel?: string,
    private _adresse?: Adresse,
    private _commandes?: Commande[]

  ) {
    super(id, username, password);

  }
  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public get mail(): string | undefined {
    return this._mail;
  }

  public set mail(value: string | undefined) {
    this._mail = value;
  }
  public get tel(): string | undefined {
    return this._tel;
  }

  public set tel(value: string | undefined) {
    this._tel = value;
  }
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public get commande(): Commande[] | undefined {
    return this._commandes;
  }

  public set commande(value: Commande[] | undefined) {
    this._commandes = value;
  }
}
