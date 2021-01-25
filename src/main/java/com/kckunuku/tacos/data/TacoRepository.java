package com.kckunuku.tacos.data;

import com.kckunuku.tacos.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
