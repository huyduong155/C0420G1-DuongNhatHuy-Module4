package codegym.blog.controller;

import codegym.blog.model.Blog;
import codegym.blog.service.BlogService;
import codegym.blog.untils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.security.Principal;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String home(){
        return "views/home";
    }

    @GetMapping("/login")
    public String login(){
        return "views/login";
    }

    @GetMapping("/blog")
    public ModelAndView listBlog(@PageableDefault(value = 5) Pageable pageable){
        Page<Blog> blogList = blogService.findAll(pageable);
        return new ModelAndView("views/list","blogs",blogList);
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("views/create","blog",new Blog());
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "views/edit";
        }else
       return "views/error.404";
    }
    @PostMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "views/delete";
        }else
        return "views/error.404";
    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blogService.findById(id));
            return "views/view";
        }else
            return "views/error.404";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal,@PageableDefault(value = 5) Pageable pageable) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "<script> alert('Hi " + principal.getName() //
                    + "! You do not have permission to access this page!')</script>";
            model.addAttribute("message", message);
            Page<Blog> blogList = blogService.findAll(pageable);
            model.addAttribute("blogs",blogList);
        }

        return "views/list";
    }
    @GetMapping("/logoutSuccessful")
    public String logout(){
        return "views/home";
    }
}
