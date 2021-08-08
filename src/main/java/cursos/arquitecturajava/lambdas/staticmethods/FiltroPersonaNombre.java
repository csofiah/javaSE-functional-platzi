package cursos.arquitecturajava.lambdas.staticmethods;

import cursos.arquitecturajava.lambdas.FiltroPersona;
import cursos.arquitecturajava.lambdas.Persona;

public class FiltroPersonaNombre implements FiltroPersona {
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
