import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RendelesComponent } from './rendeles.component';

describe('RendelesComponent', () => {
  let component: RendelesComponent;
  let fixture: ComponentFixture<RendelesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RendelesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RendelesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
