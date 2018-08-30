package br.com.seniorsolution.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.seniorsolution.dao.GenericDao;
import br.com.seniorsolution.entity.Livro;
import br.com.seniorsolution.entity.Revisao;

@ManagedBean(name="revBean")
@RequestScoped
public class RevisoesBean {
	@ManagedProperty(value="#{beanRevisao}")
	
	private Revisao revisao;
	private List<Revisao> revisoes;
	private int codLivro;

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}

	public Revisao getRevisao() {
		return revisao;
	}

	public void setRevisao(Revisao revisao) {
		this.revisao = revisao;
	}
	
	public List<Revisao> getRevisoes() {
		return revisoes;
	}

	public void setRevisoes(List<Revisao> revisoes) {
		this.revisoes = revisoes;
	}

	//action incluirLivro
	public String incluirRevisao() {
		System.out.println("TESTE");
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			ctx.addMessage(null, new FacesMessage("Sucesso: ", " Livro cadastrado com sucesso."));
			GenericDao<Livro> daoLivro = new GenericDao<Livro>(Livro.class);
			this.getRevisao().setLivro(daoLivro.buscar(this.getCodLivro()));
			
			GenericDao<Revisao> daoRevisao = new GenericDao<Revisao>(Revisao.class);
			daoRevisao.adicionar(revisao);
			return "cadRevisoes";
			
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage("Erro: ", " Livro n�o foi cadastrado."));
			return "cadRevisoes";
		}		
	}
	
	//action getListaRevisoes()
	public List<Revisao> getListaRevisoes(){
		GenericDao<Revisao> dao = new GenericDao<>(Revisao.class);
		return dao.listar();
	}
	
	public void eventoLivroRevisao(ValueChangeEvent e) {
		if(e.getNewValue() != null) {
			System.out.println(e.getNewValue());
			int codigo = (Integer)e.getNewValue();
			GenericDao<Revisao> dao = new GenericDao<>(Revisao.class);
			this.setRevisoes(dao.listarRevisao(codigo));
		}else {
			this.setRevisoes(null);
		}
		
	}

}
