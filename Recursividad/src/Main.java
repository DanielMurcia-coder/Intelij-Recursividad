import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("desc", 1000, "Gaseosa");
        Producto p2 = new Producto("desc", 100, "Agua");
        Producto p3 = new Producto("desc", 10000, "Vino");
        Producto p4 = new Producto("desc", 5000, "Cerveza");
        Producto p5 = new Producto("desc", 200, "Jugo");

        // Subcategorías
        Categoria bebidasFrias = new Categoria(new ArrayList<>(List.of(p1, p2, p5)));
        Categoria bebidasAlcoholicas = new Categoria(new ArrayList<>(List.of(p3, p4)));

        // Categoría raíz
        Categoria bebidas = new Categoria(new ArrayList<>());
        bebidas.añadirSubCategoria(bebidasFrias);
        bebidas.añadirSubCategoria(bebidasAlcoholicas);

        // Probar impresión
        System.out.println("=== Estructura ===");
        System.out.println(bebidas);

        // Buscar productos con precio exacto
        System.out.println("=== Productos con precio 1000 ===");
        bebidas.imprimirProductos(bebidas.obtenerProductosPrecio(10000));
    }

}