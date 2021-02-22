package academy.digitallab.store.service.product;

import academy.digitallab.store.service.product.domain.Category;
import academy.digitallab.store.service.product.domain.Product;
import academy.digitallab.store.service.product.repository.IProductRepository;
import academy.digitallab.store.service.product.service.IProductService;
import academy.digitallab.store.service.product.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private IProductRepository productRepository;

    private IProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);

        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble( "12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer))
                .thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        System.out.println("1 si es aca");
        System.out.println(found);
        Assertions.assertTrue(found.getName().equals("computer"));
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertTrue(newStock.getStock()==13);
    }

}
