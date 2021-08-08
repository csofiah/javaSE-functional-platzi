package cursos.arquitecturajava.lambdas;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Persona> listPersonas = new ArrayList<>();
        listPersonas.add(new Persona("pedro", "gomez", 30));
        listPersonas.add(new Persona("ana", "sanchez", 40));
        listPersonas.add(new Persona("gema", "blanco", 20));
        listPersonas.add(new Persona("antonio", "perez", 70));

      // listPersonas.sort((p1,p2) -> p1.getNombre().compareTo(p2.getNombre())) ;
     // List<Persona> nueva = buscarPersonConFiltro(new FiltroPersonaImpl( "pedro"), listPersonas );
    //  List<Persona> nueva = buscarPersonConFiltro(new FiltroPersonaApellido("sanchez"), listPersonas);
        // List<Persona> nueva = buscarPersonConFiltro((Persona p)-> p.getApellidos().equals("sanchez"), listPersonas);

        FiltroPersona filtroPedro = new FiltroPersonaNombre("pedro");
        FiltroPersona filtroPerezOrPedro =  filtroPedro.or(new FiltroPersonaApellido("perez"));
        List<Persona> nueva = buscarPersonConFiltro(filtroPerezOrPedro, listPersonas);

        //metodo de referencia
        //List<Persona> nueva = buscarPersonConFiltro(Persona::estaJubilado, listPersonas);


        for (Persona p: nueva){
            System.out.printf("persona: %s %s %s %n", p.getNombre(), p.getApellidos(), p.getEdad());
        }
    }

    public static List<Persona> buscarPersonConFiltro(FiltroPersona filtro, List<Persona> milista){
        List<Persona> listaFiltro = new ArrayList<Persona>();

        for (Persona p:milista){
            if (filtro.test(p)){
                listaFiltro.add(p);
            }
        }
        return listaFiltro;

    }
}
