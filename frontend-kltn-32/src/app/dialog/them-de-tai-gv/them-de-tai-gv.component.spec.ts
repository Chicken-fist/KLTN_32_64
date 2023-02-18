import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemDeTaiGvComponent } from './them-de-tai-gv.component';

describe('ThemDeTaiGvComponent', () => {
  let component: ThemDeTaiGvComponent;
  let fixture: ComponentFixture<ThemDeTaiGvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThemDeTaiGvComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemDeTaiGvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
