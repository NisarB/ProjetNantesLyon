import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/article/article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  obsArticle: Observable<Article[]>;
  constructor(private articleService: ArticleService,
    private activatedRoute: ActivatedRoute) {
    this.obsArticle = this.articleService.getAll();
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.articleService.deleteById(id).subscribe(() => {
      this.obsArticle = this.articleService.getAll();
    });
  }

}
