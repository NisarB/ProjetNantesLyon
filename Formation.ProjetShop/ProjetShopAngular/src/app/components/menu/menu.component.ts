import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, Router, Event, NavigationError } from '@angular/router';
import { Client } from 'src/app/models/client/client';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  ActiveUser: Client;
  currentRoute: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router) {
    this.ActiveUser = new Client();
    this.currentRoute = "";
    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationStart) {
        this.ngOnInit()
      }

    });
  }

  ngOnInit(): void {
    let x = sessionStorage.getItem('user');
    this.ActiveUser = JSON.parse(x!)
  }

  logout() {
    sessionStorage.removeItem('user');
    this.router.navigateByUrl('/')
    this.ngOnInit()

  }

}
