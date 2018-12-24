import { Component, OnInit } from '@angular/core';
import { NewsService } from '../shared/news/news.service';
import { News } from '../news';


@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {

  news: News;

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getAll().subscribe((data: News) => this.news = { ...data }); 
    
  }

}
