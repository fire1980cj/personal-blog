package com.blog.personalblog.config.page;

import lombok.Data;
import java.util.List;

@Data
public class PageResult {

    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private List<?> result;
}
