import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  public email: any;
  public password: any;
  public user: any = [];
  sessionStorage: any;

  constructor(public restApi: RestApiService,
    public actRoute: ActivatedRoute,
    public router: Router) { }

  ngOnInit() {

  }

  Login() {

    this.restApi.authenticate(this.email, this.password).subscribe((data: {}) => {
      this.user = data;
     
      if (this.user[0] === "MANAGER") {

        sessionStorage.setItem('role', this.user[0]);
        sessionStorage.setItem('email', this.user[1]);
        sessionStorage.setItem('fname', this.user[2]);
        sessionStorage.setItem('lastLoginTime', this.user[3]);
        sessionStorage.setItem('eid', this.user[4]);
        
        this.router.navigate(['managerHome']);
       
      }
      else if (this.user[0] === "EMPLOYEE") {

        sessionStorage.setItem('role', this.user[0]);
        sessionStorage.setItem('email', this.user[1]);
        sessionStorage.setItem('fname', this.user[2]);
        sessionStorage.setItem('lastLoginTime', this.user[3]);
        sessionStorage.setItem('eid', this.user[4]);
        sessionStorage.setItem('availableLeave',this.user[5]);
        this.router.navigate(['employeeHome']);
       
      }
      else {

        this.router.navigate(['login']);
      }
    })
  }
}