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
  public capacity: Array<number> = [];
  public articles: Array<number> = [];

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
     
      let nbrCashRegisters = this.checkoutForm.value.caisses;
      let nbrClients = this.checkoutForm.value.clients;
      
      

     for(let i=0; i<nbrCashRegisters;i++) {
        this.capacity.push(Math.floor(Math.random()*(40-20)+20));
      }

      for(let i=0; i<nbrClients;i++) {
        this.articles.push(Math.floor(Math.random()* Math.floor(39) + 1));
      }

      console.log(nbrCashRegisters);
      console.log(' tab capacity '+this.capacity);
      console.log(' tab article '+this.articles);

      let payloads = {
        'capacityOfCashRegister': this.capacity,
        'numberOfArticles': this.articles
      }

      console.log ('caisses : '+ nbrCashRegisters, 'Clients : '+ nbrClients);
        console.log(this.checkoutForm.value)
console.log('payloads : ' + payloads);

      this.http.post<object>('http://localhost:9000/shop', payloads)
    }

    alea(max: number) {
      
      return Math.floor(Math.random()* Math.floor(max) + 1)
    };

  }