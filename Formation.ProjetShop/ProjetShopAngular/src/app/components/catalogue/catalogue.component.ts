import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/models/article/article';
import { ArticleService } from 'src/app/services/article/article.service';
import { Categorie } from 'src/app/models/categorie';
import * as $ from 'jquery';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})

export class CatalogueComponent implements OnInit {

  categorieEnum = Categorie;
  article: Article[] = [];
  SearchFilter: string = '';
  CategorieFilter: Categorie | undefined;


  constructor(
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['ckey']) {
        this.CategorieFilter = params['ckey'];
      }
    });
    this.activatedRoute.params.subscribe((params) => {
      this.articleService.getAll().subscribe((result) => {
        this.article = result;
      });
    });

    $("#showFilters").on("click", function () {
      $("#filters").slideToggle("slow");
    });

  }

  get filterArticle(): Article[] {

    return this.article.filter((a: Article) => {
      if (this.SearchFilter) {
        return a.nom?.indexOf(this.SearchFilter) != -1
      }
      if (this.CategorieFilter) {
        return a.categorie == this.CategorieFilter
      }
      else {
        return true
      }
    })
  }

}
