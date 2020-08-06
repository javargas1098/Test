import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class PlanetService {

    private allPlanets = environment.baseUrl + 'planet/all';

    constructor(private httpClient: HttpClient) {
    }

    public getAllPlanets() {
        return this.httpClient.get<any>(this.allPlanets).pipe(catchError(err => this.errorFunction(err)));
    }

    private errorFunction(error) {
        return throwError(error.message || 'server error');
    }
}
  