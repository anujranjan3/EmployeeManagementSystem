import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-employee-search',
  templateUrl: './employee-search.component.html',
  styleUrls: ['./employee-search.component.css']
})
export class EmployeeSearchComponent implements OnInit {

  Employee: any = [];
  employeeData: any = {};
  display: boolean = true;

  constructor(
    public restApi: RestApiService,
    public actRoute: ActivatedRoute,
    public router: Router
  ) { }

  searchEid = this.actRoute.snapshot.params['searchEid'];

  ngOnInit(): void {
    
    this.searchEmployee(this.searchEid)
  }

  searchEmployee(searchEid: any) {
    return this.restApi.getEmployee(this.searchEid).subscribe((data: {}) => {
      this.Employee = data;


      if (this.Employee[0] == null) {
        this.display = false;
      }
    })
  }
}
