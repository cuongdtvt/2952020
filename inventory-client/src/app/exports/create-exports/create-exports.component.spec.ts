import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateExportsComponent } from './create-exports.component';

describe('CreateExportComponent', () => {
  let component: CreateExportsComponent;
  let fixture: ComponentFixture<CreateExportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateExportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateExportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
