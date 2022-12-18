package com.company.dao.exercise;
import com.company.model.Exercise;
import java.util.List;

public interface ExerciseDAO {
    List<Exercise> list();
    Exercise update(Exercise exercise);
    Exercise findById(Integer id);
    boolean delete(Integer id);
    boolean save(Exercise exercise);
}
