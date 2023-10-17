package com.eleos.app.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// PaginationResponse.java
public class PaginationResponse<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;

    // Getters and setters
}

