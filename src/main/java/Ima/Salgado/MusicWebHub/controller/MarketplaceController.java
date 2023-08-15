package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Product;
import Ima.Salgado.MusicWebHub.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketplaceController {

    private final ProductRepository productRepository;

    public MarketplaceController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/marketplace")
    public String listProducts(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "marketplace"; // Thymeleaf template name for listing products in the marketplace
    }
}
