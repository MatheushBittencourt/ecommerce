package br.univille.proj_fso_2024.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import br.univille.proj_fso_2024.entity.Produto;
import br.univille.proj_fso_2024.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/admin/products")
public class AdminController {

	@Autowired
	private ProdutoService service;
    @GetMapping
    public ModelAndView index() {
		var listaProdutos = service.getAll();

        return new ModelAndView("admin/products/index","produtos",listaProdutos);
    }

	@GetMapping("/create")
	public ModelAndView create() {
		var produto = new Produto();

		return new ModelAndView("admin/products/create", "produto", produto);
	}

	@PostMapping
	public ModelAndView save(Produto produto) {
		service.save(produto);
		return new ModelAndView("redirect:/admin/products");
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") long id) {
		var produto = service.getById(id);
		return new ModelAndView("admin/products/edit", "produto", produto);
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		service.delete(id);
		return new ModelAndView("redirect:/admin/products");
	}

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        String projectDirectory = new File("").getAbsolutePath();
        String uploadDirectory = projectDirectory + File.separator + "storage/uploads";
        new File(uploadDirectory).mkdirs();

        try {
            file.transferTo(new File(uploadDirectory + File.separator + fileName));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("Upload feito com sucesso.");
    }

}
