package Modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class NaftaSuper extends Nafta{

    public NaftaSuper(String nombre, int precio, int litros){
        super (nombre, precio, litros);
    }

    private boolean esDomingo (LocalDateTime dia){
        return (dia.getDayOfWeek().equals(DayOfWeek.SUNDAY));
    }

    private boolean esSabado (LocalDateTime dia){
        return (dia.getDayOfWeek().equals(DayOfWeek.SATURDAY));
    }

    @Override
    public double calcularCosto(int litros, LocalDateTime dia) {

        double costo = litros*90;
        if(esDomingo(dia)){
            costo-= costo*0.10;
        }
        if(litros>= 20 && esSabado(dia)){
            costo-= costo*0.12;
        }
        return costo;
    }
}
