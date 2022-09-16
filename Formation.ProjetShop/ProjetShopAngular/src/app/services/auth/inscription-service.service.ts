import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InscriptionServiceService {
  private static URL: string =
    'http://localhost:8080/shop/api/auth/inscription';
  constructor(private httpClient: HttpClient) { }

  public checkClientExist(username: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      'http://localhost:8080/shop/api/auth/check/' + username
    );
  }

  public inscription(utilisateur: any): Observable<any> {
    console.log(utilisateur)
    return this.httpClient.post<any>(InscriptionServiceService.URL, utilisateur);
  }
}
