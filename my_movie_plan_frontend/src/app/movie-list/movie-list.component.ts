import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from './movie';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private movieService: MovieService
  ) {}

  movies: Movie[];

  ngOnInit(): void {
    this.movieService
      .getAllMovies()
      .subscribe((result) => {
        console.log(result)

        this.movies = result
      });
  }

  // btnClick = (id: number, name: string, language: string,
  //   director: string, description: string, year: number) => {
  //   let movie = new Movie()
  //   movie.id = id
  //   movie.name = name;
  //   movie.director = director;
  //   movie.description = description;
  //   movie.year = year;
  //   movie.language = language;
  //   // this.movieService.addToCart(movie)
  // };

}
