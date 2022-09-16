import { Typepaiement } from "../enumerations/TypePaiement";


export class Facture {

  public constructor(
    private _tva?: number,
    private _remise?: number,
    public typePaiement?: Typepaiement,

  ) { }

  public get tva(): number | undefined {
    return this._tva;
  }

  public set tva(value: number | undefined) {
    this._tva = value;
  }


  public get remise(): number | undefined {
    return this._remise;
  }

  public set remise(value: number | undefined) {
    this._remise = value;
  }
  public get paiement(): Typepaiement | undefined {
    return this.typePaiement;
  }
  public set paiement(value: Typepaiement | undefined) {
    this.typePaiement = value;
  }
}

