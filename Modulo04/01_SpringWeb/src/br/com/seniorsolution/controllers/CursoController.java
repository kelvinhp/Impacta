package br.com.seniorsolution.controllers;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.seniorsolution.entidades.Curso;
import br.com.seniorsolution.entidades.Escola;
import br.com.seniorsolution.jdbc.JdbcCursoDao;
import br.com.seniorsolution.jdbc.JdbcDisciplinaDao;
import br.com.seniorsolution.jdbc.JdbcEscolaDao;

@Controller
public class CursoController {

	@RequestMapping("/curso/cadastro")
	public String incluir(ModelMap model) {
		
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("beanJdbc.xml");
		
		JdbcEscolaDao dao = (JdbcEscolaDao) ctx.getBean("jdbcEscolaDao");
		try {
			model.addAttribute("escolas", dao.listarEscolas());
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "paginas/erro";			
		}
	}
	
	@RequestMapping(value="/cadcurso",method=RequestMethod.POST)
	public String incluir(@RequestParam("idescola") int id_e, 
							@Valid Curso curso, 
							BindingResult result,
							ModelMap model) {
		
		if(result.hasErrors()) {
			return "forward:/curso/cadastro";
		}
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beanJdbc.xml");
		
		JdbcEscolaDao dao = (JdbcEscolaDao) ctx.getBean("jdbcEscolaDao");
		JdbcCursoDao daoc = (JdbcCursoDao) ctx.getBean("jdbcCursoDao");
		
		try {
			Escola escola = dao.buscarEscola(id_e);
			curso.setEscola(escola);
			daoc.incluirCurso(curso);
			
			model.addAttribute("mensagem", "Curso " 
					+ curso.getDescricao() + " inclu�do.");
			
			return "paginas/sucesso";
			//a ser completado
			
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "paginas/erro";
		}
	}
	
	@RequestMapping("/curso/remover")
	public String remover(@RequestParam("id") int id, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcCursoDao dao = (JdbcCursoDao) ctx.getBean("jdbcCursoDao");
			
			Curso curso = dao.buscarCurso(id);
			
			dao.remover(id);

			model.addAttribute("mensagem", "Curso " + curso.getDescricao() + " removido.");
			return "paginas/sucesso";
		} catch (Exception e) {
			// TODO: handle exception
			
			model.addAttribute("mensagem", e.getMessage());
			return "paginas/erro";
		}
	}
	
	@RequestMapping("/curso/disciplinas")
	public ModelAndView listar(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcDisciplinaDao dao = (JdbcDisciplinaDao)ctx.getBean("jdbcDisciplinaDao");
			
			model.addObject("listaDisciplinas", dao.listarDisciplinas(id));
			model.setViewName("consultas/listarDisciplinas");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			model.addObject("mensagem", e.getMessage());
			model.setViewName("paginas/erro");
		}
		return model;
	}
}
