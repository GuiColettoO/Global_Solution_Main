package br.com.fiap.entity;

import java.util.List;

import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.dto.ReservaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_ALM_COMPRADOR")
public class CompradorEntity {

	@Id
	@Column(name = "ID_COMPRADOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "DS_RAZAO_SOCIAL", nullable = true, length = 50)
	private String razaoSocial;

	@Column(name = "NM_EMPRESA", nullable = true, length = 50)
	private String nomeEmpresa;

	@Column(name = "NR_CNPJ", nullable = true, length = 13)
	private String cnpj;

	@Column(name = "NR_TELEFONE", nullable = true, length = 20)
	private String telefone;

	@Column(name = "DS_EMAIL", nullable = true, length = 50)
	private String email;

	@Column(name = "DS_STATUS", nullable = true)
	private boolean status;

	@ManyToMany(mappedBy = "compradores")
	private List<ReservaDTO> reservas;

	public CompradorEntity() {
	}

	public CompradorEntity(CompradorDTO comprador) {
		this.razaoSocial = comprador.getRazaoSocial();
		this.nomeEmpresa = comprador.getNomeEmpresa();
		this.cnpj = comprador.getCnpj();
		this.telefone = comprador.getTelefone();
		this.email = comprador.getEmail();
		this.status = comprador.isStatus();
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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
