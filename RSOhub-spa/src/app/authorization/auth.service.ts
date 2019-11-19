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
    public userId: number;

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
                console.log(response);
                this.loggedInUser = username;
                this.userType = response.userType;
                this.userId = response.userId;
                this.loginToast.next(true);
                this.isLoggedIn.next(true);
            } else {
                this.loginToast.next(false);
            }
        } catch (error) {
            this.loginToast.next(false);
        }
    }
}
