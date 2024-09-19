package pe.edu.cibertect.app_async_hilos.remote.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PreparacionService {

    @Async
    public CompletableFuture<String> cortarPan(){
        try{
            log.info("Cortando el pan para la hamburguesa");
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Pan cortado, terminado.");
    }

    @Async
    public CompletableFuture<String> freirHamburguesa(){
        try{
            log.info("Empezando a freir hamburguesa");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Hamburguesa frita, terminado");
    }


    @Async
    public CompletableFuture<String> freirPapas(){
        try{
            log.info("Empezando a freir papas");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Papas fritas, terminado");
    }

    @Async
    public CompletableFuture<String> empaquetarHamburguesa(){
        try{
            log.info("Empezando empaquetado");
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Empaquetado, terminado");
    }


}
