package academy.digitallab.store.service.product.repository;

import academy.digitallab.store.service.product.domain.Category;
import academy.digitallab.store.service.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);

}
