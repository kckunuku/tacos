package com.kckunuku.tacos.web;

import com.kckunuku.tacos.data.IngredientRepository;
import com.kckunuku.tacos.data.TacoRepository;
import com.kckunuku.tacos.domain.Ingredient;
import com.kckunuku.tacos.domain.Order;
import com.kckunuku.tacos.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
@ComponentScan(basePackages = "com.kckunuku.tacos.data")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.designRepo = tacoRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        log.info(ingredients.toString());
        Ingredient.Type[] types = Ingredient.Type.values();
        for( Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
//        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                            .filter(x -> x.getType().equals(type))
                            .collect(Collectors.toList());
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @PostMapping
    public String tacoDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        if(errors.hasErrors()){
            return "design";
        }
//        save the taco design
        Taco saved = designRepo.save(design);
        order.addDesign(saved);
        log.info("Processing design : "+ design);
        return "redirect:/orders/current";
    }
}
