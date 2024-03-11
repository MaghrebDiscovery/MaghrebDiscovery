package com.app.commentaireservice.service;

import com.app.commentaireservice.dto.CommentaireRequest;
import com.app.commentaireservice.dto.CommentaireResponse;
import com.app.commentaireservice.model.Commentaire;
import com.app.commentaireservice.repository.CommentaireRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;


    @Autowired
    private  RestTemplate restTemplate;


    public void createCommentaire(CommentaireRequest commentaireRequest) {
        Commentaire commentaire = Commentaire.builder()
                .content(commentaireRequest.getContent())
                .username(commentaireRequest.getUsername())
                .build();
        commentaireRepository.save(commentaire);
        log.info("Commentaire is saved");
    }

    public List<CommentaireResponse> getAllCommentaire() {
        List<Commentaire> commentaires = commentaireRepository.findAll();
        return commentaires.stream()
                .map(this::mapToCommentaireResponse)
                .collect(Collectors.toList());
    }

    private CommentaireResponse mapToCommentaireResponse(Commentaire commentaire) {
        String userServiceUrl = "http://localhost:3000/api/user";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(userServiceUrl + "/{username}", String.class, commentaire.getUsername());
        String username = responseEntity.getBody();

        return CommentaireResponse.builder()
                .content(commentaire.getContent())
                .username(commentaire.getUsername())
                .username(username)
                .build();
    }
}
