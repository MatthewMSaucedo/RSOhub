import { Injectable } from '@angular/core';
import { RsoEndpointService } from '../server-communication/rso-endpoint.service';
import { CreateCommentResponse } from '../server-communication/rso-endpoint.constants';
import { AuthService } from '../authorization/auth.service';
import { _Event } from './events.component';

@Injectable({ providedIn: 'root' })
export class EventsService {
    constructor(
        public endpointService: RsoEndpointService,
        public authService: AuthService
    ) {}

    public async listUserEvents() {
        return await this.endpointService.listUserEvents({refUserId: this.authService.userId});
    }

    public async listEventLocations(events: _Event[]): Promise<string[]> {
        let eventLocations = [];
        for (let event of events) {
            const location = await this.endpointService.getLocation({refLocationId: event.refLocationId});
            eventLocations.push(location.name);
        }
        return eventLocations;
    }

    public async listEventComments(events: _Event[]) {
        let eventComments = [];
        for (let event of events) {
            const comments = await this.endpointService.listComment(event.id);
            eventComments.push(comments);
        }
        return eventComments;
    }

    public async createComment(comment) {
        await this.endpointService.createComment(comment);
    }
}
