import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class LeaveService {

	constructor() { }

	public leaveId: any;
	public leaveType: any;
	public leaveStatus: any;
	public leaveComment: any;
	public toDate: any;
	public fromDate: any;
	public eid: any;
	public action : any;
}
