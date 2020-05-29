import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportsDetailsComponent } from './imports-details.component';

describe('ImportsDetailsComponent', () => {
  let component: ImportsDetailsComponent;
  let fixture: ComponentFixture<ImportsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
