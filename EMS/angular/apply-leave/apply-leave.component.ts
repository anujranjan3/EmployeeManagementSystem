import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../services/rest-api.service';


@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {
  
  currentEmployeeId : any = sessionStorage.getItem('eid');
  currentEmployeeName: any;
  currentEmployeeRole: any;
  currentEmployeeEmail: any;
  lastLoginTime: any;
  currentEmployeeAvailableLeave:any;
  dateDifference:any;
  toDate:any;
  fromDate:any;

  public today = new Date();
  public tillDate = new Date(this.today.getTime() + (1000 * 60 * 60 *24*24));
  public lastDate=new Date(this.tillDate.getTime()+ (1000 * 60 * 60 *24*10));

  @Input() leaveDetails = { eid: this.currentEmployeeId, fromDate: '', toDate: '', leaveComment: '', leaveType: '' };

  constructor(public restApi: RestApiService, private aroute: ActivatedRoute, private router: Router) { }


  ngOnInit(): void {

    this.currentEmployeeId = sessionStorage.getItem('eid');
    this.currentEmployeeName = sessionStorage.getItem('fname');
    this.currentEmployeeRole = sessionStorage.getItem('role');
    this.currentEmployeeEmail = sessionStorage.getItem('email');
    this.lastLoginTime = sessionStorage.getItem('lastLoginTime');
    this.currentEmployeeAvailableLeave=sessionStorage.getItem('availableLeave');

    if (this.currentEmployeeId === null) {

      this.router.navigate(['login']);
    }

    if (this.currentEmployeeRole === "MANAGER") {

      this.router.navigate(['login']);
    }

    if (this.lastLoginTime == null) {

      this.lastLoginTime = "First Login";
    }

  }

  addLeave() {
    this.toDate=new Date(this.leaveDetails.toDate);
      this.fromDate=new Date(this.leaveDetails.fromDate);
      
      this.dateDifference=Number((this.toDate.getTime() - this.fromDate.getTime()) / 1000 / 60 / 60 / 24);
    if(this.currentEmployeeAvailableLeave>0&&this.currentEmployeeAvailableLeave>=this.dateDifference)
    {
      
      if(this.dateDifference<=10){
    if (window.confirm("Are you sure, you want apply? ")) {
      this.restApi.applyLeave(this.leaveDetails).subscribe((data: {}) => {
        this.router.navigate(['employeeHome/1/1'])
      })
    }
    else{
      alert("Maximum 10 days leave allowed !!\n You applied for "+this.dateDifference+ "days!!");
    }
  }
}
  else{
    alert("You have insufficient leave balance");
  }
}

}
