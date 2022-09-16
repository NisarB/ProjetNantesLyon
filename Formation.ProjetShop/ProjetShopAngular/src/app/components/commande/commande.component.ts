import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client/client';
import { Commande } from 'src/app/models/commande/commande';
import { ClientService } from 'src/app/services/client/client.service';
import { CommandeService } from 'src/app/services/commande/commande.service';
import { ListeArticleService } from 'src/app/services/commande/liste-article.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {
  commandes: Commande[] = [];
  ActiveUser: Client;

  constructor(private commandeService: CommandeService, private clientService: ClientService, private listeArticle: ListeArticleService) {
    let x = sessionStorage.getItem('user');
    this.ActiveUser = JSON.parse(x!)
  }

  ngOnInit(): void {

    this.commandeService.getAll().subscribe((result) => {
      this.commandes = result;
    });

  }

}
