package com.platzi.functional._14_optionals;

import java.util.*;

public class DemoOptionals {

    //platzi
    public static void main(String[] args) {
        List<String> names = getNames();
        if(names == null){
            //Operar con nombres
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }
        //ifPresent(Consumer toma un dato pero no retirna resultado)
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));
        //flatMap va recibir un elemento y va utilizar su valor
        //optionalNames.flatMap()

        Optional<String> valuePlayer = optionalValuablePlayer();
        String valuablePlayerName = valuePlayer.orElseGet(() -> "No player");

        //adictosaltrabajo

        Optional<String> optionalNames2 = validEmptyString(getNamesWithValues());
        optionalNames2.filter(s -> !s.isEmpty())
                .map(s -> s.toUpperCase(Locale.ROOT))
                .orElse("nombres vacios");





    }
    static Optional<String> validEmptyString(List<String> names){
        if(names == null || names.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(Arrays.toString(names.toArray()));
    }

    static List<String> getNamesWithValues(){
        List<String> list = new LinkedList<>();
        list.add("ana");
        list.add("pedro");
        list.add("david");

        return list;
    }

    static List<String> getNames(){
       List<String> list = new LinkedList<>();

       return Collections.emptyList();
    }

    static Optional<List<String>> getOptionalNames(){
        List<String> nameList = new LinkedList<>();
        //obtencion de nombres
        return Optional.of(nameList);
    }

    //se le dice a optional q se desconoce si el dato es null o no
    static Optional<String> optionalValuablePlayer() {
        //buscar en base de datos el valor
        //return Optional.ofNullable();
        try {
            return Optional.of("valor default");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //si no encuentra nada
        return Optional.empty();
    }

    static double getDurationOfAlbumWithName(String name){
        return getAlbum(name)
                .flatMap((album) -> getAlbumTracks(getName()))
                .map((tracks) -> getTracksDuration(getName()))
                .orElse(0.0);
    }

    //other example with orElseGet //is for execute the function
   /* private static Album getAlbum(String albumName) {
        Album album = getAlbumFromCache(albumName)
                .orElseGet(() -> getAlbumFromDisk(albumName));
        return album;
    }*/

    static Optional<String> getAlbum(String name){
        return Optional.of(name.concat("Album"));
    }

    static Optional<List<String>>  getAlbumTracks(String albumName){
        List<String> listTracks = new LinkedList<>();
        listTracks.add("song1");
        listTracks.add("song2");
        listTracks.add("song3");

       List<String> emptyTracks = new ArrayList<>();

        return Optional.of(listTracks);


    }
    static String getName(){
        return "Album1";
    }
    static double getTracksDuration(String nameTrack){
        return 1.5;
    }

}
