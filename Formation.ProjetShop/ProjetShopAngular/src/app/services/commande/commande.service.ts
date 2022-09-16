import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande } from '../../models/commande/commande';
import { ConvertService } from '../convert.service';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private static URL: string =
    'http://localhost:8080/shop/api/commande';

  constructor(private httpClient: HttpClient, private convert: ConvertService) { }
  public getAll(): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(CommandeService.URL)
  }
  public getById(id: number): Observable<Commande> {
    return this.httpClient.get<Commande>(`${CommandeService.URL}/${id}`)
  }

  public create(Commande: Commande): Observable<Commande> {
    return this.httpClient.post<Commande>
      (`${CommandeService.URL}/${Commande.id}`, this.convert.commandeToJson(Commande)
      );
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${CommandeService.URL}/${id}`);
  }

  public getByClientId(id: number): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(`${CommandeService.URL}/client/${id}`)
  }
}
