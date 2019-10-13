import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleAdvert} from '../model/simple-advert.model';

@Injectable({
  providedIn: 'root'
})

export class HomeService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  getAdverts() {
    return this.http.get<SimpleAdvert[]>(this.url);
  }
}
