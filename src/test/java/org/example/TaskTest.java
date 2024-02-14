package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldMatchSimpleTaskByTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchSimpleTaskByTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Купить продукты");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertTrue(epic.matches("Молоко"));
    }

    @Test
    public void shouldNotMatchEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertFalse(epic.matches("Кофе"));
    }

    @Test
    public void testEquals() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        // Проверка на равенство двух объектов с одинаковыми id
        Assertions.assertTrue(task1.equals(task2));
        Assertions.assertTrue(task2.equals(task1));

        // Проверка на неравенство двух объектов с разными id
        Assertions.assertFalse(task1.equals(task3));
        Assertions.assertFalse(task3.equals(task1));

        // Проверка, что объект равен самому себе
        Assertions.assertTrue(task1.equals(task1));

        // Проверка, что объект не равен null
        Assertions.assertFalse(task1.equals(null));

        // Проверка, что объект не равен объекту другого класса
        Assertions.assertFalse(task1.equals("some string"));
    }

    @Test
    public void testHashCode() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);

        // Проверка, что hashCode одинаков для двух объектов с одинаковыми id
        Assertions.assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testMatches() {
        Task task = new Task(1);

        // Проверка, что метод matches всегда возвращает false
        Assertions.assertFalse(task.matches("some query"));
    }
}

