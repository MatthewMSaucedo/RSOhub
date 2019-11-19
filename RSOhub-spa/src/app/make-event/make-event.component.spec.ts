import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeEventComponent } from './make-event.component';

describe('MakeEventComponent', () => {
  let component: MakeEventComponent;
  let fixture: ComponentFixture<MakeEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
