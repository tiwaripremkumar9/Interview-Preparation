package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public int compareTo(Movie m) {
        return (this.getYear() - m.getYear());
    }
}


class ComparableExample {

    public static void main(String[] args) {
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("Force Awakens", 8.3, 2015));
        moviesList.add(new Movie("Star Wars", 8.7, 1977));
        moviesList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        moviesList.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(moviesList);
        for (Movie movie : moviesList) {
            System.out.println(movie.getName() + " " +
            movie.getRating() + " " +
            movie.getYear());
        }
    }
}
