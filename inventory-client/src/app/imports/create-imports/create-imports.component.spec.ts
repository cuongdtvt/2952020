import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateImportsComponent } from './create-imports.component';

describe('CreateImportsComponent', () => {
  let component: CreateImportsComponent;
  let fixture: ComponentFixture<CreateImportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateImportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateImportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
