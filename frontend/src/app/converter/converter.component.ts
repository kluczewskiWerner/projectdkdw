import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { AllCurrency, Rate } from './allCurrency';
import { Currency } from './currency';
import { CurrencyService } from './currency.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-root-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})

export class ConverterComponent implements OnInit {
  public allCurrency$: AllCurrency[];
  public currency$: Currency;

  public show: boolean = false;
  public showBtn: any = 'Show';

  isLoggedIn = false;

  value: string;

  constructor(private currencyService: CurrencyService,
    private tokenStorage: TokenStorageService,
    private router: Router) {}

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.getAllCurrency();
    }
  }

  showTable() {
    this.show = !this.show;

    if(this.show)  
      this.showBtn = "Hide";
    else
      this.showBtn = "Show";
  }

  public checkMode(currencyForm: FormGroup) {

    this.value = document.getElementById('toggleButton').textContent;

    if(this.value === "Mode to PLN") {
      this.toPln(currencyForm)
    } else {
      this.fromPln(currencyForm)
    }
  }

  public getAllCurrency(): void {
    this.currencyService.getAllCurrency().subscribe(
      (response: AllCurrency[]) => {
        this.allCurrency$ = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public toPln(currencyForm: FormGroup) {
     this.currencyService.getValueToPln(currencyForm.value.code, currencyForm.value.quantity).subscribe(
       (response: Currency) => {
         this.currency$ = response;
         document.getElementById('result').textContent = this.currency$.result + " PLN"; 
       }
     )
  }

  public fromPln(currencyForm: FormGroup) {
    this.currencyService.getValueFromPln(currencyForm.value.code, currencyForm.value.quantity).subscribe(
      (response: Currency) => {
        this.currency$ = response;
        document.getElementById('result').textContent = this.currency$.result + " " + this.currency$.code; 
      }
    )
 }
}