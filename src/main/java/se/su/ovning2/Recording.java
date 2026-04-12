package se.su.ovning2;

import java.util.*;

public class Recording implements Comparable<Recording> {
  private final int year;
  private final String artist;
  private final String title;
  private final String type;
  private final Set<String> genre;

  public Recording(String title, String artist, int year, String type, Set<String> genre) {
    this.title = title;
    this.year = year;
    this.artist = artist;
    this.type = type;
    this.genre = genre;
  }

  public String getArtist() {
    return artist;
  }

  public Collection<String> getGenre() {
    return genre;
  }

  public String getTitle() {
    return title;
  }

  public String getType() {
    return type;
  }

  public int getYear() {
    return year;
  }

  /*Är en Override av Javas compareTo metod med egen kod för detta sammahanget
  *Vi använder denna för att sortera objekten till vår TreeMap/Set
  * Om compare != 0 så avslutar vi metoden tidigt då vi vet att
  * Någon variabel inte matchar
  * */

  @Override
  public int compareTo(Recording toBeCompared) {
    int compare = this.title.compareTo(toBeCompared.title);
    if (compare != 0) {
      return compare;
    }
    compare = this.artist.compareTo(toBeCompared.artist);
    if (compare !=0) {
      return compare;
    }
    return Integer.compare(this.year, toBeCompared.year);
  }

  /*Är vår version av javas equals metod, använder artist, år och titel
  som unik kombination
  *
  * */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Recording)) return false;
    Recording toBeCompared = (Recording) obj;
    return year == toBeCompared.year && artist.equals(toBeCompared.artist) && title.equals(toBeCompared.title);
  }

  /*Javas metod hashCode fast med våra variabler
  *
  * */

  @Override
  public int hashCode() {
    return Objects.hash(year, artist, title);
  }


  @Override
  public String toString() {
    return String.format("{ %s | %s | %s | %d | %s }", artist, title, genre, year, type);
  }
}
