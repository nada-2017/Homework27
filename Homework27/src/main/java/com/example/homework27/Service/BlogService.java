package com.example.homework27.Service;

import com.example.homework27.ApiException.ApiException;
import com.example.homework27.Model.Blog;
import com.example.homework27.Model.MyUser;
import com.example.homework27.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlogs(MyUser user){
        return blogRepository.findAllByUser(user);
    }

    public void addBlog(MyUser user, Blog blog){
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void update(MyUser user, Blog blog, Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b == null || b.getUser() != user)
            throw  new ApiException("Invalid");
        b.setTitle(blog.getTitle());
        b.setBody(blog.getBody());
        blogRepository.save(b);
    }

    public void deleteBlog(MyUser user, Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b == null || b.getUser() != user)
            throw  new ApiException("Invalid");
        blogRepository.delete(b);
    }

    public Blog getBlogById(Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b == null)
            throw  new ApiException("Invalid");
        return b;
    }

    public Blog getBlogByTitle(String title){
        Blog b = blogRepository.getBlogByTitle(title);
        if (b == null)
            throw  new ApiException("Invalid");
        return b;
    }
}
