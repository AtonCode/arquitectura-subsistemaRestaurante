import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Order } from 'src/app/models/order';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http: HttpClient) { }

  addOrder (order: Order): Observable<any> {
    return this.http.post("http://10.0.1.108:8080/jakartaee-hello-world/rest/order/create", order, { responseType: 'text'});
  }
}