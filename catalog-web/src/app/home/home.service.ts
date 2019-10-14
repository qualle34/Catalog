import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleAdvert} from '../model/simple-advert.model';
import {Category} from '../model/category.model';

@Injectable({
  providedIn: 'root'
})

export class HomeService {
  url = 'http://localhost:8080';
  categoriesUri = '/categories';
  byCategoryUri = '?category=';
  bySearchUri = '?search=';

  constructor(private http: HttpClient) {
  }

  getCategories() {
    return this.http.get<Category[]>(this.url + this.categoriesUri);
  }

  getAdverts() {
    return this.http.get<SimpleAdvert[]>(this.url);
  }

  getAdvertsByCategory(categoryId) {
    return this.http.get<SimpleAdvert[]>(this.url + this.byCategoryUri + categoryId);
  }

  getBySearch(search) {
    return this.http.get<SimpleAdvert[]>(this.url + this.bySearchUri + search);
  }
}
