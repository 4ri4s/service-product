package academy.digitallab.store.service.product;

import academy.digitallab.store.service.product.domain.Category;
import academy.digitallab.store.service.product.domain.Product;
import academy.digitallab.store.service.product.domain.Status;
import academy.digitallab.store.service.product.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){

        Product product01 = Product.builder()
                .name("Jamon")
                .category(Category.builder().id(1L).name("Embutidos").build())
                .description("Jamon cocido sin sal")
                .status(Status.CREATED)
                .price(Double.parseDouble( "1250.44"))
                .stock(Double.parseDouble("10"))
                .createAt(new Date())
                .build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);

    }

}
