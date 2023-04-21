package org.eclipse.jakarta.hello.domain.core;

import java.math.BigInteger;

public interface IProduct {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    BigInteger getPrice();
    void setPrice(BigInteger price);

    BigInteger getQuantity();
    void setQuantity(BigInteger quantity);


}
