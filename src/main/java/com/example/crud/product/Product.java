package com.example.crud.product;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Indicamos que esta clase es una entidad que se va a persistir en la base de datos
@Table (name = "PRODUCT")
public class Product {
    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// gererara el id de forma automática incrementable
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "ANTIGUEDAD")  // Añadimos esta columna para calcular la antigüedad del producto
    private  int antiguedad;


    public Product() {
    }

    public Product(Long id, String name, float price, LocalDate fecha, int antiguedad) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fecha = fecha;
        this.antiguedad = antiguedad;
    }

    public Product(String name, float price, LocalDate fecha, int antiguedad) {
        this.name = name;
        this.price = price;
        this.fecha = fecha;
        this.antiguedad = antiguedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
