package cn.wemesh.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class IngredientRepoJdbc implements IngredientRepo {
    private JdbcTemplate jdbc;
    @Autowired
    public IngredientRepoJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int i) {
        throw SQLException {
            return new Ingredient(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    Ingredient.Type.valueOf(resultSet.getString("typ"))
            );
        }
    }

    @Override
    public Ingredient find(String id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
