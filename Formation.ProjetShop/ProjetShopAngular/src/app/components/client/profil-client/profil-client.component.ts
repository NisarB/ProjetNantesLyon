import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/admin/admin';
import { Client } from 'src/app/models/client/client';
import { ClientService } from 'src/app/services/client/client.service';

@Component({
  selector: 'app-profil-client',
  templateUrl: './profil-client.component.html',
  styleUrls: ['./profil-client.component.css']
})
export class ProfilClientComponent implements OnInit {

  client: Client;


  constructor(
    private ar: ActivatedRoute,
    private clientService: ClientService,
    private router: Router) {
    this.client = new Client();
  }




  ngOnInit(): void {

    let x = sessionStorage.getItem('user');

    this.client = JSON.parse(x!)

  }



}
