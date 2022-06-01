package br.com.jkControl.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCD_VISITANTE")
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nm_visitante", nullable = false)
	private String nome;

	@Column(name = "dt_nasc", nullable = false)
	private LocalDate dataNasct;

	@Column(name = "nr_cpf")
	private String cpf;

	@Column(name = "nr_rg")
	private String rg;

	@Column(name = "nm_digito_rg")
	private char dgtRg;

	@Column(name = "dt_cadastro", nullable = false)
	private Date dataCadastro;

	private String imagePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasct() {
		return dataNasct;
	}

	public void setDataNasct(LocalDate dataNasct) {
		this.dataNasct = dataNasct;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getDgtRg() {
		return dgtRg;
	}

	public void setDgtRg(char dgtRg) {
		this.dgtRg = dgtRg;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", Nascimento=" + dataNasct.format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ", rg="
				+ rg + ", digito rg=" + dgtRg + ", cpf=" + cpf + ", Data cadastro"
				+ dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss")) + "]";
	}

}
