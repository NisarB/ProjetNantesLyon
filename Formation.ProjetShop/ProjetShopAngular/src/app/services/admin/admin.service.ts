import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/models/admin/admin';
import { ConvertService } from '../convert.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private static URL: string =
    'http://localhost:8080/shop/api/admin';

  constructor(private httpClient: HttpClient, private convert: ConvertService) { }

  public getAll(): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>(AdminService.URL)
  }
  public getById(id: number): Observable<Admin> {
    return this.httpClient.get<Admin>('AdminService.URL/${id}')
  }
  public update(admin: Admin): Observable<Admin> {
    return this.httpClient.put<Admin>('AdminService.URL/${id}', this.convert.adminToJson)
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>('AdminService.URL/${id}');
  }
  public create(admin: Admin): Observable<Admin> {
    return this.httpClient.post<Admin>
      ('AdminService.URL/${id}', this.convert.adminToJson(admin));
  }
}