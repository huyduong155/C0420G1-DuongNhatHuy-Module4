package repository;

import model.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(Long id);
}
