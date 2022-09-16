import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/models/client/adresse';
import { Client } from 'src/app/models/client/client';
import { ClientService } from 'src/app/services/client/client.service';
import { NgModel } from '@angular/forms';
@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css']
})
export class ClientEditComponent implements OnInit {
  client: Client;
  ActiveUser: Client;
  constructor(
    private ar: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {
    this.ActiveUser = new Client();
    this.client = new Client();
    this.client.adresse = new Adresse();
  }

  ngOnInit(): void {

    let x = sessionStorage.getItem('user');
    this.ActiveUser = JSON.parse(x!)

    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.getById(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
    });
  }

  save() {

    if (this.client.id) {
      this.clientService.update(this.client).subscribe((result) => {
        this.router.navigateByUrl('/profile');
        console.log('update')
      });
    } else {
      this.clientService.create(this.client).subscribe((result) => {
        this.router.navigateByUrl('/profile');
        console.log('create')

      });
    }
  }


}
