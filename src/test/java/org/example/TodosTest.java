package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskByTopic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskByProject() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям во вторник");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("вторник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchMultipleTasksMatch() {
        Todos todos = new Todos();
        Task task1 = new SimpleTask(1, "Task 1");
        Task task2 = new SimpleTask(2, "Task 2");
        Task task3 = new SimpleTask(3, "Task 3");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Task");

        Assertions.assertEquals(3, result.length);
        Assertions.assertTrue(result[0].getId() == 1);
        Assertions.assertTrue(result[1].getId() == 2);
        Assertions.assertTrue(result[2].getId() == 3);
    }

    @Test
    public void testSearchOneTaskMatches() {
        Todos todos = new Todos();
        Task task1 = new SimpleTask(1, "Task 1");
        Task task2 = new SimpleTask(2, "Task 2");
        Task task3 = new SimpleTask(3, "Task 3");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Task 2");

        Assertions.assertEquals(1, result.length);
        Assertions.assertTrue(result[0].getId() == 2);
    }

    @Test
    public void testSearchNoTasksMatch() {
        Todos todos = new Todos();
        Task task1 = new SimpleTask(1, "Task 1");
        Task task2 = new SimpleTask(2, "Task 2");
        Task task3 = new SimpleTask(3, "Task 3");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Task 4");

        Assertions.assertEquals(0, result.length);
    }
}

