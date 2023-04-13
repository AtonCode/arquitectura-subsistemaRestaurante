import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import * as CryptoJS from 'crypto-js';
import { LoginService } from '../../services/login/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // decryptionKey: string = "7Gj6fT85HF5$SH6xKf";
  checkoutForm = this.formBuilder.group({
    login: '',
    password: '',
  });

  constructor(private formBuilder: FormBuilder,
    private loginService: LoginService,
    public router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {

    let userParam: string;
    let passParam: string;
    userParam = '' + this.checkoutForm.value.login;
    passParam = '' + this.checkoutForm.value.password;

    // console.log('FormValue:', this.checkoutForm.value);
    // console.log('Login:', this.checkoutForm.value.login);
    // console.log('Password:', this.checkoutForm.value.password);

    Swal.fire({
            title: 'Iniciando Sesión',
            allowEscapeKey: false,
            allowOutsideClick: false,
            showConfirmButton: false
        });
    Swal.showLoading();

    this.loginService.login(userParam, passParam).subscribe(
      data => {
        Swal.close();
        console.log(data);
        this.loginService.setCookies(data.id, data.name);
        Swal.fire({
          icon: 'success',
          title: 'Inicio de sesión correcto',
          text: 'Bienvenido, ' + data.name,
          confirmButtonColor: '#50504f'
        });
        this.router.navigateByUrl('/');
        this.loginService.getStatus.emit("login");
      },
      error => {
        Swal.close();
        Swal.fire({
          icon: 'error',
          title: 'Error al iniciar sesión',
          text: 'Verifica usuario y/o contraseña',
          confirmButtonColor: '#50504f'
        });
      });

    this.checkoutForm.reset();
  }

  // encrypt(word: string): string {
  //   const keyBase64 = "o9szYIOq1rRMiouNhNvaq96lqUvCekxR";
  //   var key = CryptoJS.enc.Base64.parse(keyBase64);
  //   var srcs = CryptoJS.enc.Utf8.parse(word);
  //   var encrypted = CryptoJS.AES.encrypt(srcs, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });
  //   return encrypted.toString();
  // }

}