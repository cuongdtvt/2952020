import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateImportsComponent } from './update-imports.component';

describe('UpdateImportsComponent', () => {
  let component: UpdateImportsComponent;
  let fixture: ComponentFixture<UpdateImportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateImportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateImportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
