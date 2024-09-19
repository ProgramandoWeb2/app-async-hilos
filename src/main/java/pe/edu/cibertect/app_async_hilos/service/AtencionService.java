package pe.edu.cibertect.app_async_hilos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertect.app_async_hilos.remote.service.PreparacionService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AtencionService {

    private final PreparacionService preparacionService;

    public CompletableFuture<String> prepararHamburguesa(){
        CompletableFuture<String> tarea1 = preparacionService.cortarPan();
        CompletableFuture<String> tarea2 = preparacionService.freirHamburguesa();
        CompletableFuture<String> tarea3 = preparacionService.freirPapas();
        CompletableFuture<String> tarea4 = preparacionService.empaquetarHamburguesa();
        //allOf = unir que todas las tareas terminen correctamente.
        return CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4)
                .thenApply(result ->{
                    //Unir los resultado de todas las tareas unas vez terminadas
                    try{
                        String valorTarea1 = tarea1.join();
                        String valorTarea2 = tarea2.join();
                        String valorTarea3 = tarea3.join();
                        String valorTarea4 = tarea4.join();
                        return "Resultado de tareas: "+
                                valorTarea1+"-"+
                                valorTarea2+"-"+
                                valorTarea3+"-"+
                                valorTarea4;
                    }catch (Exception ex){
                        return "Error al combinar los datos "+ex.getMessage();
                    }
                })
                .exceptionally(ex-> "Error al ejecutar tareas " + ex.getMessage());
    }
}
