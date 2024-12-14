import { ComponentFixture, TestBed } from '@angular/core/testing';

import {JarmuComponent} from './jarmu.component';
import {Jarmu} from '../jarmu.service';

describe('JarmuComponent', () => {
  let component: JarmuComponent;
  let fixture: ComponentFixture<JarmuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JarmuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JarmuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
