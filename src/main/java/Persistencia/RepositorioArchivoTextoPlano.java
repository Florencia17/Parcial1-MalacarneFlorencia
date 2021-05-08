package Persistencia;

import Modelo.RepositorioVentas;
import Modelo.Venta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioArchivoTextoPlano implements RepositorioVentas {

    private final File file;

    public RepositorioArchivoTextoPlano(String file) {
        this.file = new File(file);
    }

    @Override
    public List<Venta> recuperarListaVentas() {
        List<Venta> ventas= new ArrayList<>() ;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String empleado : reader.lines().collect(Collectors.toList())){
                String [] partesEmpleados = empleado.split(", ");
                Venta v = new Venta(partesEmpleados[0], partesEmpleados[1], partesEmpleados[2]);
                ventas.add(v);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ventas;
    }
    }

