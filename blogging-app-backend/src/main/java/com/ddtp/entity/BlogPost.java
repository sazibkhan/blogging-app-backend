package com.ddtp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_post")
public class BlogPost {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "Blog_Post_Title")
    private String blogPostTitle;

    @Column(name = "Blog_Post_Body")
    private String blogPostBody;


    @Column(name = "Approval")
    private String approval;

    @Column(name = "Approval_At")
    private LocalDateTime approvalAt;

    @Column(name = "Approval_By")
    private String approvalBy;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "created_By")
    private String createdBy;

    @Column(name = "Update_At")
    private LocalDateTime updateAt;

    @Column(name = "Update_By")
    private String updateBy;

}
