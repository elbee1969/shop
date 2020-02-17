import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SaisieService {

    items = [];
  
    addToSaisie(product) {
      this.items.push(product);
    }
  
    getItems() {
      return this.items;
    }
  
    clearSaisie() {
      this.items = [];
      return this.items;
    }
  }