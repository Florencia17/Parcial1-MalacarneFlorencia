package Modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NaftaComun extends Nafta{

    public NaftaComun (String nombre, int precio, int litros){
        super(nombre, precio, litros);
    }


    @Override
    public double calcularCosto(int litros, LocalDateTime dia) {
        double costo = litros * 70;
    if(dia.getHour()>= 8 && dia.getHour() <= 10) {
        costo -= costo * 0.15;}
    return costo;
    }



    }

