import { Component, OnInit } from '@angular/core';
import { Avis } from 'src/app/models/article/avis';
import { ActivatedRoute, Router } from '@angular/router';
import { AvisService } from 'src/app/services/article/avis.service';
import { ArticleService } from 'src/app/services/article/article.service';
import { Article } from 'src/app/models/article/article';


@Component({
  selector: 'app-avis-list',
  templateUrl: './avis-list.component.html',
  styleUrls: ['./avis-list.component.css']
})
export class AvisListComponent implements OnInit {
  article: Article;
  avis: any[] = [];

  constructor(
    private avisService: AvisService,
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.article = new Article()
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.articleService.getById(params['id']).subscribe((result) => {
          this.article = result;
        });
      }
    });

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.avisService.getByIdArticle(params['id']).subscribe((result) => {
          this.avis = result;
        });
      }
    });

  }


}
