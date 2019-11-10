import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from './auth.service';

@Component({
    selector: 'app-auth',
    template: `
    <body *ngIf="isLoginView; else registerView" class="container">
        <div class="desktop-auth-login">
            <router-outlet></router-outlet>
        </div>
    </body>
    <ng-template #registerView>
        <body class="container">
            <div class="desktop-auth-register">
                <router-outlet></router-outlet>
            </div>
        </body>
    </ng-template>
    `,
    styleUrls: ['auth.component.scss']
})
export class AuthComponent implements OnInit, OnDestroy {
    public isLoginView = true;
    public viewChangeSubscription: Subscription;

    constructor(public authService: AuthService) { }

    ngOnInit(): void {

        // Toggle size of window bases on register or login view.
        this.viewChangeSubscription = this.authService.currentView.subscribe((view: string) => {
            if (view === 'login') {
                this.isLoginView = true;
            } else {
                this.isLoginView = false;
            }
        });
    }

    ngOnDestroy(): void {
        this.viewChangeSubscription.unsubscribe();
    }
}
