import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/article/article';
import { Avis } from 'src/app/models/article/avis';
import { AvisKey } from 'src/app/models/article/avis-key';
import { Client } from 'src/app/models/client/client';
import { ArticleService } from 'src/app/services/article/article.service';
import { AvisService } from 'src/app/services/article/avis.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-avis-add',
  templateUrl: './avis-add.component.html',
  styleUrls: ['./avis-add.component.css']
})
export class AvisAddComponent implements OnInit {
  article: Article;
  client: Client;
  avis: Avis;
  avisKey: AvisKey;
  test: any;

  boolean: boolean = false

  constructor(
    private articleService: ArticleService,
    private avisService: AvisService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.article = new Article()
    this.client = JSON.parse(sessionStorage.getItem('user')!)
    this.avis = new Avis()
    this.avisKey = new AvisKey()
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.articleService.getById(params['id']).subscribe((result) => {
          this.article = result;
          this.avisKey.article = this.article
          let x = sessionStorage.getItem('user');
          this.client = JSON.parse(x!)
          this.avisKey.client = this.client

          this.avisService.findAvisOfClient(this.avisKey).subscribe({
            next: (result) => {
              this.test = result;
            },
            error: (error) => {
              this.test = null;
            }
          });
        });
      }
    });



  }

  save(avisForm: any) {

    console.log(this.avisKey) // UNDEFINED BIZARREMENT
    let form = avisForm as FormGroup
    this.avis.note = form.controls["avis-note"].value
    this.avis.avis = form.controls["avis-texte"].value
    this.avisKey.article = this.article
    this.avisKey.client = this.client
    this.avis.avisKey = new AvisKey(this.client, this.article)




    if (this.test) {

      this.avisService.update(this.avis).subscribe((result) => {
      });
      console.log("Plop if ")
    }
    else {

      this.avisService.create(this.avis).subscribe((result) => {

      })
      console.log("Plop")
    }

  }

}
