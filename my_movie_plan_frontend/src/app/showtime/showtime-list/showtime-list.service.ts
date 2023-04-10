import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Showtime } from '../showtime';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/movie-list/movie.service';

@Injectable({
  providedIn: 'root'
})
export class ShowtimeListService {

  url: string = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router, private movieService: MovieService) { }

  getAllShowtimes(): Observable<Showtime[]> {
    return this.http.get<Showtime[]>(this.url + "/showtime");
  }

  getShowtimeByMovieId(id: any): Observable<Showtime[]> {
    return this.http.post<Showtime[]>(this.url + "/showtime/search", {"movieId" : id})
  }
  
  getMovieShowtimes(movieId: number) {
    console.log("movie id: " + movieId)
    this.movieService.getMovieById(movieId).subscribe(movie => {
      //window.location.href = `http://localhost:4200/listshowtime?movieId=${movie.id}`;
      
      this.router.navigate([`/listshowtime`], {queryParams: { movieId: movieId} })
    });

  

}
}
