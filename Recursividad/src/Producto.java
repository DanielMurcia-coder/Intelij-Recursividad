public class Producto {
    String descripcion,nombre,code;
    double precio;

    public Producto(String descripcion,double precio,String nombre) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "Descripción: " + descripcion + "\nPrecio: " + precio + "\nNombre: " + nombre;
    }
}
