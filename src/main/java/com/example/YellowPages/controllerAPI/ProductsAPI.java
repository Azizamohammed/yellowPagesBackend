package com.example.YellowPages.controllerAPI;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.YellowPages.model.Product;
import com.example.YellowPages.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductsAPI{
        public final ProductService productService;

    public ProductsAPI(ProductService productService){
        this.productService  = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getProduct(){
        try{
            List<Product> products  = productService.getAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }    
    }


    @GetMapping("ById{proId}")

    public ResponseEntity<?> getByID(@PathVariable int proId){
        try{
            Optional<Product> optionalProduct  = productService.getById(proId);
            return new ResponseEntity<>(optionalProduct,HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }




    @DeleteMapping("/delete{proId}")
    public ResponseEntity<?> delete(@PathVariable Integer proId){
        try{
            productService.deleteById(proId);
            return new ResponseEntity<>("delete",HttpStatus.OK);

        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct (@RequestBody Product product){
        try{
            Product product2 = productService.addProduct(product);
            return new ResponseEntity<>("inserted",HttpStatus.OK);

    }catch(Exception exception){
        return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}

    


@PutMapping("/editById/{proId}")
public ResponseEntity<?> editProduct(@PathVariable int proId, @RequestBody Product product) {
    try {
        Optional<Product> existingProduct = productService.getById(proId);

        if (existingProduct.isPresent()) {
            // Update the existing product with the new data
            Product updatedProduct = existingProduct.get();
            updatedProduct.setProductName(product.getProductName()); // Update other fields as needed
            // Save the updated product in the database
            productService.save(updatedProduct);

            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            // Product not found
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    } catch (Exception exception) {
        // Handle any other exceptions
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}