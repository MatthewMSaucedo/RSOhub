import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../authorization/auth.service';
import { MakeEventService } from './make-event.service';

@Component({
    selector: 'app-make-event',
    templateUrl: './make-event.component.html',
    styleUrls: ['./make-event.component.scss']
})
export class MakeEventComponent implements OnInit {
    public latitude = 28.602427;
    public longitude = -81.200058;
    public zoom = 17;

    constructor(
        public toastrService: ToastrService,
        public authService: AuthService,
        public makeEventService: MakeEventService
    ) { }

    ngOnInit() {}

    public async onSubmit(form: NgForm) {
        const eventRequest = {
            rsoName: form.value.rso,
            locationName: form.value.location,
            eventTime: form.value.time,
            eventName: form.value.name,
            description: form.value.description,
            eventType: form.value.eventType
        };
        try {
            await this.makeEventService.createEvent(eventRequest);
            this.toastrService.success('Event created!');
        } catch (e) {
            this.toastrService.error('Event creation failed!');
        }
    }
}