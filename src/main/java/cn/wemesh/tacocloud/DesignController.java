package cn.wemesh.tacocloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
               new Ingredient("DEMO1", "我是demo1", Ingredient.Type.WRAP),
                new Ingredient("demo2", "i am demo2", Ingredient.Type.CHEESE),
                new Ingredient("demo3", "i am demo3", Ingredient.Type.PROTEIN),
                new Ingredient("demo4", "i am demo4", Ingredient.Type.VEGGIES),
                new Ingredient("demo5", "i am demo5", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type:types) {
            model.addAttribute(type.toString().toLowerCase(Locale.ROOT),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());
        System.out.println(model);
        return "design";

    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        log.info("process design:" + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
