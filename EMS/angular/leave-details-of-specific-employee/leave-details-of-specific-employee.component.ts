import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-leave-details-of-specific-employee',
  templateUrl: './leave-details-of-specific-employee.component.html',
  styleUrls: ['./leave-details-of-specific-employee.component.css']
})
export class LeaveDetailsOfSpecificEmployeeComponent implements OnInit {

  currentEmployeeId: any;
  leave: any = [];

  constructor(public restApi: RestApiService,
     private aroute: ActivatedRoute, private router: Router) { }
  
  ngOnInit(): void {

    this.currentEmployeeId = sessionStorage.getItem('eid');
    this.loadleave()
  }

  loadleave() {

    return this.restApi.searchLeave(this.currentEmployeeId).subscribe((data: {}) => {
      this.leave = data;
    })
  }

  cancelLeave(id: any) {
    
    if (window.confirm('Are you sure, you want to cancel?')) {
      this.restApi.cancelLeave(id).subscribe((data: any) => {
        window.location.reload()
        this.loadleave()
      })
      
    }
    
  }
}




