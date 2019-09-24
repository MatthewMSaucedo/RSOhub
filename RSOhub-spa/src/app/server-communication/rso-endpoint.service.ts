import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GetValuesResponse } from './rso-endpoint.constants';

@Injectable({ providedIn: 'root' })
export class RsoEndpointService {
    private _dbUrl = 'http://localhost:5000/api/';

    constructor(private http: HttpClient) { }

    public getValues(): Promise<GetValuesResponse> {
        return this.http.get<GetValuesResponse>(this._dbUrl + 'values').toPromise();
    }

}
