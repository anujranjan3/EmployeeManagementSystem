import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { RestApiService } from '../services/rest-api.service';

@Component({
  selector: 'app-leave-details',
  templateUrl: './leave-details.component.html',
  styleUrls: ['./leave-details.component.css']
})
export class LeaveDetailsComponent implements OnInit {

  currentEmployeeId: any;
  currentEmployeeName: any;
  currentEmployeeRole: any;
  currentEmployeeEmail: any;
  status:any;
  statusApproved:any;
  leaveData: any = {};
  Leave: any = [];
  public action: any = [];
  actionTaken:any;
  constructor(
    public restApi: RestApiService,
    public actRoute: ActivatedRoute,
    public router: Router
  ) { }

  ngOnInit() {

   
    this.currentEmployeeId = sessionStorage.getItem('eid');
    this.currentEmployeeName = sessionStorage.getItem('fname');
    this.currentEmployeeRole = sessionStorage.getItem('role');
    this.currentEmployeeEmail = sessionStorage.getItem('email');
 

    if (this.currentEmployeeId === null) {
      this.router.navigate(['login']);
    }

    if (this.currentEmployeeRole === "EMPLOYEE") {
      this.router.navigate(['login']);
    }

    this.loadLeaves()
  }

  loadLeaves() {

    return this.restApi.getLeaves().subscribe((data: {}) => {
      this.Leave = data;
    })
  }

  rejectLeave(leaveId: any) {

    if (window.confirm('Are you sure, you want to Reject?')) {
      this.restApi.action(leaveId).subscribe((data: {}) => {
        this.action= data;
        if(this.action[0]==="YES")
        {alert(`You have taken action on it , you can't reject it again`);
          this.loadLeaves();
        }
        else{
          alert("in reject");
     this.restApi.totalLeaveRejected(this.currentEmployeeId).subscribe((data: any) => {
this.status=data;
     })
        this.restApi.rejectLeave(leaveId).subscribe((data: any) => {
          this.loadLeaves()
        })
      }
      })
     
  }
}

  approveLeave(leaveId: any) {

    if (window.confirm('Are you sure, you want to Approve?' )) {
      this.restApi.action(leaveId).subscribe((data: {}) => {
        this.action = data;

        alert("action="+this.action[0]);
        if(this.action[0]==="YES")
        {alert(`You have taken action on it , you can't aprove it again`);
          this.loadLeaves();
        }
        else{
          this.restApi.totalLeaveApproved(this.currentEmployeeId).subscribe((data: any) => {
            this.statusApproved=data;
                 })
        this.restApi.approveLeave(leaveId).subscribe((data: any) => {
          this.loadLeaves()
        })
      }
      })
     
  }
}
}
