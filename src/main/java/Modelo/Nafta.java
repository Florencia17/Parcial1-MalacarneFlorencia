package Modelo;

import java.time.LocalDateTime;

public abstract class Nafta {

    private final String nombre;
    private final int precio;
    private final int litros;

    public Nafta(String nombre, int precio, int litros){
        this.nombre= nombre;
        this.precio = precio;
        this.litros= litros;
    }

    public abstract double calcularCosto (int litros, LocalDateTime dia);

}
