package academy.digitallab.store.service.product.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    NotInStock,
    Discontinued,
    WillBeAvailableSoon,
    Available,
    Created
}
