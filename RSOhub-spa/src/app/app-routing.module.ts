import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AuthComponent } from './authorization/auth.component';
import { LoginComponent } from './authorization/login.component';
import { RegisterComponent } from './authorization/register.component';
import { HomeComponent } from './home/home.component';

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
    }
];

@NgModule
({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
