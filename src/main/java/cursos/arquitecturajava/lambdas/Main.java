package cursos.arquitecturajava.lambdas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> listPersonas = new ArrayList<>();
        listPersonas.add(new Persona("pedro", "gomez", 30));
        listPersonas.add(new Persona("ana", "sanchez", 40));
        listPersonas.add(new Persona("gema", "blanco", 20));

      // listPersonas.sort((p1,p2) -> p1.getNombre().compareTo(p2.getNombre())) ;

       List<Persona> nueva = buscarPersonaPorNombre("pedro", listPersonas);

        for (Persona p: nueva){
            System.out.printf("persona: %s %s %s %n", p.getNombre(), p.getApellidos(), p.getEdad());
        }
    }

    public static List<Persona> buscarPersonaPorNombre(String nombre, List<Persona> milista){
        List<Persona> listaFiltro = new ArrayList<Persona>();
        for (Persona p:milista){
            if (p.getNombre().equals(nombre)){
                listaFiltro.add(p);
            }
        }
        return listaFiltro;

    }
}
