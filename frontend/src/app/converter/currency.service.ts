import { HttpClient} from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Currency } from './currency';
import { AllCurrency } from './allCurrency';

@Injectable({
    providedIn: 'root'
})
export class CurrencyService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getAllCurrency(): Observable<AllCurrency[]> {
        return this.http.get<AllCurrency[]>(`${this.apiServerUrl}/currency/all/`);
    }

    public getValueFromPln(currency: string, quantity: string): Observable<Currency> {
        return this.http.get<Currency>(`${this.apiServerUrl}/currency/from/${currency}/${quantity}`);
    }

    public getValueToPln(currency: string, quantity: string): Observable<Currency> {
        return this.http.get<Currency>(`${this.apiServerUrl}/currency/to/${currency}/${quantity}`);
    }
}