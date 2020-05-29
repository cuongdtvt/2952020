import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateExportsComponent } from './update-exports.component';

describe('UpdateExportsComponent', () => {
  let component: UpdateExportsComponent;
  let fixture: ComponentFixture<UpdateExportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateExportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateExportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
