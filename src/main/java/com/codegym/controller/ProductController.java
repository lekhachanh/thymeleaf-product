package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView findAll() {
        List<Product> productList = productService.findAll();

        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("product", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("save")
    public String saveProduct(Product product, RedirectAttributes redirect){
        product.setId((int)(Math.random()*100000));
        productService.save(product);
        redirect.addFlashAttribute("message", "Saved product successfully!");
        return "redirect:/product/create";
    }

    @GetMapping("{id}/edit")
    public String edit (@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public ModelAndView update(Product product){
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        productService.update(product.getId(), product);
        modelAndView.addObject("message", "Modified product successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView remove(Product product){
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        productService.remove(product.getId());
        modelAndView.addObject("message", "Remove product successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/info-product")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/product/info-product");
        modelAndView.addObject("product", productService.findById(id));
        modelAndView.addObject("message", "Show product information successfully");
        return modelAndView;
    }

}
