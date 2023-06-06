package br.com.fiap.entity;

import java.util.List;

import br.com.fiap.dto.ReservaDTO;
import br.com.fiap.dto.VendedorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="T_ALM_VENDEDOR")
@SequenceGenerator(name="vendedor", sequenceName = "SQ_T_ALM_VENDEDOR", allocationSize = 1)
public class VendedorEntity {

	@Id
	@Column(name= "ID_VENDEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendedor")
	private int id;
	
	@Column(name= "DS_RAZAO_SOCIAL", nullable = true, length = 50)
	private String razaoSocial;
	
	@Column(name="NM_EMPRESA", nullable = true, length = 50)
	private String nomeEmpresa;
	
	@Column(name="NR_CNPJ", nullable = true, length = 15)
	private String cnpj;
	
	@Column(name="NR_TELEFONE", nullable = true, precision = 11)
	private int telefone;
	
	@Column(name="DS_EMAIL", nullable = true, length = 50)
	private String email;
	
	@Column(name="DS_STATUS", nullable = true)
	private boolean status;
	
	@ManyToMany(mappedBy = "vendedores")
	private List<ReservaDTO> reservas;
	
	public VendedorEntity() {}
	
	public VendedorEntity(VendedorDTO vendedor) {
		this.razaoSocial = vendedor.getRazaoSocial();
		this.nomeEmpresa = vendedor.getNomeEmpresa(); 
		this.cnpj = vendedor.getCnpj();
		this.telefone = vendedor.getTelefone();
		this.email = vendedor.getEmail();
		this.status = vendedor.isStatus();
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

	public List<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaDTO> reservas) {
		this.reservas = reservas;
	}

	
	
	
}
