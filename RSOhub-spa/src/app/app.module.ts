import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { AuthComponent } from './authorization/auth.component';
import { LoginComponent } from './authorization/login.component';
import { RegisterComponent } from './authorization/register.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { EventsComponent } from './events/events.component';
import { UniversityComponent } from './university/university.component';
import { PetitionComponent } from './petition/petition.component';
import { RsoComponent } from './rso/rso.component';
import { MakeEventComponent } from './make-event/make-event.component';

@NgModule({
  declarations: [
    HomeComponent,
    AppComponent,
    HeaderComponent,
    AuthComponent,
    LoginComponent,
    RegisterComponent,
    EventsComponent,
    UniversityComponent,
    PetitionComponent,
    RsoComponent,
    MakeEventComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
  ],
  providers: [ HttpClient ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
