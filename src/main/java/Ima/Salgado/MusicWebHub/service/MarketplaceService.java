package Ima.Salgado.MusicWebHub.service;

import Ima.Salgado.MusicWebHub.model.Product;
import Ima.Salgado.MusicWebHub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketplaceService {

    private final ProductRepository productRepository;

    @Autowired
    public MarketplaceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
