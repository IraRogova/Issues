package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);
    private Issue issue1 = new Issue(1, true, "", 8, "qwe1", "red", "teacher1");
    private Issue issue2 = new Issue(2, false, "", 5, "das2", "green", "teacher2");
    private Issue issue3 = new Issue(3, true, "", 8, "ter3", "red, green", "teacher3");
    private Issue issue4 = new Issue(4, false, "", 7, "ter3", "black", "teacher3");
    private Issue issue5 = new Issue(5, true, "", 12, "was5", "white", "teacher");

    @BeforeEach
    void SetUp() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> expected = new ArrayList<>(List.of(issue3,issue4));
        List<Issue> actual = manager.filterByAuthor("ter3");

        assertEquals(expected, actual);
    }



    @Test
    void shouldFilterByAssignee() {
        List<Issue> expected = new ArrayList<>(List.of(issue3,issue4));
        List<Issue> actual = manager.filterByAssignee("teacher3");

        assertEquals(expected, actual);
    }

    @Test
    void shouldSort() {
        List<Issue> expected = new ArrayList<>(List.of(issue2,issue4,issue1,issue3,issue5));
        List<Issue> actual = manager.sort();

        assertEquals(expected, actual);
    }

}