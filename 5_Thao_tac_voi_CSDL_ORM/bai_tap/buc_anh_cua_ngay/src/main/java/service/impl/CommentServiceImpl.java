package service.impl;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CommentRepository;
import repository.impl.CommentRepositoryImpl;
import service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository ;
    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    @Override
    public Comment findById(Long id) {
        Comment comment = commentRepository.findById(id);
        return comment;
    }
}
