import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Article } from 'src/app/models/article/article';
import { Observable } from 'rxjs';
import { ConvertService } from '../convert.service';
import { AvisKey } from 'src/app/models/article/avis-key';



@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  static URL: string = 'http://localhost:8080/shop/api/article';
  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) { }

  public getAll(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(ArticleService.URL);
  }

  public getById(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`${ArticleService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ArticleService.URL}/${id}`);
  }

  public update(article: Article): Observable<Article> {
    return this.httpClient.put<Article>(
      `${ArticleService.URL}/${article.id}`,
      this.convert.articleToJson(article)
    );
  }

  public create(article: Article): Observable<Article> {
    return this.httpClient.post<Article>(
      ArticleService.URL,
      this.convert.articleToJson(article)
    );
  }


}
