package com.kckunuku.tacos.data;

import com.kckunuku.tacos.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
