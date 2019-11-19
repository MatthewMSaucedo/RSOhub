import { Component, OnInit } from '@angular/core';
import { EventsService } from './events.service';
import { CreateCommentResponse, CreateCommentRequest } from '../server-communication/rso-endpoint.constants';
import { NgForm } from '@angular/forms';
import { AuthService } from '../authorization/auth.service';

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
    public events;
    public comments;
    public locations: string[];
    public isLoading = true;
    public refEventBeingCommented: number;
    public isAddingComment = false;

    constructor(
        public eventsService: EventsService,
        public authService: AuthService
    ) { }

    async ngOnInit() {
        this.events = await this.eventsService.listUserEvents();
        this.locations = await this.eventsService.listEventLocations(this.events);
        this.comments = await this.eventsService.listEventComments(this.events);
        console.log(this.comments);
        this.isLoading = false;
    }

    public async onSubmit(form: NgForm): Promise<void> {
        const date = new Date();
        const createCommentRequest = {
            rating: form.value.rating,
            refEventId: this.refEventBeingCommented,
            refUserId: this.authService.userId,
            text: form.value.commentText,
            time: date.toTimeString()
        }
        await this.eventsService.createComment(createCommentRequest);
        this.comments = await this.eventsService.listEventComments(this.events);
        console.log(createCommentRequest);
    }

    public addComment(refEventId: number) {
        this.isAddingComment = !this.isAddingComment;
        this.refEventBeingCommented = refEventId;
    }
/*public async onSubmit(form: NgForm): Promise<void> {
        const username = form.value.username;
        this._username = username;
        const password = form.value.password;
        await this.authService.login(username, password);
        form.reset();
    } */

}
