package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.CommentRepository;
import com.RSOhub.hub.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* TODO:
 * List
 *   1) list comments by Rso
 * -----------------------------------------
 * Create
 *   1) add comment
 * -----------------------------------------
 * Delete
 *   1) delete comment
 */
@RequestMapping("api/comment")
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping(path = "create")
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PostMapping(path = "delete")
    public Comment delete(@RequestBody Comment comment) {
        commentRepository.delete(comment);
        return comment;
    }

    @PostMapping(path = "listByEvent")
    public List<Comment> create(@RequestBody int eventId) {
        return commentRepository.findByRefEventId(eventId);
    }
}