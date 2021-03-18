import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeLoginService {

  public role: string | undefined;
  public email: string | undefined;
  public fname: string | undefined;
  constructor() { }
}
