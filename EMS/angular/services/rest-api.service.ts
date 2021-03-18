import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { EmployeeLoginService } from './employee-login.service';
import { EmployeeService } from './employee.service';
import { LeaveService } from './leave.service';
import { ManagerService } from './manager.service';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  apiURL = 'http://localhost:8085/LeaveMGM';

  constructor(private http: HttpClient) { }

  httpOptions = {

    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getEmployees(): Observable<EmployeeService> {

    return this.http.get<EmployeeService>(this.apiURL + '/allemp')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getEmployee(eid: any): Observable<EmployeeService> {

    return this.http.get<EmployeeService>(this.apiURL + '/search/' + eid)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  createEmployee(employee: any): Observable<EmployeeService> {

    return this.http.post<EmployeeService>(this.apiURL + '/create', JSON.stringify(employee), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  authenticate(email: string, password: string): Observable<EmployeeLoginService> {

    return this.http.get<EmployeeLoginService>(this.apiURL + `/login/${email}/${password}`, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.loginError)
      )
  }

  updateEmployee(eid: any, employee: EmployeeService): Observable<EmployeeService> {

    return this.http.put<EmployeeService>(this.apiURL + '/update', JSON.stringify(employee), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  deleteEmployee(eid: any) {

    return this.http.delete<EmployeeService>(this.apiURL + '/delete/' + eid, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getLeaves(): Observable<LeaveService> {

    return this.http.get<LeaveService>(this.apiURL + '/getLeave')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  approveLeave(leaveId: any): Observable<LeaveService> {

    return this.http.put<LeaveService>(this.apiURL + '/approveLeave/' + leaveId, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  rejectLeave(leaveId: any): Observable<LeaveService> {

    return this.http.put<LeaveService>(this.apiURL + '/rejectLeave/' + leaveId, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  applyLeave(leave: any): Observable<LeaveService> {

    return this.http.post<LeaveService>(this.apiURL + '/applyLeave', JSON.stringify(leave), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  searchLeave(eid: any): Observable<LeaveService> {

    return this.http.get<LeaveService>(this.apiURL + `/searchLeave/${eid}`, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  cancelLeave(leaveId: any) {

    return this.http.delete<LeaveService>(this.apiURL + '/cancelLeave/' + leaveId, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  action(leaveId:any): Observable<LeaveService> {

    return this.http.get<LeaveService>(this.apiURL + `/action/${leaveId}`, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }
totalLeaveRejected(eid:any){
  alert("in reject api"+eid);
  return this.http.get<ManagerService>(this.apiURL +'/totalRejectedLeave/'+eid ,this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}

totalLeaveApproved(eid:any){
  alert("in approve api"+eid);
  return this.http.get<ManagerService>(this.apiURL +'/totalApprovedLeave/'+eid ,this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}

  handleError(error: any) {

    let errorMessage = `Something Went Wrong`;
    
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  loginError(error:any)
  {
    let errorMessage = `Please Check Your Email Id and Password`;
    
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

}
