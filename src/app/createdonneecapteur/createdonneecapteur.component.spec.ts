import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatedonneecapteurComponent } from './createdonneecapteur.component';

describe('CreatedonneecapteurComponent', () => {
  let component: CreatedonneecapteurComponent;
  let fixture: ComponentFixture<CreatedonneecapteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatedonneecapteurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatedonneecapteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
