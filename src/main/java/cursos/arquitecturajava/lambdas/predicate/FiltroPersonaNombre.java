package cursos.arquitecturajava.lambdas.predicate;

import cursos.arquitecturajava.lambdas.Persona;
import cursos.arquitecturajava.lambdas.genericos.Filtro;

import java.util.function.Predicate;

public class FiltroPersonaNombre implements Predicate<Persona> {
   private String nombre;

    public FiltroPersonaNombre(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public boolean test(Persona persona) {
        if(persona.getNombre().equals(nombre)){
            return true;
        }else{
            return false;
        }

    }
}
