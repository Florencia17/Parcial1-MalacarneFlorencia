package Modelo;

import java.time.LocalDateTime;

public class Venta {
    private LocalDateTime fecha;
    private int litros; //cambiar a double
    private Nafta nafta;
    private String fechaa, litross, naftaa;

    public Venta(LocalDateTime fecha, int litros, Nafta nafta) {
        this.fecha = fecha;
        this.litros = litros;
        this.nafta = nafta;
    }

    public Venta(String fecha, String litros, String nafta){
        this.fechaa= fecha;
        this.litross= litros;
        this.naftaa = litros;
    }

    public double obtenerCosto() {
        return this.nafta.calcularCosto(litros, fecha);
    }

    public int getLitros() {
        return litros;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Nafta getNafta() {
        return nafta;
    }
}