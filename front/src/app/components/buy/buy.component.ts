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

    for(let i = 0; i < this.productsToBuy.length; i++) {

      let order: Order = {
        userId: Number(this.loginService.getUserId),
        productId: this.productsToBuy[i].id,
        isPaid: true,
        isApproved: true,
        quantity: this.amountToBuy[i]
      };
  
      this.ordersService.addOrder(order).subscribe(
        error => {
          console.log(error);
          Swal.fire({
            icon: 'error',
            title: 'No se pudo comprar ' + this.productsToBuy[i].name,
            confirmButtonColor: '#50504f'
          });
          this.ngOnInit();
        });
    }

    this.amountToBuy = [];
    this.productsToBuy = [];
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
