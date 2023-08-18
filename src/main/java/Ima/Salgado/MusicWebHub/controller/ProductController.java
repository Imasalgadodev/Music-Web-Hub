package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Product;
import Ima.Salgado.MusicWebHub.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final Validations validation;

    public ProductController(ProductRepository productRepository, Validations validation) {
        this.productRepository = productRepository;
        this.validation = validation;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "list_products"; // Thymeleaf template name for listing products in the marketplace
    }
}
