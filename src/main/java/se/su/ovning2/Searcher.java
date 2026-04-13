package se.su.ovning2;

import java.util.*;

public class Searcher implements SearchOperations {

    private Set<String> genres;
    private Set<String> artists;
    private Set<String> titles;
    private Collection<Recording> recordings;

    private Map<String, Recording> recordingsByTitle;
    private Map<String, Set<Recording>> recordingByArtist;
    private Map<String, Set<Recording>> recordingByGenre;
    private TreeMap<Integer, Set<Recording>> recordingByYear;
// ^ instansvariabler ^

    public Searcher(Collection<Recording> data) {

        genres = new HashSet<>();
        artists = new HashSet<>();
        titles = new HashSet<>();
        recordings = new HashSet<>(data);

        for (Recording r : data) {
            artists.add(r.getArtist());
            titles.add(r.getTitle());
            genres.addAll(r.getGenre());
        }/*For loop som lägger till varje artist från varje recording i en hash set och gör samma sak för
    titles och genrer.*/

        recordingsByTitle = new HashMap<>();
        recordingByArtist = new HashMap<>();
        recordingByGenre = new HashMap<>();
        recordingByYear = new TreeMap<>();

        for (Recording r : data) {
            recordingsByTitle.put(r.getTitle(), r);
            /*Sparar varje recording i en map med titel som nyckel*/

            if (!recordingByArtist.containsKey(r.getArtist())) {
                recordingByArtist.put(r.getArtist(), new HashSet<>());
            }
            recordingByArtist.get(r.getArtist()).add(r);
            // kollar om artisten redan finns i mapen, om inte skapas ett nytt Set för att lagra recordings för denna artist
            // hämtar sedan set för artisten och lägger till i mapen

            for(String genre : r.getGenre()) {
                if(!recordingByGenre.containsKey(genre)) {
                    recordingByGenre.put(genre, new HashSet<>());
                }
                recordingByGenre.get(genre).add(r);
            }

            if(!recordingByYear.containsKey(r.getYear())) {
                recordingByYear.put(r.getYear(), new HashSet<>());
            }
            recordingByYear.get(r.getYear()).add(r);
        }

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
        return artists.contains(name);
    }

    //simon
    @Override
    public Collection<String> getGenres() {
        return Collections.unmodifiableSet(genres);
        // returnerear en omodefierarbar samling
    }

    //antonios
    @Override
    public Recording getRecordingByName(String title) {
        return recordingsByTitle.get(title);
        //Hämtar recordingen som har parameterns titel från hashmapen recordingsByTitle.
    }

    //simon
    @Override
    public Collection<Recording> getRecordingsAfter(int year) {
        SortedMap<Integer, Set<Recording>> tail = recordingByYear.tailMap(year);
        //hämtar en Map av alla recordings som är >= det angivna året
        Set<Recording> result = new HashSet<>();
        //skapar ett set där alla dessa recordings ska samlas

        for (Set<Recording> set : tail.values()) {
            result.addAll(set);
            //loopar igenom alla dessa recordings och lägger till de i result
        }
        return Collections.unmodifiableSet(result);
        //returnerar en omodifierbar set med dessa recordings
    }

    //antonios
    @Override
    public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {

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
