import { Injectable } from '@angular/core';
import { Admin } from '../models/admin/admin';
import { Article } from '../models/article/article';
import { Avis } from '../models/article/avis';
import { Client } from '../models/client/client';
import { Commande } from '../models/commande/commande';
import { ListeArticle } from '../models/commande/liste-article';
@Injectable({
  providedIn: 'root'
})
export class ConvertService {


  constructor() { }

  avisToJson(avis: Avis): any {
    let obj = {
      avis: avis.avis,
      note: avis.note,
    }
    if (avis.avisKey?.client && avis.avisKey.article) {
      Object.assign(obj, {
        id: {
          client: this.clientToJson(avis.avisKey.client),
          article: this.articleToJson(avis.avisKey.article)
        },
      });
    }
    return obj
  }

  articleToJson(article: Article): any {
    let obj = {
      id: article.id,
      nom: article.nom,
      categorie: article.categorie,
      description: article.description,
      prix: article.prix,
      note: article.note,
      avis: article.avis,
      stock: article.stock
    };
    return obj;
  }

  public adminToJson(admin: Admin): any {
    let obj = {
      id: admin.id,
      username: admin.username,
      password: admin.password
    };
    return obj;
  }

  clientToJson(client: Client): any {
    let obj = {
      id: client.id,
      username: client.username,
      password: client.password,
      nom: client.nom,
      prenom: client.prenom,
      mail: client.mail,
      tel: client.tel
    };
    if (client.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: client.adresse.numero,
          rue: client.adresse.rue,
          codePostal: client.adresse.codePostal,
          ville: client.adresse.ville,
        },
      });
    }
    return obj;
  }

  public commandeToJson(commande: Commande): any {
    let obj = {
      id: commande.id,
      date: commande.date,
      client: commande.client,
    };
    if (commande.facture) {
      Object.assign(obj, {
        facture: {
          tva: commande.facture?.tva,
          remise: commande.facture?.remise
        }
      });
    }

    return obj;
  }

  listeToJson(listeArticle: ListeArticle) {
    let obj = {
      quantite: listeArticle.quantite
    }
    if (listeArticle.listeKey?.article && listeArticle.listeKey.commande) {
      Object.assign(obj, {
        id: {
          commande: this.commandeToJson(listeArticle.listeKey.commande),
          article: this.articleToJson(listeArticle.listeKey.article)
        },
      })
    }
  }
}

