package cursos.arquitecturajava.lambdas.staticmethods;
import cursos.arquitecturajava.lambdas.Persona;
import cursos.arquitecturajava.lambdas.predicate.FiltroPersonaNombre;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main5 {
    public static void main(String[] args) {
        ArrayList<Persona> listPersonas = new ArrayList<>();
        listPersonas.add(new Persona("pedro", "gomez", 30));
        listPersonas.add(new Persona("ana", "sanchez", 40));
        listPersonas.add(new Persona("gema", "blanco", 20));
        listPersonas.add(new Persona("antonio", "perez", 70));

        Predicate<Persona> filtroPedro = new FiltroPersonaNombre("pedro");
        Predicate<Persona> filtroJubilado =  Persona::estaJubilado;

        //metodo de referencia
        List<Persona> nueva = buscarPersonConFiltro(FiltroPersona.orMultiple(filtroPedro, filtroJubilado), listPersonas);


        for (Persona p: nueva){
            System.out.printf("persona: %s %s %s %n", p.getNombre(), p.getApellidos(), p.getEdad());
        }
    }

    public static List<Persona> buscarPersonConFiltro(Predicate<Persona> filtro, List<Persona> milista){
        List<Persona> listaFiltro = new ArrayList<Persona>();

        for (Persona p:milista){
            if (filtro.test(p)){
                listaFiltro.add(p);
            }
        }
        return listaFiltro;

    }
}
