package cursos.arquitecturajava.lambdas.predicate;

import cursos.arquitecturajava.lambdas.Persona;
import cursos.arquitecturajava.lambdas.genericos.Filtro;

import java.util.function.Predicate;

public class FiltroPersonaApellido implements Predicate<Persona> {
    private String apellido;

    public FiltroPersonaApellido(String apellido) {
        super();
        this.apellido = apellido;
    }

    @Override
    public boolean test(Persona persona) {
        if(persona.getApellidos().equals(apellido)){
            return true;
        }else{
            return false;
        }

    }
}
