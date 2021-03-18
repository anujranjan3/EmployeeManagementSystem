import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  currentUserId: any;
  currentUserName: any;
  currentRole: any;

  @Input() employeeDetails = { eid: '', fname: '', lname: '', age: '', gender: 'MALE', email: '', username: '', password: '', role: 'EMPLOYEE', phoneNumber: '', address: '' }

  constructor(

    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() {

    this.currentUserId = sessionStorage.getItem('email');
    this.currentUserName = sessionStorage.getItem('fname');
    this.currentRole = sessionStorage.getItem('role');

    if (this.currentUserId === null) {
      this.router.navigate(['login']);
    }

    if (this.currentRole === "EMPLOYEE") {
      this.router.navigate(['login']);
    }
  }

  addEmployee() {

    if (window.confirm("Are you sure, you want add? ")) {
      this.restApi.createEmployee(this.employeeDetails).subscribe((data: {}) => {
        this.router.navigate(['managerHome/2/2'])
      })
    }
  }
}