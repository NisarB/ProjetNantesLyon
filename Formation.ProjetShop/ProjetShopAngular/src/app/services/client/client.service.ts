import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/models/client/client';
import { ConvertService } from '../convert.service';
import { Commande } from 'src/app/models/commande/commande';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private static URL: string =
    'http://localhost:8080/shop/api/client';


  constructor(private httpClient: HttpClient, private convert: ConvertService) { }

  public getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(ClientService.URL)
  }
  public getById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(`${ClientService.URL}/${id}`)
  }
  public update(client: Client): Observable<Client> {
    console.log("Update", this.convert.clientToJson(client));
    return this.httpClient.put<Client>(`${ClientService.URL}/${client.id}`, this.convert.clientToJson(client))
  }
  public create(client: Client): Observable<Client> {
    console.log("Create", this.convert.clientToJson(client));
    return this.httpClient.post<Client>
      (`${ClientService.URL}/${client.id}`, this.convert.clientToJson(client)
      );
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ClientService.URL}/${id}`);
  }
  public findByUsername(username: string): Observable<Client> {
    return this.httpClient.get<Client>(`${ClientService.URL}/${username}`);
  }
  public getByIdWithCommandes(id: number): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(`${ClientService.URL}/${id}`)
  }
}
