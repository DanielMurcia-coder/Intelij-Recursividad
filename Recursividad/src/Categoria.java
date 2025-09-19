import java.util.ArrayList;

public class Categoria {
    ArrayList<Categoria> subCategorias = new ArrayList<>();
    ArrayList<Producto> productos;

    public Categoria(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Categoria> getSubCategorias() {
        return subCategorias;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> obtenerProductosPrecio(double precio) {
        ArrayList<Producto> productosRango = new ArrayList<>();

        // Productos de esta categoría
        for (Producto producto : productos) {
            if (producto != null && Math.abs(producto.getPrecio() - precio) < 0.001) {
                productosRango.add(producto); // ✅ CORREGIDO: add en lugar de addAll
            }
        }

        // Productos de subcategorías (recursivo)
        for (Categoria categoria : subCategorias) {
            if (categoria != null) {
                productosRango.addAll(categoria.obtenerProductosPrecio(precio));
            }
        }

        return productosRango;
    }

    // Método adicional para añadir subcategorías
    public void añadirSubCategoria(Categoria subCategoria) {
        if (subCategoria != null) {
            subCategorias.add(subCategoria);
        }
    }

    public String toString(int nivel) {
        StringBuilder sb = new StringBuilder();
        String indent = "  ".repeat(nivel);

        // nombre de la categoría
        sb.append(indent).append("Categoria\n");

        // productos
        if (productos != null) {
            for (Producto p : productos) {
                sb.append(indent).append("  - ").append(p.getNombre()).append("\n");
            }
        }

        // subcategorías
        for (Categoria sub : subCategorias) {
            sb.append(sub.toString(nivel + 1));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public void imprimirProductos(ArrayList<Producto> productos) {
        String mensaje="";
        for (Producto producto : productos) {
            mensaje+= producto.toString()+"\n";
        }
        System.out.println(mensaje);
    }

}

