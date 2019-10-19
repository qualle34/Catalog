import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleAdvert} from '../model/simple-advert.model';
import {Advert} from '../model/advert.model';

@Injectable({
  providedIn: 'root'
})

export class UserAdvertsService {
  url = 'http://localhost:8080/my';

  constructor(private http: HttpClient) {
  }

  getUserAdverts(token: string) {
   return this.http.get<SimpleAdvert[]>(this.url + '/adverts', {headers: {'token': token}});
  }

  getUserAdvert(id: string, token: string) {
    return this.http.get<Advert>(this.url + '/advert?id=' + id, {headers: {'token': token}});
  }
}
