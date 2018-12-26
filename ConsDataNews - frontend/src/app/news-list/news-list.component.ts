import { Component, OnInit } from '@angular/core';
import { NewsService } from '../shared/news/news.service';
import { News } from '../news';


@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {
  selectedCategory: string;
  news: News;
  CATEGORIES = ['business', 'entertainment', 'health', 'science', 'sports', 'technology'];
  DEFAULT_CATEGORY = "technology";

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getNewsByCategory(this.DEFAULT_CATEGORY).subscribe((data: News) => this.news = { ...data }); 
  }

  changeCategory() {
    this.newsService.getNewsByCategory(this.selectedCategory).subscribe((data: News) => this.news = { ...data }); 
  }
  
}
