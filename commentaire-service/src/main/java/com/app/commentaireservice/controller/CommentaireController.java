package com.app.commentaireservice.controller;

import com.app.commentaireservice.dto.CommentaireRequest;
import com.app.commentaireservice.dto.CommentaireResponse;
import com.app.commentaireservice.service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCommentaire(@RequestBody CommentaireRequest commentaireRequest){
        commentaireService.createCommentaire(commentaireRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentaireResponse> getAllCommentaire(){
        return commentaireService.getAllCommentaire();
    }
}
