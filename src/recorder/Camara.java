/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorder;

/**
 *
 * @author marco
 */
public class Camara {
    private String URL;
    private String nombre;
    private String directorioLocalDeDrive;

    public Camara(String URL, String nombre) {
        this.URL = URL;
        this.nombre = nombre;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorioLocalDeDrive() {
        return directorioLocalDeDrive;
    }

    public void setDirectorioLocalDeDrive(String directorioLocalDeDrive) {
        this.directorioLocalDeDrive = directorioLocalDeDrive;
    }
    
    
  
}
