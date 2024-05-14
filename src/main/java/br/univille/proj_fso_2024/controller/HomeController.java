package br.univille.proj_fso_2024.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import br.univille.proj_fso_2024.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ProdutoService service;
    // @ResponseBody
    // public String index() {
    // return "MÃE, eu não acredito";
    // }
    @GetMapping
    public ModelAndView index() {
		var listaProdutos = service.getAll();

        return new ModelAndView("home/index","produtos",listaProdutos);
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
