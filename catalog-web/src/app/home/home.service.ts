import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleAdvert} from '../model/simple-advert.model';
import {Category} from '../model/category.model';

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

  getCategories() {
    return this.http.get<Category[]>(this.url + '/categories');
  }

  getAdvertsByCategory(categoryId) {
    return this.http.get<SimpleAdvert[]>(this.url + '?category=' + categoryId);
  }

  getBySearch(search) {
    return this.http.get<SimpleAdvert[]>(this.url + '?search=' + search);
  }
}
