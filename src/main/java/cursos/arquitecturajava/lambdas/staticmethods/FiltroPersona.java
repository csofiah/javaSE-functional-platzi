package cursos.arquitecturajava.lambdas.staticmethods;

import cursos.arquitecturajava.lambdas.Persona;

import java.util.function.Predicate;

public interface FiltroPersona extends Predicate<Persona> {

    //var args la posibilidad de pasar multiples parametros del mismo tipo
    public static Predicate<Persona> orMultiple(Predicate<Persona> ...predicados){

        Predicate<Persona> combinarPredicados = predicados[0];
        for (Predicate<Persona> predicado:predicados){
            combinarPredicados= combinarPredicados.or(predicado);
        }
        return combinarPredicados;
    }
}
