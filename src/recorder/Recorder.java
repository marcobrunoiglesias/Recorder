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
            
            for (int i=0; i < configuracion.getListaDeCamarasActivas().size(); i++){
                Camara camara = configuracion.getListaDeCamarasActivas().get(i);
                MultiRecorder multiRecorder = new MultiRecorder(camara, configuracion);

                multiRecorder.start();
                System.out.println("Creado hilo para camara "+camara.getNombre());
            }
        }
        catch(ConfiguracionException configuracionException){
            System.out.println("Error "+configuracionException.getMessage());
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
}
