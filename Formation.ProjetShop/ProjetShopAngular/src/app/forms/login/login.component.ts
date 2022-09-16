import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/models/article/article';
import { ListeArticle } from 'src/app/models/commande/liste-article';
import { AuthService } from 'src/app/services/auth/auth.service';
import { PanierItem } from 'src/app/models/panier-item';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  authError = false;
  signed = false;
  panier = new Map();

  constructor(
    private authService: AuthService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['signed']) {
        this.signed = params['signed']
      }
    });
  }


  submit() {
    this.authService.authentication(this.username, this.password).subscribe({
      next: (result) => {
        sessionStorage.setItem('token', btoa(this.username + ':' + this.password));
        this.authError = false;
        sessionStorage.setItem('user', JSON.stringify(result));
        this.router.navigateByUrl('/');
        sessionStorage.setItem('panier', JSON.stringify(this.panier))
        sessionStorage.setItem('test', "test")
      },
      error: (err) => {
        this.authError = true;
      },
    });
  }
}

