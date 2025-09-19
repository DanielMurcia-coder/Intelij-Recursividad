import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String direccion;
    ArrayList<Categoria> categorias = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();

    public Empresa(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;

    }

    public ArrayList<Producto> getProductosRango(double precio) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        // Recorrer todas las categorías de la empresa
        for (Categoria categoria : categorias) {
            if (categoria != null) {
                productosEncontrados.addAll(categoria.obtenerProductosPrecio(precio));
            }
            System.out.println(categoria.getProductos().toString());
        }

        return productosEncontrados;
    }

    public void añadirCategoria(Categoria categoria,ArrayList<Producto> productos) {
        if (productos != null) {
            Categoria categoria1=new Categoria(productos);
            if (categoria != null) {
                this.categorias.add(categoria1);
            }
        }
    }

    // Método adicional útil
    public void mostrarCategorias() {
        System.out.println("Categorías en " + nombre + ":");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " +
                    (categorias.get(i) != null ? "Categoría válida" : "NULL"));
        }
    }
}