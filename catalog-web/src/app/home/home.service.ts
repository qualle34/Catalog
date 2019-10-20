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

  getAdvertsByCategory(categoryId: number) {
    return this.http.get<SimpleAdvert[]>(this.url + '?category=' + categoryId);
  }

  getAdvertsByType(type: string) {
    return this.http.get<SimpleAdvert[]>(this.url + '?type=' + type);
  }

  getAdvertsByCategoryAndType(categoryId: number, type: string) {
    return this.http.get<SimpleAdvert[]>(this.url + '?category=' + categoryId + '&type=' + type);
  }

  getBySearch(search: string) {
    return this.http.get<SimpleAdvert[]>(this.url + '?search=' + search);
  }

  getAdvertsBySearchAndType(search: string, type: string) {
    return this.http.get<SimpleAdvert[]>(this.url + '?search=' + search + '&type=' + type);
  }
}
