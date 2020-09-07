package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product.model.Cart;
import product.model.Product;
import product.service.ProductService;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public ModelAndView getListProduct(){
        List<Product> products = productService.findAll();
        return new ModelAndView("listProduct","products",products);
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @PostMapping("/add-cart")
    public ModelAndView addCart(@SessionAttribute("cart") Cart cart,@ModelAttribute("product") Product product ){
        ModelAndView modelAndView = new ModelAndView("view");
//        cart.addToCart(product);
//        Map<Product,Integer> listPro=cart.getCart();
//        modelAndView.addObject("carts",listPro);
        if (product==null){
            modelAndView.addObject("message","error");
        }else {
            cart.addToCart(product);
            modelAndView.addObject("carts",cart.getCart());
            modelAndView.addObject("message", "add " + product.getName() + "  completed");
        }
        return modelAndView;
    }
    @GetMapping("/cart")
    public ModelAndView getCart(@SessionAttribute("cart") Cart cart){
        return new ModelAndView("cart","carts",cart.getCart());
    }
    @GetMapping("/cart/{id}/add")
    public String amountCart(@PathVariable int id,@SessionAttribute("cart")Cart cart,Model model){
        Product product = productService.findById(id);
        cart.addToCart(product);
        model.addAttribute("carts",cart.getCart());
        return "cart";
    }
    @GetMapping("/cart/{id}/sub")
    public String amountCartSub(@PathVariable int id,@SessionAttribute("cart")Cart cart,Model model){
        Product product = productService.findById(id);
        cart.sub(product);
        model.addAttribute("carts",cart.getCart());
        return "cart";
    }

}
