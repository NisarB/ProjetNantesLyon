import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/models/article/article';
import { ArticleService } from 'src/app/services/article/article.service';
import { Categorie } from 'src/app/models/categorie';

@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.css']
})
export class ArticleEditComponent implements OnInit {
  article: Article;
  categorieEnum = Categorie;

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

  save() {
    if (this.article.id) {
      this.articleService.update(this.article).subscribe(() => {
        this.router.navigateByUrl('/article-list?q=update&id=' + this.article.id);
      });
    } else {
      this.articleService.create(this.article).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/article-list?q=create&id=' + result.id);
        },
        error: (error) => {
          console.log(error)
        }
      })
    }
  }



}
