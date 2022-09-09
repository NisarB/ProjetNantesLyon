import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  passCheck(form: FormGroup): boolean {
    if (form.controls['password'].value === form.controls['cpassword'].value) {
      return true
    }
    return false
  }
  submit(signForm: any) {
    let form = signForm as FormGroup;
    this.passCheck(form)
  }
}
