import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class RsoEndpointService {
    private _dbUrl = 'http://localhost:5000/api/';

    constructor(private http: HttpClient) { }

}
