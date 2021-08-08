package cursos.arquitecturajava.lambdas.staticmethods;

import cursos.arquitecturajava.lambdas.FiltroPersona;
import cursos.arquitecturajava.lambdas.Persona;

public class FiltroPersonaApellido implements FiltroPersona {
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
