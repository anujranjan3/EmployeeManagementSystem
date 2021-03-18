import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveDetailsOfSpecificEmployeeComponent } from './leave-details-of-specific-employee.component';

describe('LeaveDetailsOfSpecificEmployeeComponent', () => {
  let component: LeaveDetailsOfSpecificEmployeeComponent;
  let fixture: ComponentFixture<LeaveDetailsOfSpecificEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaveDetailsOfSpecificEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveDetailsOfSpecificEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
