/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorder;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author marco
 */
public class Fecha {
    private Calendar calendar;

    public Fecha() {
        this.calendar = GregorianCalendar.getInstance();
    }
    
    /**
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
     * @return 
     */
    
    public String getSoloFechaFormatAAAAMMDD(){
        int anio = this.calendar.get(Calendar.YEAR);
        int mes = this.calendar.get(Calendar.MONTH);
        int dia = this.calendar.get(Calendar.DAY_OF_MONTH);
        int hora = this.calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = this.calendar.get(Calendar.MINUTE);
        int segundo = this.calendar.get(Calendar.SECOND);
        return String.format("%04d-%02d-%02d_%02d:%02d:%02d", anio, mes, dia, hora, minuto, segundo);
    }
    
}
