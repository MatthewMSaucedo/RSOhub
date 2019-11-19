import { Component, OnInit } from '@angular/core';
import { RsoService } from './rso.service';
import { AuthService } from '../authorization/auth.service';

@Component({
    selector: 'app-rso',
    templateUrl: './rso.component.html',
    styleUrls: ['./rso.component.scss']
})
export class RsoComponent implements OnInit {
    public rsos;
    public isLoading = true;

    constructor(
        public rsoService: RsoService,
        public authService: AuthService
    ) { }

    async ngOnInit() {
        this.rsos = await this.rsoService.listRsos();
        this.isLoading = false;
    }

    async shouldDisplayJoinButton(refRsoId: number) {
        return await this.rsoService.isUserInRso(refRsoId);
    }

    async joinRso(refRsoId: number) {
        return await this.rsoService.joinRso(refRsoId);
    }

}
