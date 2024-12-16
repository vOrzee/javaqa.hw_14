package ru.netology.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Meeting extends Task {
    private final String topic;
    private final String project;
    private final String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    @Override
    public boolean matches(String query) {
        return topic.contains(query) || project.contains(query);
    }
}

