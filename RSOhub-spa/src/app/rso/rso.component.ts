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
    public shouldDisplayJoinButton = [];

    constructor(
        public rsoService: RsoService,
        public authService: AuthService
    ) { }

    async ngOnInit() {
        this.rsos = await this.rsoService.listRsos();
        for (let i = 0; i < this.rsos.length; i++) {
            let refRsoId = this.rsos[i].id;
            this.shouldDisplayJoinButton[i] = await this.shouldDisplayJoinButtonFunc(refRsoId);
        }
        this.isLoading = false;
    }

    async shouldDisplayJoinButtonFunc(refRsoId: number) {
        return await this.rsoService.isUserInRso(refRsoId);
    }

    async joinRso(refRsoId: number) {
        return await this.rsoService.joinRso(refRsoId);
    }

}
