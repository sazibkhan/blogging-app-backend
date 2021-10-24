package com.ddtp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Approval")
    private String approval;

    @Column(name = "Approval_At")
    private LocalDateTime approvalAt;

    @Column(name = "Approval_By")
    private String approvalBy;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

    @Column(name = "Update_By")
    private String updateBy;

/*

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoleList;
*/


}
