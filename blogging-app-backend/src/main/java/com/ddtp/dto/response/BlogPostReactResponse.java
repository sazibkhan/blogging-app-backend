package com.ddtp.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostReactResponse {

    private String id;

    private String reactType;

    private String approval;

    private LocalDateTime approvalAt;

    private String approvalBy;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updateAt;

    private String updateBy;

}
