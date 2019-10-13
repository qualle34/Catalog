import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAdvertComponent } from './user-advert.component';

describe('UserAdvertComponent', () => {
  let component: UserAdvertComponent;
  let fixture: ComponentFixture<UserAdvertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAdvertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAdvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
