package com.ddtp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostRequest {

    private String blogPostTitle;

    private String blogPostBody;

    private String approval;

    private LocalDateTime approvalAt;

    private String approvalBy;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updateAt;

    private String updateBy;

}
