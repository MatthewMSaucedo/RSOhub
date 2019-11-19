import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AuthComponent } from './authorization/auth.component';
import { LoginComponent } from './authorization/login.component';
import { RegisterComponent } from './authorization/register.component';
import { HomeComponent } from './home/home.component';
import { RsoComponent } from './rso/rso.component';
import { EventsComponent } from './events/events.component';
import { UniversityComponent } from './university/university.component';
import { PetitionComponent } from './petition/petition.component';
import { MakeEventComponent } from './make-event/make-event.component';

const appRoutes: Routes =
[
    {
        path: '',
        redirectTo: '/auth/login',
        pathMatch: 'full'
    },
    {
        path: 'auth',
        component: AuthComponent,
        children: [
            {
                path: '',
                redirectTo: 'login',
                pathMatch: 'full'
            },
            {
                path: 'login',
                component: LoginComponent,
            },
            {
                path: 'register',
                component: RegisterComponent,
            },
        ]
    },
    {
        path: 'rso',
        component: RsoComponent
    },
    {
        path: 'events',
        component: EventsComponent
    },
    {
        path: 'make-event',
        component: MakeEventComponent
    },
    {
        path: 'university',
        component: UniversityComponent
    },
    {
        path: 'petition',
        component: PetitionComponent
    }
];

@NgModule
({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
