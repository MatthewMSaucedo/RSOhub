import { Component, OnInit } from '@angular/core';
import { EventsService } from './events.service';
import { CreateCommentResponse } from '../server-communication/rso-endpoint.constants';

export class _Event {
    id: number;
    refLocationId: number;
    refRsoId: number;
    time: string;
    name: string;
    description: string;
    eventType: string;
}

@Component({
    selector: 'app-events',
    templateUrl: './events.component.html',
    styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {
    public events: _Event[];
    public comments: CreateCommentResponse[][];
    public locations: string[];
    public isLoading = true;

    constructor(public eventsService: EventsService) { }

    async ngOnInit() {
        this.events = await this.eventsService.listUserEvents();
        this.locations = await this.eventsService.listEventLocations(this.events);
        this.comments = await this.eventsService.listEventComments(this.events);
        this.isLoading = false;
    }

    public async onSubmit(form: NgForm): Promise<void> {}

}
