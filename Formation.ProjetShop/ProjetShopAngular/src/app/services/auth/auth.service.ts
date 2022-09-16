import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) {}

  public authentication(username: string, password: string): Observable<any> {
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(username + ':' + password),
    });

    return this.httpClient.get('http://localhost:8080/shop/api/auth', {
      headers: headers,
    });
  }

  public get authenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }
}

