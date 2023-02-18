import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaiComponent } from './detai.component';

describe('DetaiComponent', () => {
  let component: DetaiComponent;
  let fixture: ComponentFixture<DetaiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetaiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
