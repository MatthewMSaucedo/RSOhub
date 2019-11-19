import { AuthService } from '../authorization/auth.service';
import { RsoEndpointService } from '../server-communication/rso-endpoint.service';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class RsoService {
    constructor(
        public endpointService: RsoEndpointService,
        public authService: AuthService
    ) {}


    public async listRsos() {
        return await this.endpointService.listRso();
    }

    public async isUserInRso(rsoId: number) {
        return await this.endpointService.isUserInRso({refUserId: this.authService.userId, refRsoId: rsoId});
    }

    public async joinRso(rsoId: number) {
        return await this.endpointService.joinRso({refRsoId: rsoId, refUserId: this.authService.userId});
    }
}