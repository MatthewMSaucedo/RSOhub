import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../authorization/auth.service';
import { Subscription } from 'rxjs';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
    public isLoggedIn = false;
    public userType: string;
    authSubscription: Subscription;

    constructor(public authService: AuthService) { }

    ngOnInit() {
        this.authSubscription = this.authService.isLoggedIn.subscribe((loginStatus: boolean) => {
            if (!this.isLoggedIn && loginStatus) {
                this.userType = this.authService.userType;
            }
            console.log(this.userType);
            this.isLoggedIn = loginStatus;
        });
    }

    ngOnDestroy() {
        this.authSubscription.unsubscribe();
    }

}
