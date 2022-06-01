package br.com.jkControl.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.jkControl.dao.VisitorDao;
import br.com.jkControl.model.Visitor;

@Named
@RequestScoped
public class VisitorBean {
	
	private Visitor visitor = new Visitor();
	private List<Visitor> list;
	
	private UploadedFile image;
	
	public VisitorBean() {
		list = this.list();
	}
	
	public String save() throws IOException{
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String path = servletContext.getRealPath("/"); 
		
		FileOutputStream out = new FileOutputStream(path + "\\images\\" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		visitor.setImagePath("\\images\\" + image.getFileName());
		new VisitorDao().create(visitor);
		
		mostrarMensagem();
		
		return "setups?faces-redirect=true";
	}
	
	private void mostrarMensagem() {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
	}
	
	public List<Visitor> list(){
		return new VisitorDao().listAll();
	}
	

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public List<Visitor> getList() {
		return list;
	}

	public void setList(List<Visitor> list) {
		this.list = list;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
	
	
}
