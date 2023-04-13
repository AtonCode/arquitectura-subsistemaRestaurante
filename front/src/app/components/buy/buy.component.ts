import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products/products.service';
import { OrdersService } from 'src/app/services/orders/orders.service';
import { LoginService } from 'src/app/services/login/login.service';
import Swal from 'sweetalert2';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})

export class BuyComponent implements OnInit {

  products: Product[] = [];
  productsToBuy: Product[] = [];
  amountToBuy: number[] = [];

  constructor(private productsService: ProductsService, 
    private ordersService: OrdersService,
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.productsService.getproducts().subscribe(
      products => {
        this.products = products;      
      }
    );
  }

  onBuy(): void {
    var errorS = false;
    var amountBk: number[] = [];
    var productBk: Product[] = [];
    
    for(let i = 0; i < this.productsToBuy.length; i++) {

      let order: Order = {
        userId: Number(this.loginService.getUserId()),
        productId: this.productsToBuy[i].id,
        paid: true,
        quantity: this.amountToBuy[i]
      };

      console.log(order);
  
      this.ordersService.addOrder(order).subscribe(
        data => {
          if(i == this.productsToBuy.length - 1) {
            this.productsToBuy = productBk;
            this.amountToBuy = amountBk;
          }
        },
        error => {
          amountBk.push(this.amountToBuy[i]);
          productBk.push(this.productsToBuy[i]);



          errorS = true;
          console.log(this.productsToBuy);
          console.log(i);
          console.log(error);
          Swal.fire({
            icon: 'error',
            title: 'No se pudo comprar ' + this.productsToBuy[i].name,
            confirmButtonColor: '#50504f'
          });
          this.ngOnInit();
        });
    }

    if(!errorS) {
      Swal.fire({
        icon: 'success',
        title: 'Compra realizada',
        confirmButtonColor: '#50504f'
      });

    }

  }

  buyListEmpty(): boolean {
    return this.productsToBuy.length == 0;
  }

  onAdd(prod: any): void {

    var idn = this.productsToBuy.indexOf(prod);

    if(idn == -1) {

      if(prod.quantity < 1) {
        Swal.fire({
          icon: 'error',
          title: 'No quedan existencias',
          confirmButtonColor: '#50504f'
        });
      }
      else {
        this.productsToBuy.push(prod);
        this.amountToBuy.push(1);
      }
    }
    else {
      if (this.amountToBuy.at(idn)!= undefined) {

        if(prod.quantity < this.amountToBuy[idn] + 1) {
          Swal.fire({
            icon: 'error',
            title: 'No quedan existencias',
            confirmButtonColor: '#50504f'
          });
        }
        else {
          this.amountToBuy[idn] += 1;
        }
      }
    }
  }

  existOrder(): boolean {
    return this.productsToBuy.length > 0;
  }

  getTotal(): number {
    let total = 0;
    for(let i = 0; i < this.productsToBuy.length; i++) {
      total += (this.amountToBuy[i] * this.productsToBuy[i].price)
    }
    return total;
  }
}
