import { Component, OnInit } from '@angular/core';
import { FormBuilder,  FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-saisie',
  templateUrl: './saisie.component.html',
  styleUrls: ['./saisie.component.css']
})
export class SaisieComponent implements OnInit {

  public checkoutForm: FormGroup;

    constructor(
      private formBuilder: FormBuilder, private http: HttpClient
    ) {
      this.checkoutForm = this.formBuilder.group({
        caisses: '',
        clients: ''
      });
    }
  
    ngOnInit() {

     
    }
  
    onSubmit() {
     

        console.log(this.checkoutForm.value)
      this.http.post<object>('http://localhost:9000/shop', this.checkoutForm.value)
    }
  }