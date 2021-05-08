import Modelo.RepositorioVentas;
import Persistencia.RepositorioArchivoTextoPlano;

public class Main {

    public static void main(String[] args) {
        new RepositorioArchivoTextoPlano("D:\\Escritorio\\archivoventas.txt").recuperarListaVentas();

    }

}
