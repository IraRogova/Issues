package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Issue issue1 = new Issue(1, true, "", 8, "", "", "");
    private Issue issue2 = new Issue(2, false, "", 5, "", "", "");
    private Issue issue3 = new Issue(3, true, "", 8, "", "", "");
    private Issue issue4 = new Issue(4, false, "", 7, "", "", "");
    private Issue issue5 = new Issue(5, true, "", 12, "", "", "");

    @BeforeEach
    void SetUp() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
    }

    @Test
    void shouldFindAllCloseIssue() {
        List<Issue> expected = List.of(issue1, issue3, issue5);
        List<Issue> actual = repository.findAllCloseIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAllOpenIssue() {
        List<Issue> expected = List.of(issue2, issue4);
        List<Issue> actual = repository.findAllOpenIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCloseIssueById() {
        repository.closeIssueById(4);

        List<Issue> expected = List.of(issue1, issue3, issue4, issue5);
        List<Issue> actual = repository.findAllCloseIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCloseIssueByIdInvalid() {
        repository.closeIssueById(6);

        List<Issue> expected = List.of(issue1, issue3, issue5);
        List<Issue> actual = repository.findAllCloseIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCloseIssueBySame() {
        repository.closeIssueById(5);

        List<Issue> expected = List.of(issue1, issue3, issue5);
        List<Issue> actual = repository.findAllCloseIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIssueById() {
        repository.openIssueById(5);

        List<Issue> expected = List.of(issue2, issue4, issue5);
        List<Issue> actual = repository.findAllOpenIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIssueByIdInvalid() {
        repository.openIssueById(6);

        List<Issue> expected = List.of(issue2, issue4);
        List<Issue> actual = repository.findAllOpenIssue();

        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIssueByIdSame() {
        repository.openIssueById(2);

        List<Issue> expected = List.of(issue2, issue4);
        List<Issue> actual = repository.findAllOpenIssue();

        assertEquals(expected, actual);
    }

}