package br.com.rcosta.autobank.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "banco")
public class Banco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "agencia", unique = true)
	private Integer agencia;
	
	@Column(name = "codigo_banco", nullable = false)
	private Integer codigoBanco;
	
	@Column(name = "presencial", nullable = false)
	private Boolean presencial;
	
	@Column(name = "online", nullable = false)
	private Boolean online;
	
	@Column(name = "financiamento_residencial", nullable = false)
	private Boolean financiamentoResidencia;
	
	@Column(name = "financiamento_veiculo", nullable = false)
	private Boolean financiamentoVeiculo;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "banco_conta", joinColumns = {@JoinColumn (name = "id_banco")},
		inverseJoinColumns = {@JoinColumn (name = "id_conta")})
	private List<Conta> contas;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "banco_endereco", joinColumns = {@JoinColumn (name = "id_banco")},
		inverseJoinColumns = {@JoinColumn (name = "id_endereco")})
	private Endereco endereco;
	
	public Banco() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		this.presencial = presencial;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Boolean getFinanciamentoResidencia() {
		return financiamentoResidencia;
	}

	public void setFinanciamentoResidencia(Boolean financiamentoResidencia) {
		this.financiamentoResidencia = financiamentoResidencia;
	}

	public Boolean getFinanciamentoVeiculo() {
		return financiamentoVeiculo;
	}

	public void setFinanciamentoVeiculo(Boolean financiamentoVeiculo) {
		this.financiamentoVeiculo = financiamentoVeiculo;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, codigoBanco, contas, endereco, financiamentoResidencia, financiamentoVeiculo, id,
				online, presencial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(codigoBanco, other.codigoBanco)
				&& Objects.equals(contas, other.contas) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(financiamentoResidencia, other.financiamentoResidencia)
				&& Objects.equals(financiamentoVeiculo, other.financiamentoVeiculo) && Objects.equals(id, other.id)
				&& Objects.equals(online, other.online) && Objects.equals(presencial, other.presencial);
	}
}
