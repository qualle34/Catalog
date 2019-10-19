import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Advert} from '../../model/advert.model';

@Injectable({
  providedIn: 'root'
})
export class AdvertService {
  apiUrl = 'http://localhost:8080/advert?id=';

  constructor(private http: HttpClient) {
  }

  getAdvert(id) {
    return this.http.get<Advert>(this.apiUrl + id);
  }
}
