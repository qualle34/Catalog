import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAdvertsComponent } from './user-adverts.component';

describe('UserAdvertsComponent', () => {
  let component: UserAdvertsComponent;
  let fixture: ComponentFixture<UserAdvertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAdvertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAdvertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
