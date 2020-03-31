package com.featurevote.web;

import com.featurevote.domain.Comment;
import com.featurevote.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products/{productId}/features/{featureId}/comments")
public class CommentController {

    @Autowired
    public CommentRepository commentRepo;

    @GetMapping("")
    @ResponseBody  //Purpose here is just to return data, not to render a view
    public List<Comment> getComments(@PathVariable Long featureId){
        return commentRepo.findByFeatureId(featureId);
    }
}
