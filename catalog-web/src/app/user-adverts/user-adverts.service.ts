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

  addAdvert(advert: Advert, token: string) {
    this.http.post(this.url + '/advert/add', advert, {headers: {'token': token}}).subscribe();
  }

  updateAdvert(advert: Advert, token: string) {
    this.http.put(this.url + '/advert/update', advert, {headers: {'token': token}}).subscribe();
  }

  deleteAdvert(id: number, token: string) {
    this.http.delete(this.url + '/advert/delete/' + id, {headers: {'token': token}}).subscribe();
  }
}
