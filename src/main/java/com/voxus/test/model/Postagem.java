package com.voxus.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="titulo")
	@Size(min = 5, max = 100, message="O título deve conter entre 5 e 100 caracteres")
	@NotBlank(message = "O título não pode ser vazio")
	private String titulo;
	
	@Size(min=100, message="O conteúdo deve conter pelo menos 100 caracteres")
	@NotBlank(message = "O conteúdo não pode ser vazio")
	@Column(name="conteudo")
	private String conteudo;
	
	@Column(name="data")
	private Date date;
	
//	private String data;
	
	@Size(min=1, max=10, message="Tags devem conter até 10 caracteres")
	@Column(name="tag")
	private String tag;

	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
//	public String getData() {
//		return data;
//	}
//	public void setData(String data) {
//		this.data = data;
//	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
