package the_spring_src.Controll;

import org.springframework.http.ResponseEntity;
import the_spring_src.Domains.Product;
import the_spring_src.Domains.ProductType;
import the_spring_src.Reposies.ProductRepo;
import the_spring_src.FactoryPattern.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import the_spring_src.RequestStuff.ProductRequest;

@Getter
@Setter
@NoArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController implements Controller<Product> {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    public List<Product> getStuff() {
        return productRepo.findAll();
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    @PostMapping
    public void create(@RequestBody ProductRequest request) {
        String name = request.getName();
        Float price = request.getPrice();
        ProductType type = request.getType();
        Integer stoc = request.getStoc();
        Product p = ProductFactory.getInstance().make_prod(name, price, type, stoc);
        productRepo.save(p);
        //productRepo.add_to_repo(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ProductRequest request) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            productRepo.delete(existingProduct);

            existingProduct.setName(request.getName());
            existingProduct.setPrice(request.getPrice());
            existingProduct.setType(request.getType());
            existingProduct.setStoc(request.getStoc());

            productRepo.save(existingProduct);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> find_by_id(@PathVariable int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Product prod = find_by_id(id).getBody();
        if (prod != null) {
            //productRepo.remove_from_repo(prod);
            productRepo.delete(prod);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@GetMapping("/{type}")
    public ArrayList<Product> filterProductsByType(@PathVariable String type) throws SQLException {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        ArrayList<Product> products = (ArrayList<Product>) getStuff();
        ProductType tiup = ProductType.valueOf(type);
        for (Product product : products) {
            if (product.getType() == tiup) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @DeleteMapping
    public void deleteAall(){
        productRepo.deleteAll();
    }

}
