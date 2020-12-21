package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Issue implements Comparable<Issue> {
    private int id;
    private boolean isClosed;
    private String name;
    private int OpenDaysAgo;
    private String author;
    private String label;
    private String assignee;



    @Override
    public int compareTo(Issue o) {
        return OpenDaysAgo - o.OpenDaysAgo;
    }
}
