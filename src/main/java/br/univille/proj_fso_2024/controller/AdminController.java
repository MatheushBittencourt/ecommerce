package br.univille.proj_fso_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.proj_fso_2024.entity.Produto;
import br.univille.proj_fso_2024.service.ProdutoService;

@Controller
@RequestMapping("/admin/products")
public class AdminController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index() {
        List<Produto> listaProdutos = service.getAll();
        return new ModelAndView("admin/products/index", "produtos", listaProdutos);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        Produto produto = new Produto();
        return new ModelAndView("admin/products/create", "produto", produto);
    }

    @PostMapping
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/admin/products");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        Produto produto = service.getById(id);
        return new ModelAndView("admin/products/edit", "produto", produto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/admin/products");
    }
}
