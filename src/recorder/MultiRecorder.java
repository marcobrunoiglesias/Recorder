/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author marco
 */
public class MultiRecorder extends Thread {
   private Camara camara; 
   private Configuracion configuracion;
   private URL urlCamara;

    public MultiRecorder(Camara camara, Configuracion configuracion) {
        this.camara = camara;
        this.configuracion = configuracion;
        try{
            this.urlCamara = new URL(camara.getURL());
        }
        catch(MalformedURLException malformedURLException){
            System.out.println("No se pudo armar la URL para la camara "+camara.getNombre()+". Error: "+malformedURLException.getMessage());
        }
    }
   
   @Override
    public void run() {
        try{
        while (true){
                try{
                    InputStream is = urlCamara.openStream();
                    if (is!=null){
                        BufferedImage imagenAGrabar = ImageIO.read(is);
                        String nombreArchivo = generarNombreArchivo(configuracion, camara);

                        File outputfile = new File(nombreArchivo);
                        ImageIO.write(imagenAGrabar, this.configuracion.EXTENSION, outputfile);

                        imagenAGrabar.flush();
                        System.out.println(String.format("Grabada: %s", nombreArchivo));
                        nombreArchivo = null;
                    }
                    else{
                        System.out.println("No se puede leer la camara");
                    }
                }
                catch(Exception e){
                    System.out.println("Error desconocido: "+e.getMessage());
                }
            
                Thread.sleep(configuracion.getSegundosDePausa());
            }
        }
        catch(Exception exceptionAlHacerLaPausa){
            System.out.println("No se pudo hacer la pausa: "+exceptionAlHacerLaPausa.getMessage());
        }
        
    }
    
    private String generarNombreArchivo(Configuracion configuracion, Camara camara){
        Fecha fecha = new Fecha();
        
        return String.format("%s%s/%s.%s", configuracion.getDirectorioArchivos(), camara.getDirectorioLocalDeDrive(), fecha.getSoloFechaFormatAAAAMMDD(), this.configuracion.EXTENSION);
    }
    
}
