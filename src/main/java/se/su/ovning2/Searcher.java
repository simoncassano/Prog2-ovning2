package se.su.ovning2;

import java.util.*;

public class Searcher implements SearchOperations {

    private Set<String> genres;
    private Set<String> artists;
    private Set<String> titles;
    private Collection<Recording> recordings;

    private Map<String, Recording> recordingsByTitle;
    private Map<String, Set<Recording>> recordingsByArtist;
    private Map<String, Set<Recording>> recordingByGenre;
    private TreeMap<Integer, Set<Recording>> recordingByYear;
// ^ instansvariabler ^

    public Searcher(Collection<Recording> data) {
        recordings = new HashSet<>(data);

        genres = new HashSet<>();
        artists = new HashSet<>();
        titles = new HashSet<>();

        recordingsByTitle = new HashMap<>();
        recordingsByArtist = new HashMap<>();
        recordingByGenre = new HashMap<>();
        recordingByYear = new TreeMap<>();

        for (Recording r : data) {
            artists.add(r.getArtist());
            titles.add(r.getTitle());
            genres.addAll(r.getGenre());
        /*For loop som lägger till varje artist från varje recording i en hash set och gör samma sak för
        titles och genrer.*/

            recordingsByTitle.put(r.getTitle(), r);
            /*Sparar varje recording i en map med titel som nyckel*/

            if (!recordingsByArtist.containsKey(r.getArtist())) {
                recordingsByArtist.put(r.getArtist(), new HashSet<>());
            }
            recordingsByArtist.get(r.getArtist()).add(r);
            /*Sparar varje recording i en map med artist som nyckel*/

            for (String genre : r.getGenre()) {
                if (!recordingByGenre.containsKey(genre)) {
                    recordingByGenre.put(genre, new HashSet<>());
                }
                recordingByGenre.get(genre).add(r);
            }

            if (!recordingByYear.containsKey(r.getYear())) {
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
        /*Treeset som sorterar reordings efter år (stigande)*/
        SortedSet<Recording> result = new TreeSet<>(Comparator.comparingInt(Recording::getYear).thenComparing(Recording::getTitle));

        /*Kontrollera om artisten finns i vår map*/
        if (recordingsByArtist.containsKey(artist)) {
            result.addAll(recordingsByArtist.get(artist));
        }
        return Collections.unmodifiableSortedSet(result);
    }

    //simon
    @Override
    public Collection<Recording> getRecordingsByGenre(String genre) {
        //om genren inte finns returneras en tom samling
        if (!recordingByGenre.containsKey(genre)) {
            return Collections.emptySet();
        }

        return Collections.unmodifiableSet(recordingByGenre.get(genre));
        //returnerar setet som finns, omodifierbart
    }

    //antonios
    @Override
    public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearFrom, int yearTo) {

        Set<Recording> result = new HashSet<>();
        //Kontrollera att genren finns i vår map
        if (recordingByGenre.containsKey(genre)) {

            //Hämta alla genren som finns i vår map och gå igenom de en i taget
            for (Recording r : recordingByGenre.get(genre)) {
                //Filtrering
                if (r.getYear() >= yearFrom && r.getYear() <= yearTo) {
                    result.add(r);
                }
            }
        }
        return Collections.unmodifiableSet(result);

    }

    //simon
    @Override
    public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered) {

        Set<Recording> result = new HashSet<>();

        for (Recording r : offered) {
            if (!recordings.contains(r)) {
                result.add(r);
            }
        }
        return Collections.unmodifiableSet(result);

    }


}