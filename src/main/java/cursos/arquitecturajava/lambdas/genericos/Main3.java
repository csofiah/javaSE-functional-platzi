package cursos.arquitecturajava.lambdas.genericos;
import cursos.arquitecturajava.lambdas.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Persona> listPersonas = new ArrayList<>();
        listPersonas.add(new Persona("pedro", "gomez", 30));
        listPersonas.add(new Persona("ana", "sanchez", 40));
        listPersonas.add(new Persona("gema", "blanco", 20));
        listPersonas.add(new Persona("antonio", "perez", 70));

        Filtro<Persona> filtroPedro = new FiltroPersonaNombre("pedro");
        Filtro<Persona> filtroPerezOrPedro =  filtroPedro.or(Persona::estaJubilado);

        //metodo de referencia
        List<Persona> nueva = buscarPersonConFiltro(filtroPerezOrPedro, listPersonas);


        for (Persona p: nueva){
            System.out.printf("persona: %s %s %s %n", p.getNombre(), p.getApellidos(), p.getEdad());
        }
    }

    public static List<Persona> buscarPersonConFiltro(Filtro<Persona> filtro, List<Persona> milista){
        List<Persona> listaFiltro = new ArrayList<Persona>();

        for (Persona p:milista){
            if (filtro.test(p)){
                listaFiltro.add(p);
            }
        }
        return listaFiltro;

    }
}
