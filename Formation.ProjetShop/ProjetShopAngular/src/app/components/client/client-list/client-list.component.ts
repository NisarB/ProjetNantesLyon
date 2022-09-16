import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client/client';
import { ClientService } from 'src/app/services/client/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients: Client[] = [];
  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.clientService.getAll().subscribe((result) => {
      this.clients = result;
    });
  }

  delete(id: number) {
    this.clientService.deleteById(id).subscribe((result) => {
      this.list()
    });
  }

}
