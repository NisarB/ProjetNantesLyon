import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, EmailValidator, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { map, Observable } from 'rxjs';
import { InscriptionServiceService } from 'src/app/services/auth/inscription-service.service';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client/client';
import { Utilisateur } from 'src/app/models/utilisateur';
import { Adresse } from 'src/app/models/client/adresse';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  form: FormGroup;
  client: Client = new Client();
  utilisateur: Utilisateur = new Utilisateur();
  password: FormControl;

  constructor(
    private inscriptionservice: InscriptionServiceService,
    private router: Router
  ) {
    this.password = new FormControl('', [
      Validators.required,
      Validators.pattern(
        /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*?.@!=+#]).{4,20}$/
      ),
    ]);

    this.form = new FormGroup({
      loginCtrl: new FormControl('', Validators.required, this.checkLogin()),
      prenomCtrl: new FormControl('', [Validators.required, Validators.minLength(3)]),
      nomCtrl: new FormControl('', [Validators.required, Validators.minLength(3)]),
      mailCtrl: new FormControl('', [Validators.required, Validators.email]),
      passwordGroup: new FormGroup(
        {
          passwordCtrl: this.password,
          confirmCtrl: new FormControl(''),
        },
        this.equals
      ),
    });
  }


  ngOnInit(): void {
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionservice.checkClientExist(control.value).pipe(
        map((result) => {
          return result ? { notUnique: true } : null;
        })
      );
    };
  }

  equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return group.get('passwordCtrl')?.value == group.get('confirmCtrl')?.value
      ? null
      : { notequals: true };
  }


  submit() {
    let client = {
      prenom: this.form.get('prenomCtrl')?.value,
      nom: this.form.get('nomCtrl')?.value,
      mail: this.form.get('mailCtrl')?.value,
      username: this.form.get('loginCtrl')?.value,
      password: this.form.get('passwordGroup.passwordCtrl')?.value
    };
    this.inscriptionservice.inscription(client).subscribe({
      next: (result) => {
        this.router.navigateByUrl('/login/true');
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
        this.form.get('loginCtrl')?.setErrors({ notUnique: true });
      },
    });
  }
}
