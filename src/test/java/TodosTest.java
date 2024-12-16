import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tasks.Epic;
import ru.netology.tasks.Meeting;
import ru.netology.tasks.SimpleTask;
import ru.netology.tasks.Task;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    SimpleTask simpleTask;
    Epic  epic;
    Meeting meeting;
    Todos todos;

    @BeforeEach
    void setUp() {
        simpleTask = new SimpleTask(5, "Позвонить друзьям, сказать зайти в НетоБанк");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        epic = new Epic(55, subtasks);

        meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        todos = new Todos();
    }

    @Test
    public void shouldAddDifferentTasks() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInSimpleTask() {
        todos.add(simpleTask);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("друзьям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInEpic() {
        todos.add(epic);
        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInMeeting() {
        todos.add(meeting);
        Task[] expected = {meeting};
        Task[] actual = todos.search("приложения");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArray() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("Пицца");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindManyTasks() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("НетоБанк");

        Assertions.assertArrayEquals(expected, actual);
    }
}