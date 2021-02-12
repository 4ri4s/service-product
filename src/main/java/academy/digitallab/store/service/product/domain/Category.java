package academy.digitallab.store.service.product.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categories")
@Data
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
