package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.CommentRepository;
import com.RSOhub.hub.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * List
 *   1) list comments by Rso (check)
 * -----------------------------------------
 * Create
 *   1) add comment (check)
 * -----------------------------------------
 * Delete
 *   1) delete comment (check)
 */
@RequestMapping("api/comment")
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "create")
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "delete")
    public Comment delete(@RequestBody int commentId) {
        try {
            Optional<Comment> deletedComment = commentRepository.findById(commentId);
            commentRepository.deleteById(commentId);
            return deletedComment.get();
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "listByEvent")
    public List<Comment> create(@RequestBody int eventId) {
        return commentRepository.findByRefEventId(eventId);
    }
}