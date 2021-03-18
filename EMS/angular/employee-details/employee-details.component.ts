import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  Employee: any = [];
  currentRole: any;
  currentUserId: any;
  currentUserName: any;

  constructor(
    public restApi: RestApiService,
    public actRoute: ActivatedRoute,
    public router: Router
  ) { }

  
  searchEid = this.actRoute.snapshot.params['searchEid'];

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

    this.loadEmployees()
  }

  loadEmployees() {

    return this.restApi.getEmployees().subscribe((data: {}) => {
      this.Employee = data;
    })
  }

  deleteEmployee(id: any) {

    if (window.confirm('Are you sure, you want to delete?')) {
      this.restApi.deleteEmployee(id).subscribe((data: any) => {
        this.loadEmployees()
      })
    }
  }
}
