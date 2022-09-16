import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article/article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  article: Article[] = [];

  constructor(private articleService: ArticleService,
  ) { }

  ngOnInit(): void {
    this.articleService.getAll().subscribe((result) => {
      this.article = result.slice(0, 4)
    });
  }

}
