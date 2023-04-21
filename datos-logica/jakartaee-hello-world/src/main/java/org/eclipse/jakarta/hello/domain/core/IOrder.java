package org.eclipse.jakarta.hello.domain.core;

import java.math.BigDecimal;

public interface IOrder {
    Long getId();
    void setId(Long id);
    Long getUserId();
    void setUserId(Long userId);
    Long getProductId();
    void setProductId(Long productId);
    BigDecimal getQuantity();
    void setQuantity(BigDecimal quantity);
    Boolean getPaid();
    void setPaid(Boolean paid);
}
