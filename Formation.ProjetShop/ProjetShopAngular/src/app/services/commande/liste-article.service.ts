import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListeArticle } from '../../models/commande/liste-article';
import { ConvertService } from '../convert.service';

@Injectable({
  providedIn: 'root'
})
export class ListeArticleService {
  private static URL: string =
    'http://localhost:8080/shop/api/liste-article'

  constructor(private httpClient: HttpClient, private convert: ConvertService) { }
  public getAll(): Observable<ListeArticle[]> {
    return this.httpClient.get<ListeArticle[]>(ListeArticleService.URL)
  }
  public getById(id: number): Observable<ListeArticle> {
    return this.httpClient.get<ListeArticle>(`${ListeArticleService.URL}/${id}`)
  }

  public create(listeArticle: ListeArticle): Observable<ListeArticle> {

    return this.httpClient.post<ListeArticle>(
      ListeArticleService.URL, this.convert.listeToJson(listeArticle)
    )
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ListeArticleService.URL}/${id}`);
  }
}




