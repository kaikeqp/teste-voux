package com.voxus.test.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.voxus.test.dao.PostDao;
import com.voxus.test.model.Postagem;


@Controller
public class CriarPostController {

	@Autowired
	private PostDao postrepositorio;

	
	@GetMapping("/criarPost")
	public ModelAndView CriarPost(Postagem postagem) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postagens/criarpost");
		mv.addObject("postagem", new Postagem());
		return mv;
	}
	
	@PostMapping("criarPost")
	public ModelAndView criarPost(@Valid Postagem postagem, BindingResult br) {
		ModelAndView mv =  new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("postagens/criarpost");
			mv.addObject("postagem");
			postagem.setDate(new Date());
		}else {			
		mv.setViewName("redirect:/posts-feitos");
		postrepositorio.save(postagem);
		}
		return mv;
	}
	
	@GetMapping("posts-feitos")
	public ModelAndView listarPost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postagens/listpost");
		mv.addObject("postsList", postrepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postagens/alterar");
		Postagem postagem = postrepositorio.getOne(id);
		mv.addObject(postagem);
		return mv;
	}
	
	
//	@PostMapping("/alterar")
//	public ModelAndView alterar(Postagem postagem){
//		ModelAndView mv = new ModelAndView();
//		postrepositorio.save(postagem);
//		mv.setViewName("redirect:/posts-feitos");
//		return mv;
//	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Postagem postagem, BindingResult br) {
		ModelAndView mv =  new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("postagens/alterar");
			mv.addObject("postagem");
		}else {			
		mv.setViewName("redirect:/posts-feitos");
		postrepositorio.save(postagem);
		}
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirAlino(@PathVariable("id") Integer id){
		postrepositorio.deleteById(id);
		return "redirect:/posts-feitos";
	}
	
}
