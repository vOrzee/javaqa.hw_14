package ru.netology.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleTask extends Task {
    private final String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    @Override
    public boolean matches(String query) {
        return title.contains(query);
    }
}


