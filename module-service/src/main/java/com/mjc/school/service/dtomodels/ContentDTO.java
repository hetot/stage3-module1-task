package com.mjc.school.service.dtomodels;

import java.util.Date;

public record ContentDTO(long id, String title, String content, Date createDate, Date lastUpdatedDate,
                         AuthorDTO author) {
}
