/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorder;

import java.util.LinkedList;
import java.util.List;
import utiles.ConfiguracionException;

/**
 *
 * @author marco
 */
public class Configuracion {
    private List<Camara> listaDeCamaras;
    private String directorioArchivos = null;
    private int segundosDePausa = 15000;
    public final String EXTENSION = "jpg";

    public Configuracion() throws ConfiguracionException{
//        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson("local.properties"); //{"inner1":{"inner2":{"aStringProp":"aStringValue","inner3":{"i2":100,"i1":1}},"aBoolProp":true},"size":1,"count":1000000}
//
//        //following line throws error: Expected a string but was BEGIN_OBJECT at line 1 column 12 path $.
//        this.propObj = gson.fromJson(json, Properties.class); 

//        JsonObject obj = new JsonObject();
//        obj.
//        String pageName = obj.getJSONObject("pageInfo").getString("pageName");
//
//        JSONArray arr = obj.getJSONArray("posts");
//        for (int i = 0; i < arr.length(); i++)
//        {
//            String post_id = arr.getJSONObject(i).getString("post_id");
//            ......
//        }
    }
    
    
    
    
    public  List<Camara> getListaDeCamarasActivas() throws ConfiguracionException{
        if (this.listaDeCamaras== null){
            this.listaDeCamaras = new LinkedList<>();
            
            Camara camara = new Camara("http://192.168.0.113/axis-cgi/jpg/image.cgi?resolution=704x576", "Camara_Comed");
            camara.setDirectorioLocalDeDrive("1V0N3JH18T1BuPc5Z67yiycU-zA-55dtB");
//            camara.setDirectorioLocalDeDrive("/Camara_Comed");
            this.listaDeCamaras.add(camara);
            
            camara = new Camara("http://192.168.0.114/axis-cgi/jpg/image.cgi?resolution=704x576", "Camara_Patio");
            camara.setDirectorioLocalDeDrive("1skGXLZP9IVDOgKN5aHghV_lV5xyyl5tI");
//            camara.setDirectorioLocalDeDrive("/Camara_Patio");
            this.listaDeCamaras.add(camara);
        }
            
       return this.listaDeCamaras;     
    }
    
    public String getDirectorioArchivos(){
        if (this.directorioArchivos  == null){
            this.directorioArchivos = "/run/user/1000/gvfs/google-drive:host=gmail.com,user=iglesiascaballada/";
//            this.directorioArchivos = "/home/marco/Escritorio/imagenes";
        }
        return this.directorioArchivos;
    } 

    public int getSegundosDePausa() {
        return segundosDePausa;
    }

    public void setSegundosDePausa(int segundosDePausa) {
        this.segundosDePausa = segundosDePausa;
    }
    
    
}
