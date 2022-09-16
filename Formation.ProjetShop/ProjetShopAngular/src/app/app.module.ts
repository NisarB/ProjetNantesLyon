import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { InscriptionComponent } from './forms/inscription/inscription.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ArticleListComponent } from './components/article/list/article-list.component';
import { ArticleEditComponent } from './components/article/edit/article-edit.component';
import { AvisAddComponent } from './components/avis/add/avis-add/avis-add.component';
import { AvisListComponent } from './components/avis/list/avis-list/avis-list.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { AdminEditComponent } from './components/admin/admin-edit/admin-edit.component';
import { AdminListComponent } from './components/admin/admin-list/admin-list.component';
import { ArticlePageComponent } from './components/article/page/article-page.component';
import { FooterComponent } from './components/footer/footer.component';
import { CatalogueComponent } from './components/catalogue/catalogue.component';
import { HomeComponent } from './components/home/home.component';
import { ProfilClientComponent } from './components/client/profil-client/profil-client.component';
import { LoginComponent } from './forms/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { CommandeComponent } from './components/commande/commande.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    InscriptionComponent,
    ArticleListComponent,
    ArticleEditComponent,
    AvisAddComponent,
    AvisListComponent,
    ClientEditComponent,
    ClientListComponent,
    AdminEditComponent,
    AdminListComponent,
    ArticlePageComponent,
    FooterComponent,
    CatalogueComponent,
    HomeComponent,
    MenuComponent,
    FooterComponent,
    ProfilClientComponent,
    LoginComponent,
    LogoutComponent,
    CommandeComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
