package ProjetShopBoot.restController;

import java.io.Console;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.services.ArticleService;

@RestController
@RequestMapping("/api/article")
@CrossOrigin(origins = "*")
public class ArticleRestController {

	public ArticleRestController() {
		System.out.println("TESST");
	}

	@Autowired
	private ArticleService articleService;

	@GetMapping("")
	@JsonView(JsonViews.Article.class)
	public List<Article> getAll(Model model) {
		return articleService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Article.class)
	public Article getById(@PathVariable Long id) {
		return articleService.getById(id);
	}

	@JsonView(JsonViews.Article.class)
	@PostMapping("")
	public Article create(@Valid @RequestBody Article article, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return articleService.create(article);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Article.class)
	public Article update(@PathVariable Long id, @Valid @RequestBody Article article, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		article.setId(id);
		return articleService.update(article);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		articleService.deleteById(id);
	}

}
