package br.com.fiap.dto;

import br.com.fiap.entity.VendedorEntity;

public class VendedorDTO {
	
	private int id;
	private String razaoSocial;
	private String nomeEmpresa; 
	private String cnpj;
	private int telefone;
	private String email;
	private boolean status;
	
	public VendedorDTO(VendedorEntity entity) {
		this.razaoSocial = entity.getRazaoSocial();
		this.nomeEmpresa = entity.getNomeEmpresa();
		this.cnpj = entity.getCnpj();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.status = entity.isStatus();
	}

	public VendedorDTO(String razaoSocial, String nomeEmpresa, String cnpj, int telefone, String email, boolean status) {
		this.razaoSocial = razaoSocial;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}
