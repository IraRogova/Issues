package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager (IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue item) {
        repository.add(item);
    }

    public void remove(Issue item) {
        repository.remove(item);
    }

    public List<Issue> getAll() {
        return repository.getAll();
    }

    public boolean addAll(List<Issue> items) {
        return repository.addAll(items);
    }

    public List<Issue> filterByAuthor(String author) {
        Predicate<String> byAuthor = Predicate.isEqual(author);

        List<Issue> issues = new ArrayList<>();

        for (Issue item : repository.getAll())
            if (byAuthor.test(item.getAuthor())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> filterByLabel(String label) {
        Predicate<String> ByLabel = Predicate.isEqual(label);

        List<Issue> issues = new ArrayList<>();

        for (Issue item : repository.getAll())
            if (ByLabel.test(item.getLabel())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> filterByAssignee(String assignee) {
        Predicate<String> byAssignee = Predicate.isEqual(assignee);

        List<Issue> issues = new ArrayList<>();

        for (Issue item : repository.getAll())
            if (byAssignee.test(item.getAssignee())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> sort() {

        List<Issue> issues = new ArrayList<>(repository.getAll());

        Collections.sort(issues);
        return issues;
    }
}
