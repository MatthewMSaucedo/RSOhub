import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { LoginResponse, LoginRequest, RegisterResponse, RegisterRequest, CreateCommentRequest, CreateCommentResponse, DeleteCommentResponse, ListCommentResponse, PetitionRequest, JoinRequest, ListRsoByUserIdResponse, GetLocationResponse } from './rso-endpoint.constants';
import { _Event } from '../events/events.component';

@Injectable({ providedIn: 'root' })
export class RsoEndpointService {
    private _dbUrl = 'http://localhost:8080/api/';
    public httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'Authorization': 'my-auth-token'
        })
    };

    constructor(private http: HttpClient) { }

    public login(loginRequest: LoginRequest): Promise<LoginResponse> {
        return this.http.post<LoginResponse>(this._dbUrl + 'auth/login', loginRequest).toPromise();
    }

    public register(registerRequest: RegisterRequest): Promise<RegisterResponse> {
        return this.http.post<RegisterResponse>(this._dbUrl + 'auth/register', registerRequest).toPromise();
    }

    public createComment(createCommentRequest: CreateCommentRequest): Promise<CreateCommentResponse> {
        return this.http.post<CreateCommentResponse>(this._dbUrl + 'comment/create', createCommentRequest).toPromise();
    }

    public deleteComment(commentId: number): Promise<DeleteCommentResponse> {
        return this.http.post<DeleteCommentResponse>(this._dbUrl + 'comment/delete', commentId).toPromise();
    }

    public listComment(eventId: number): Promise<ListCommentResponse> {
        return this.http.post<ListCommentResponse>(this._dbUrl + 'comment/listByEvent', eventId).toPromise();
    }

    public listRsoByUserId(userId: number) {
        return this.http.post(this._dbUrl + 'rso/listByUserId', userId).toPromise();
    }

    public createPetition(petitionRequest) {
        return this.http.post(this._dbUrl + 'rso/petition', petitionRequest).toPromise();
    }

    public joinRso(joinRequest) {
        return this.http.post(this._dbUrl + 'rso/join', joinRequest).toPromise();
    }

    public getUniversityIdFromName(request): Promise<number> {
        return this.http.post<number>(this._dbUrl + 'university/findByName', request).toPromise();
    }

    public listUserEvents(request) {
        return this.http.post(this._dbUrl + 'event/listUserEvents', request).toPromise();
    }

    public getLocation(request): Promise<GetLocationResponse> {
        return this.http.post<GetLocationResponse>(this._dbUrl + 'location/get', request).toPromise();
    }

    public isUserInRso(request) {
        return this.http.post(this._dbUrl + 'rso/isUserInRso', request).toPromise();
    }

    public listRso() {
        return this.http.post(this._dbUrl + 'rso/list', null).toPromise();
    }
}
