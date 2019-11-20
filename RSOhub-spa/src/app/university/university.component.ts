import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.scss']
})
export class UniversityComponent implements OnInit {

    constructor(public toastrService: ToastrService) { }

    ngOnInit() { }

    public onSubmit(form) {
        this.toastrService.success('University created successfully!');
    }

}
