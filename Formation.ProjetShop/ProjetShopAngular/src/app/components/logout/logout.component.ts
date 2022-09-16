import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    sessionStorage.removeItem('user')
    this.router.navigateByUrl("/")
  }



}
