package com.codecool.bookshelf.model.feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Opinion {

    private final long id;
    private final long bookId;
    private final long userId;

    @Getter
    @Setter
    private String value;

    public Opinion(long bookId, long userId, long id) {
        this.bookId = bookId;
        this.userId = userId;
        this.id = id;
    }
}
