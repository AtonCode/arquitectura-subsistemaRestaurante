import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from 'src/app/models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  getproducts(): Observable<Product[]> {
    return this.http.get<Product[]>("http://10.0.1.108:8080/jakartaee-hello-world/rest/product/all");
  }

  addNewProduct (Product: Product): Observable<any> {
    return this.http.post("http://10.0.1.108:8080/jakartaee-hello-world/rest/product/create", Product);
  }
}
