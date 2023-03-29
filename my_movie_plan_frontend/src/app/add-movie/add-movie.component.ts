import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Genre } from '../genre-sort/genre';
import { GenreService } from '../genre-sort/genre.service';
import { Movie } from '../movie-list/movie';
import { MovieService } from '../movie-list/movie.service';
import { AddMovieService } from './add-movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent {

  constructor(
    private router: Router,
    private movieService: MovieService,
    private genreService: GenreService,
    private addMovieService: AddMovieService
  ) {}

  movies: Movie[];
  genres: Genre[];

    form: any = {
      name: null,
      year: null,
      director: null,
      language: null,
      description: null,
      genre: null,
      status: null
    };

  ngOnInit(): void {
      this.genreService
      .getAllGenres()
      .subscribe((result) => (this.genres = result));
  }

  onSubmit() {
    console.log(this.form);
    this.addMovieService.addMovie(this.form)

    .subscribe(
      data => {
        console.log("Processed")
      },
      error => {
        console.log("Error processing")
        console.log(error)
      }
    );


  }

  btnClick = () => {
    console.log("Movie Added!");
  };

  genreSelection = (event: any) => {
    const genreId = event.target.value;
    const genre : Genre = {
      id: genreId,
      name: ''
    };
    this.form.genre = genre;
    
  };
  
}
