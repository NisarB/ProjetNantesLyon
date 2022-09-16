import { Role } from "./enumerations/role"
export class Utilisateur {

  constructor(
    private _id?: number,
    private _username?: string,
    private _password?: string,
    private _role?: Role
  ) { }
  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }
  public get username(): string | undefined {
    return this._username;
  }
  public set username(value: string | undefined) {
    this._username = value;
  }

  public get password(): string | undefined {
    return this._password;
  }

  public set password(value: string | undefined) {
    this._password = value;
  }
  public get role(): Role | undefined {
    return this._role;
  }

  public set role(value: Role | undefined) {
    this._role = value;
  }

}
