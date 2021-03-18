import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { EmployeeSearchComponent } from './employee-search/employee-search.component';

import { HomeComponent } from './home/home.component';
import { LeaveDetailsOfSpecificEmployeeComponent } from './leave-details-of-specific-employee/leave-details-of-specific-employee.component';
import { LeaveDetailsComponent } from './leave-details/leave-details.component';

import { LoginComponent } from './login/login.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';

import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';


const routes: Routes = [

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'createEmployee', component: EmployeeCreateComponent },
  { path: 'editEmployee/:eid', component: EmployeeEditComponent },
  { path: 'login', component: LoginComponent },
  {path:'employee-search/:searchEid', component:EmployeeSearchComponent},
  { path: 'managerHome', component: ManagerHomeComponent },
  {path : 'applyLeave',component:ApplyLeaveComponent},
  { path: 'employeeHome', component: EmployeeHomeComponent },
  {
    path: 'managerHome/:', component: ManagerHomeComponent,
    children: [
      { path: '1', component: EmployeeCreateComponent },
      { path: '2', component: EmployeeDetailsComponent },
      { path: '3', component: LeaveDetailsComponent },
      {path : '4/{{searchEid}}' , component : EmployeeSearchComponent}
    ]
  },
  {
    path: 'employeeHome/:', component: EmployeeHomeComponent,
    children: [
      { path: '1', component: LeaveDetailsOfSpecificEmployeeComponent },
      { path: '2', component: ApplyLeaveComponent }
    ]
  },
  { path: 'aboutus', component: AboutUsComponent },
  { path: 'spreficEmployeeLeave', component: LeaveDetailsOfSpecificEmployeeComponent },
  { path: '**', component: PagenotfoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [HomeComponent, EmployeeCreateComponent, EmployeeDetailsComponent,
  EmployeeEditComponent, LoginComponent, ManagerHomeComponent, EmployeeHomeComponent,
  AboutUsComponent, LeaveDetailsComponent, ApplyLeaveComponent,
  LeaveDetailsOfSpecificEmployeeComponent, EmployeeSearchComponent,PagenotfoundComponent];
