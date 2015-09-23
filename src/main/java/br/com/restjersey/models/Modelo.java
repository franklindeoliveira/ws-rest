package br.com.restjersey.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Modelo {
	
	private Integer id;
	private String atributo;
	
	public Modelo() {}
	
	public Modelo(Integer id, String atributo) {
		this.id = id;
		this.atributo = atributo;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	} 

}
