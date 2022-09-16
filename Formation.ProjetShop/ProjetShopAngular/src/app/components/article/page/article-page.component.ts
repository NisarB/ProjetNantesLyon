import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/models/article/article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-article-page',
  templateUrl: './article-page.component.html',
  styleUrls: ['./article-page.component.css']
})
export class ArticlePageComponent implements OnInit {

  article: Article;


  constructor(
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.article = new Article();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.articleService.getById(params['id']).subscribe((result) => {
          this.article = result;
        });
      }
    });
  }



  addPanier(article: Article) {

    let panier = JSON.parse(sessionStorage.getItem('panier')!)
    console.log(panier)
    panier.set(article.id, article)
    sessionStorage.setItem('panier', JSON.stringify(panier))
    console.log(JSON.parse(sessionStorage.getItem('panier')!))

  }
}
