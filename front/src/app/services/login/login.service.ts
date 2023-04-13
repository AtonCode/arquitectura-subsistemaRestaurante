import { EventEmitter, Injectable, Output } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs";
import { User } from 'src/app/models/user';
import { CookieService } from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  @Output() getStatus: EventEmitter<any> = new EventEmitter();

  constructor(private http: HttpClient,
              private cookies: CookieService) { }

  login(user: string, password: string): Observable<any> {
      return this.http.get("http://10.0.1.108:8080/jakartaee-hello-world/rest/user/login/" + user + "/" + password);
  }

  setCookies(userId: number, username: string) {
    this.cookies.set("userId", userId.toString());
    this.cookies.set("user", username);
    this.cookies.set("token", "OK");
  }
  getToken() {
    return this.cookies.get("token");
  }
  getUser() {
    return this.cookies.get("user");
  }
  getUserId() {
    return this.cookies.get("userId");
  }

  logout() {
    this.cookies.deleteAll();
    this.getStatus.emit("logout");
  }
}
