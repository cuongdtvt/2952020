import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportsDetailsComponent } from './exports-details.component';

describe('ExportsDetailsComponent', () => {
  let component: ExportsDetailsComponent;
  let fixture: ComponentFixture<ExportsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
