import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RsoComponent } from './rso.component';

describe('RsoComponent', () => {
  let component: RsoComponent;
  let fixture: ComponentFixture<RsoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RsoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RsoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
