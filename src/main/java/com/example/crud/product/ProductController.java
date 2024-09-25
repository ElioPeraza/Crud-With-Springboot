package com.example.crud.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//controllador para gestionar productos en la API la variable instancia de la clase ProductRepository
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductRepository productRepository;

    // inyecta la dependencia de productrepository al constructor del controlador
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //  Metodo para manejar productos , recibir y manejar peticiones HTTP
    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    // metodo para crear un nuevo producto, recibe un JSON con los datos del producto y lo guarda en la base de datos
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);

    }
    // Metodo para actualizar un producto, recibe un JSON con los datos del producto y actualiza el producto en la base de datos
    @PutMapping("/{id}")
    public void updateProduct( @PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);

    }
    // Metodo para eliminar un producto, recibe el id del producto y lo elimina de la base de datos  (DELETE)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
