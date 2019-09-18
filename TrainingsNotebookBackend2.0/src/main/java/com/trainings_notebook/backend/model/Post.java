package com.trainings_notebook.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @NotBlank
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private TrainerAccount author;

    @NotBlank
    @Column(name = "create_date")
    private LocalDate createDate;

    @NotBlank
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Post addComment(Comment comment) {
        for (Comment commentToAdd : comments) {
            if(commentToAdd.getId() == comment.getId()) {
                throw new RuntimeException();
            }
            else {
                comment.setPost(this);
                this.comments.add(comment);
            }
        }

        return this;
    }
    public boolean removeComment(Comment comment) {
        if (comments.contains(comment)) {
            this.comments.remove(comment);
            return true;
        }
        return false;
    }
}
