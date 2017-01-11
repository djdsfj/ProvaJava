package br.com.prova.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.livraria.dao.AutorDao;
import br.com.prova.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;
	
	private AutorDao daoA = new AutorDao();
	private Arraylist<Autores> itens;
	private Arraylist<Autores> itensFiltrados;
	private Arraylist<Autores> comboautorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public ArrayList<Autores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Autores> itens) {
		this.autor = itens;
	}
	public ArrayList<Autores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItens(ArrayList<Autores> itensFiltrados) {
		this.autor = itensFiltrados;
	}
	public ArrayList<Autores> getcomboautorId() {
		return comboautorId;
	}

	public void setItens(ArrayList<Autores> comboautorId) {
		this.autor = comboautorId;
	}
	public void carregarAutorPelaId() {
		try{
			autoridDAO daoA= new autoridDAO();
			itens = daoA.listar();
		} catch (SQLException ex) {
		ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		}		
	
	public void prepararNovo() {
		try{
			Autor= new Autor();
			autoridDAO daoA= new autoridDAO();
			comboautorid = daoA.listar();
		} catch (SQLException ex) {
		ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		}		

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		try{
			autoridDAO daoA= new autoridDAO();
			daoA.salvar(autor);
			itens = daoA.listar();
			JSFUtil.adicionarMensagemSucesso("Autor salvo com sucesso");
		} catch (SQLException ex) {
		ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		

		if(this.autor.getId() == null) {
			daoA.adiciona(this.autor);
		} else {
			daoA.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}
	
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		 try{
			autoridDAO daoA= new autoridDAO();
			daoA.excluir(autor);
			itens = daoA.listar();
			JSFUtil.adicionarMensagemSucesso("Autor salvo com sucesso");
		} catch (SQLException ex) {
		ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
	}
	
	public List<Autor> getAutores() {
		 try{
			autoridDAO daoA= new autoridDAO();
			itens = daoA.listar();
		return daoA.listaTodos();	
		} catch (SQLException ex) {
		ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}
