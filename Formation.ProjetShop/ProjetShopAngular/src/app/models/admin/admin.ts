import { Utilisateur } from "../utilisateur";

export class Admin extends Utilisateur {
  public constructor(
    id?: number,
    username?: string,
    password?: string,
    private _version?: number
  ) {
    super(id, username, password);
  }


}
