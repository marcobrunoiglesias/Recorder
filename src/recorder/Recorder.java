/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import utiles.ConfiguracionException;


/**
 *
 * @author marco
 */
public class Recorder {
    private final static String EXTENSION = "jpg";
    //private Configuracion configuracion;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Configuracion configuracion = new Configuracion();
            
            while (true){
                for (int i=0; i < configuracion.getListaDeCamarasActivas().size(); i++){
                    try{
                        Camara camara = configuracion.getListaDeCamarasActivas().get(i);
                        URL urlCamara = new URL(camara.getURL());
                        
                        BufferedImage imagenAGrabar = ImageIO.read(urlCamara);

                        String nombreArchivo = generarNombreArchivo(configuracion, camara);

                        File outputfile = new File(nombreArchivo);
                        ImageIO.write(imagenAGrabar, EXTENSION, outputfile);
                        
                        System.out.println(String.format("Grabada: %s", nombreArchivo));
                        
                        imagenAGrabar.flush();
                        camara = null;
                        urlCamara = null;
                        nombreArchivo = null;
                    }
                    catch(ConfiguracionException configuracionException){
                        System.out.println("Error recuperando camara: "+configuracionException.getMessage());
                    }
                    catch(NullPointerException nullPointerException){
                        System.out.println("Error obteniendo link de la camara: "+nullPointerException.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Error desconocido: "+e.getMessage());
                    }
                }
                Thread.sleep(configuracion.getSegundosDePausa());
            }
        }
        catch(ConfiguracionException configuracionException){
            System.out.println("Error "+configuracionException.getMessage());
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
        
    private static String generarNombreArchivo(Configuracion configuracion, Camara camara){
        Fecha fecha = new Fecha();
        
        return String.format("%s%s/%s.%s", configuracion.getDirectorioArchivos(), camara.getDirectorioLocalDeDrive(), fecha.getSoloFechaFormatAAAAMMDD(), EXTENSION);
    }
    
}
