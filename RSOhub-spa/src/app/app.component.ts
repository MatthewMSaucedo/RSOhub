import { Component } from '@angular/core';
import { RsoEndpointService } from './server-communication/rso-endpoint.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'RSOhub';

    constructor(public rsoEndpointService: RsoEndpointService) {}

    public async handleDemoClick(): Promise<void> {
        const response = await this.rsoEndpointService.getValues();
        console.log(response);
    }
}
