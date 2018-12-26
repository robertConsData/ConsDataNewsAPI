import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { News } from '../../news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  NEWS_PL_BASE_PATH = "//localhost:8080/news/pl/";

  constructor(private http: HttpClient) { }

  getNewsByCategory(category: String){
    return this.http.get<News>( this.NEWS_PL_BASE_PATH + category + '/');

  }
}

