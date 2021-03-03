package cn.wemesh.tacocloud;

public interface IngredientRepo {
    Iterable<Ingredient> findAll();
    Ingredient find(String id);
    Ingredient save(Ingredient ingredient);
}
