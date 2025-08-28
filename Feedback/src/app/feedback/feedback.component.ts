import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators ,ReactiveFormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-feedback',
  imports: [CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,MatCardModule],
  templateUrl: './feedback.component.html',
  styleUrl: './feedback.component.css'
})
export class FeedbackComponent {


submitted = false;
  successMessage = '';
  feedbackForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(40)]],
      comments: ['', [Validators.required, Validators.maxLength(350)]],
    });
  }

  get f() {
    return this.feedbackForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.feedbackForm.invalid) return;

    this.successMessage = 'Thank you for your message, we will get back to you shortly!';
    console.log(this.feedbackForm.value);

    setTimeout(() => {
      this.feedbackForm.reset();
      this.submitted = false;
      this.successMessage = '';
    }, 3000);
  }

}
