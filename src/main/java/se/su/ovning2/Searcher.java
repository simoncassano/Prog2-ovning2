package se.su.ovning2;

import java.util.*;

public class Searcher implements SearchOperations {



    private Set<String> genres;
    private Set<String> artists;
    private Set<String> titles;
    private Collection<Recording> recordings;
// ^ instansvariabler ^

    public Searcher(Collection<Recording> data) {
        recordings = data;

        genres = new HashSet<>();
        artists = new HashSet<>();
        titles = new HashSet<>();

        for (Recording r : data) {
            artists.add(r.getArtist());
            titles.add(r.getTitle());
            genres.addAll(r.getGenre());
        }/*For loop som lägger till varje artist från varje recording i en hash set och gör samma sak för
    titles och genrer.*/
    }

    //simon
    @Override
    public long numberOfArtists() {
        return artists.size();

    }

    //antonios
    @Override
    public long numberOfGenres() {
        return genres.size();
    }

    //simon
    @Override
    public long numberOfTitles() {
        return titles.size();
    }

    //antonios
    @Override
    public boolean doesArtistExist(String name) {
        // TODO Auto-generated method stub
        return artists.contains(name);
    }

    //simon
    @Override
    public Collection<String> getGenres() {
        return Collections.unmodifiableSet(genres);

    }

    //antonios
    @Override
    public Recording getRecordingByName(String title) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'getRecordingByName'");
    }

    //simon
    @Override
    public Collection<Recording> getRecordingsAfter(int year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecordingsAfter'");
    }

    //antonios
    @Override
    public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'getRecordingsByArtistOrderedByYearAsc'");
    }

    //simon
    @Override
    public Collection<Recording> getRecordingsByGenre(String genre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecordingsByGenre'");
    }

    //antonios
    @Override
    public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearFrom, int yearTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecordingsByGenreAndYear'");
    }

    //simon
    @Override
    public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'offerHasNewRecordings'");
    }
}
