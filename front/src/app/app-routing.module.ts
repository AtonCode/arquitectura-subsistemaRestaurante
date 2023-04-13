import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './components/products/products.component'
import { LoginComponent } from './components/login/login.component'
import { BuyComponent } from './components/buy/buy.component'
import { GuardGuard as guard } from 'src/app/guard.guard';


const routes: Routes = [
                        { path: '', component: ProductsComponent},
                        { path: 'login', component: LoginComponent },
                        { path: 'buy', component: BuyComponent, canActivate: [guard] }
                        ];
                      

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
