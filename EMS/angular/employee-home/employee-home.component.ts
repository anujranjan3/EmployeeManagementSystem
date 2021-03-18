import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';


@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  constructor(public restApi: RestApiService,
    private aroute: ActivatedRoute, private router: Router) { }

  currentEmployeeId: any;
  currentEmployeeName: any;
  currentEmployeeRole: any;
  currentEmployeeEmail: any;
  lastLoginTime: any;
  currentEmployeeAvailableLeave:any;

  ngOnInit(): void {

    this.currentEmployeeId = sessionStorage.getItem('eid');
    this.currentEmployeeName = sessionStorage.getItem('fname');
    this.currentEmployeeRole = sessionStorage.getItem('role');
    this.currentEmployeeEmail = sessionStorage.getItem('email');
    this.currentEmployeeAvailableLeave=sessionStorage.getItem('availableLeave');
    this.lastLoginTime = sessionStorage.getItem('lastLoginTime');

    if (this.currentEmployeeEmail === null) {
      this.router.navigate(['login']);
    }

    if (this.currentEmployeeRole === "MANAGER") {
      this.router.navigate(['login']);
    }

    if (this.lastLoginTime == null) {
      this.lastLoginTime = "First Login";
    }

  }

  viewLeave() {

    this.router.navigate(['1'], { relativeTo: this.aroute });
  }

  applyLeave() {

    this.router.navigate(['2'], { relativeTo: this.aroute });
  }

  logout() {
    if (window.confirm("Are you sure, you want to logout? ")) {
      sessionStorage.removeItem('email');
      this.router.navigate(['home']);
    }
  }
}