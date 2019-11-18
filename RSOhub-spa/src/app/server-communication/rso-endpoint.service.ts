import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginResponse, LoginRequest, RegisterResponse, RegisterRequest, CreateCommentRequest, CreateCommentResponse, DeleteCommentResponse, ListCommentResponse, PetitionRequest, JoinRequest } from './rso-endpoint.constants';

@Injectable({ providedIn: 'root' })
export class RsoEndpointService {
    private _dbUrl = 'http://localhost:8080/api/';

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

    public listRsoByUserId(userId: number) { }

    public createPetition(petitionRequest: PetitionRequest) { }

    public joinRso(joinRequest: JoinRequest) { }

}
