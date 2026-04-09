package se.su.ovning2;

import java.util.Collection;
import java.util.SortedSet;

public class Searcher implements SearchOperations {

  public Searcher(Collection<Recording> data) {

    Collection<Recording> recordings = data;
  }
    //simon
  @Override
  public long numberOfArtists() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'numberOfArtists'");
  }
    //antonios
  @Override
  public long numberOfGenres() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'numberOfGenres'");
  }
    //simon
  @Override
  public long numberOfTitles() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'numberOfTitles'");
  }
  //antonios
  @Override
  public boolean doesArtistExist(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'doesArtistExist'");
  }
    //simon
  @Override
  public Collection<String> getGenres() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getGenres'");
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
