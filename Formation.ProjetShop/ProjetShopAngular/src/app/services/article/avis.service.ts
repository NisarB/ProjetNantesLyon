import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/article/article';
import { Avis } from 'src/app/models/article/avis';
import { AvisKey } from 'src/app/models/article/avis-key';
import { ConvertService } from '../convert.service';

@Injectable({
  providedIn: 'root'
})
export class AvisService {
  static URL: string = 'http://localhost:8080/shop/api/avis';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) { }

  public getAll(): Observable<Avis[]> {
    return this.httpClient.get<Avis[]>(AvisService.URL);
  }

  public getById(id: AvisKey): Observable<Avis> {
    return this.httpClient.get<Avis>(`${AvisService.URL}/${id}`);
  }

  public getByIdArticle(aid: Article): Observable<Avis[]> {
    return this.httpClient.get<Avis[]>(`${AvisService.URL}/${aid}`);
  }


  public deleteById(id: AvisKey): Observable<void> {
    return this.httpClient.delete<void>(`${AvisService.URL}/${id}`);
  }

  public create(avis: Avis): Observable<Avis> {
    console.log("CREATE : ", this.convert.avisToJson(avis))
    return this.httpClient.post<Avis>(
      AvisService.URL, this.convert.avisToJson(avis)
    )
  }

  public update(avis: Avis): Observable<Avis> {
    console.log("UPDATE : " + this.convert.avisToJson(avis))

    return this.httpClient.put<Avis>(
      `${AvisService.URL}`,
      this.convert.avisToJson(avis)
    );
  }



  public findAvisOfClient(ak: AvisKey) {
    return this.httpClient.get<Avis>(`${AvisService.URL}/article/${ak.article?.id}/client/${ak.client?.id}`);

  }
} 
