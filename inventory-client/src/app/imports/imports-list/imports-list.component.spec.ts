import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportsListComponent } from './imports-list.component';

describe('ImportsListComponent', () => {
  let component: ImportsListComponent;
  let fixture: ComponentFixture<ImportsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
