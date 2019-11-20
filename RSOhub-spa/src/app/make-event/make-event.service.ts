import { RsoEndpointService } from '../server-communication/rso-endpoint.service';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MakeEventService {
    constructor(public rsoEndpointService: RsoEndpointService) {}

    public async createEvent(eventRequest) {
        // Create location.
        const location: any = await this.rsoEndpointService.createLocation({ name: eventRequest.locationName });
        const locationId = location.id;
        console.log(eventRequest);
        console.log("hi");

        // Get RSO id.
        const rsoId = await this.rsoEndpointService.getRsoIdByName({ rsoName: eventRequest.rsoName});

        const createEventRequest = {
            refLocationId: locationId,
            refRsoId: rsoId,
            time: eventRequest.eventTime,
            name: eventRequest.eventName,
            description: eventRequest.description,
            eventType: eventRequest.eventType
        };

        // Create event.
        await this.rsoEndpointService.createEvent(createEventRequest);
    }

    public async testGetRso(request) {
        let response = await this.rsoEndpointService.getRsoIdByName(request);
    }
}
