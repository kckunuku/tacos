package com.kckunuku.tacos.data;

import com.kckunuku.tacos.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
