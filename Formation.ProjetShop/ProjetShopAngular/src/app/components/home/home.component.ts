import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/models/article/article';
import { Categorie } from 'src/app/models/categorie';
import { Client } from 'src/app/models/client/client';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  categorieEnum = Categorie;
  article: Article[] = [];
  ActiveUser: Client;

  constructor(
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    let x = sessionStorage.getItem('user');
    this.ActiveUser = JSON.parse(x!)
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.articleService.getAll().subscribe((result) => {
        this.article = result.slice(0, 4)
      });
    });


  }

}
