import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class PersonService {

    private allPersons = environment.baseUrl + 'person/all';

    constructor(private httpClient: HttpClient) {
    }

    public getAllPersons() {
        return this.httpClient.get<any>(this.allPersons).pipe(catchError(err => this.errorFunction(err)));
        
    }

    private errorFunction(error) {
        return throwError(error.message || 'server error');
    }
}