package com.example.homework27.Controller;

import com.example.homework27.Model.Blog;
import com.example.homework27.Model.MyUser;
import com.example.homework27.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlogs(@AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(200).body(blogService.getBlogs(myUser));
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog) {
        blogService.addBlog(myUser, blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog, @PathVariable Integer id) {
        blogService.update(myUser, blog, id);
        return ResponseEntity.status(200).body("Blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id) {
        blogService.deleteBlog(myUser, id);
        return ResponseEntity.status(200).body("Blog deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(blogService.getBlogById(id));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title));
    }
}
