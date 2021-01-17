package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    //ejemplo de consumer puede ser recibir una lista de archivos
    //e irlos borrando sin devolver otro dato
    static void showHelp(CLIArguments cliArguments) {
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };

        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI(){
            Supplier<CLIArguments> generator = () -> new CLIArguments();
            return generator.get();

    }



}
