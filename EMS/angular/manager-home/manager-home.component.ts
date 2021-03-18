import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-manager-home',
  templateUrl: './manager-home.component.html',
  styleUrls: ['./manager-home.component.css']
})
export class ManagerHomeComponent implements OnInit {

  currentEmployeeId: any;
  currentEmployeeName: any;
  currentEmployeeRole: any;
  currentEmployeeEmail: any;
  lastLoginTime: any;

  constructor(private aroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.currentEmployeeId = sessionStorage.getItem('eid');
    this.currentEmployeeName = sessionStorage.getItem('fname');
    this.currentEmployeeRole = sessionStorage.getItem('role');
    this.currentEmployeeEmail = sessionStorage.getItem('email');
    this.lastLoginTime = sessionStorage.getItem('lastLoginTime');

    if (this.currentEmployeeEmail === null) {
      this.router.navigate(['login']);
    }

    if (this.currentEmployeeRole === "EMPLOYEE") {
      this.router.navigate(['login']);
    }


    
  }

  addEmployee() {

    this.router.navigate(['1'], { relativeTo: this.aroute });
  }

  getEmployees() {

    this.router.navigate(['2'], { relativeTo: this.aroute });
  }

  getLeave() {

    this.router.navigate(['3'], { relativeTo: this.aroute });
  }

  logout() {

    sessionStorage.removeItem('email');
    this.router.navigate(['home']);
  }

}
