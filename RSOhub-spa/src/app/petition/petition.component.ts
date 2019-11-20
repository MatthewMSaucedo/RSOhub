import { Component, OnInit } from '@angular/core';
import { AuthService } from '../authorization/auth.service';
import { PetitionService } from './petition.service';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-petition',
  templateUrl: './petition.component.html',
  styleUrls: ['./petition.component.scss']
})
export class PetitionComponent implements OnInit {

    constructor(
        public authService: AuthService,
        public petitionService: PetitionService,
        public toastrService: ToastrService
    ) { }

    ngOnInit() {
    }

    public async onSubmit(form: NgForm) {
        const rsoName = form.value.rsoName;
        await this.petitionService.createPetition(rsoName, this.authService.userId);
        this.toastrService.success('RSO petition created!');
    }

}
