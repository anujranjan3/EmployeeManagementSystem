import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  Employee: any = [];

  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {

    this.loadEmployees()
  }

  loadEmployees() {
    
    return this.restApi.getEmployees().subscribe((data: {}) => {
      this.Employee = data;
    })
  }
}
