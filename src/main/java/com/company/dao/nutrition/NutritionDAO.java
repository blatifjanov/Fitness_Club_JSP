package com.company.dao.nutrition;
import com.company.model.Nutrition;
import java.util.List;

public interface NutritionDAO {
    List<Nutrition> list();
    Nutrition update(Nutrition nutrition);
    Nutrition findById(Integer id);
    boolean delete(Integer id);
    boolean save(Nutrition nutrition);
}
