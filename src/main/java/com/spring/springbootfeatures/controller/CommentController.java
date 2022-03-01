package com.spring.springbootfeatures.controller;

import java.util.List;

import com.spring.springbootfeatures.repository.CommentRepository;
import com.spring.springbootfeatures.exception.ResourceNotFoundException;
import com.spring.springbootfeatures.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

  @Autowired
  CommentRepository commentRepository;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/comments")
  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  @PostMapping("/comments")
  public Comment createComment(@RequestBody Comment comment) {
    return commentRepository.save(comment);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/comments/{id}")
  public Comment getCommentById(@PathVariable(value = "id") Long commentId) {
    return commentRepository
        .findById(commentId)
        .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
  }

  @PutMapping("/comments/{id}")
  public Comment updateComment(
      @PathVariable(value = "id") Long commentId, @RequestBody Comment commentDetails) {

    Comment comment =
        commentRepository
            .findById(commentId)
            .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

    comment.setPostName(commentDetails.getPostName());
    comment.setComment(commentDetails.getComment());

    Comment updatedComment = commentRepository.save(comment);
    return updatedComment;
  }

  @DeleteMapping("/comments/{id}")
  public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
    Comment comment =
        commentRepository
            .findById(commentId)
            .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
    commentRepository.delete(comment);

    return ResponseEntity.ok().build();
  }
}
