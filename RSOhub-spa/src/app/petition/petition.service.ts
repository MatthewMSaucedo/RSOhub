import { Injectable } from '@angular/core';
import { RsoEndpointService } from '../server-communication/rso-endpoint.service';

@Injectable({ providedIn: 'root' })
export class PetitionService {
    public formIsSubmitted = false;

    constructor(public rsoEndpointService: RsoEndpointService) {}
    
    public async createPetition(rso, user) {
        await this.rsoEndpointService.createPetition({ rsoName: rso, userId: user });
        this.formIsSubmitted = true;
    }
}