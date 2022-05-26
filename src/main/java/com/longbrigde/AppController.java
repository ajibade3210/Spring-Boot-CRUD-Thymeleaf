package com.longbrigde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.listAll();
        model.addAttribute("page_title", "Product Home Page");
        model.addAttribute("listProducts", listProduct);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("page_title", "Product Creation Form");
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
                service.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("new_product");
        Product product = service.get(id);
        mav.addObject("page_title", "Product Edit Form");
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String showDeleteProductForm(@PathVariable(name="id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

