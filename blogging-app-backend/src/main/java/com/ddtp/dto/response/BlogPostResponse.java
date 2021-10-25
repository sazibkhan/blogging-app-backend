package com.ddtp.dto.response;

import lombok.*;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostResponse {

        @Id
        private String id;

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
