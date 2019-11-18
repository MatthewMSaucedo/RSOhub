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

@NgModule({
  declarations: [
    HomeComponent,
    AppComponent,
    HeaderComponent,
    AuthComponent,
    LoginComponent,
    RegisterComponent,
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
