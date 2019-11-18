import { Subject } from 'rxjs';
import { RsoEndpointService } from '../server-communication/rso-endpoint.service';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
    public currentView = new Subject<string>();
    public loginToast = new Subject<boolean>();
    public registerToast = new Subject<boolean>();
    public isLoggedIn = new Subject<boolean>();
    public loggedInUser: string;
    public userType: string;

    constructor(public endpointService: RsoEndpointService) { }

    public async registerUser(username: string, universityName: string, password: string): Promise<void> {
        try {
            const refUniversityId = await this.endpointService.getUniversityIdFromName({universityName});

            const response = await this.endpointService.register({username, refUniversityId, password});
            if (response != null) {
                this.registerToast.next(true);
            } else {
                this.registerToast.next(false);
            }
        } catch (error) {
            this.registerToast.next(false);
        }
    }

    public async login(username: string, password: string): Promise<void> {
        try {
            const response = await this.endpointService.login({username, password});
            if (response.loginSuccessful) {
                this.loginToast.next(true);
                this.isLoggedIn.next(true);
                this.loggedInUser = username;
                this.userType = response.userType;
            } else {
                this.loginToast.next(false);
            }
        } catch (error) {
            this.loginToast.next(false);
        }
    }
}
