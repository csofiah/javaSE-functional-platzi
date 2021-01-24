package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DemoOptionals {

    public static void main(String[] args) {
        List<String> names = getNames();
        if(names == null){
            //Operar con nombres
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));
        //flatMap va recibir un elemento y va utilizar su valor
        //optionalNames.flatMap()

        Optional<String> valuePlayer = optionalValuablePlayer();
        String valuablePlayerName = valuePlayer.orElseGet(() -> "No player");
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
    static Optional<String> optionalValuablePlayer(){
        //buscar en base de datos el valor
        //return Optional.ofNullable();
        try{
            return  Optional.of("valor default");
        }catch(Exception e){
            e.printStackTrace();
        }
        //si no encuentra nada
        return Optional.empty();
    }

}
