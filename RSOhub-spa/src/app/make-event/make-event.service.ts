import { RsoEndpointService } from '../server-communication/rso-endpoint.service';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MakeEventService {
    constructor(public rsoEndpointService: RsoEndpointService) {}

    public async createEvent(eventRequest) {
        // Create location.
        const locationId = await this.rsoEndpointService.createLocation(eventRequest.locationName);

        // Get RSO id.
        const rsoId = await this.rsoEndpointService.getRsoIdByName(eventRequest.rsoName);

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
}