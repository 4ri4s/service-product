package academy.digitallab.store.service.product.service.impl;

import academy.digitallab.store.service.product.domain.Category;
import academy.digitallab.store.service.product.domain.Product;
import academy.digitallab.store.service.product.domain.Status;
import academy.digitallab.store.service.product.repository.IProductRepository;
import academy.digitallab.store.service.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus(Status.CREATED);
        product.setCreateAt(new Date());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        if(null == productDB){
            return null;
        }
        productDB.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct(id);
        if(null == productDB){
            return null;
        }
        productDB.setStatus(Status.DELETED);
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB = getProduct(id);
        if(null == productDB){
            return null;
        }
        productDB.setStock(productDB.getStock() + quantity);
        productDB.setStatus(Status.UPDATED);
        return productRepository.save(productDB);
    }
}
