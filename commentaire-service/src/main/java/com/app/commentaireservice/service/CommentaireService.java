package com.app.commentaireservice.service;

import com.app.commentaireservice.dto.CommentaireRequest;
import com.app.commentaireservice.dto.CommentaireResponse;
import com.app.commentaireservice.feign.CommentaireInterface;
import com.app.commentaireservice.model.Commentaire;
import com.app.commentaireservice.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CommentaireService {
    @Autowired
    private  CommentaireRepository commentaireRepository;


    public void createCommentaire(CommentaireRequest commentaireRequest) {
        Commentaire commentaire = Commentaire.builder()
                .content(commentaireRequest.getContent())
                .username(commentaireRequest.getUsername())
                .build();
        commentaireRepository.save(commentaire);
        log.info("commentaire is saved");

    }

    public List<CommentaireResponse> getAllCommentaire() {
        List<Commentaire> commentaires= commentaireRepository.findAll();
        return commentaires.stream().map(this::mapToCommentaireResponse).toList();
    }

    private CommentaireResponse mapToCommentaireResponse(Commentaire commentaire){
        return CommentaireResponse.builder()
                .content(commentaire.getContent())
                .username(commentaire.getUsername())
                .build();
    }
}
