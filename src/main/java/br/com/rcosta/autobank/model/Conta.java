package br.com.rcosta.autobank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "agencia", nullable = false)
	private Integer agencia;
	
	@Column(name = "conta", nullable = false, unique = true)
	private Integer conta;
	
	@Column(name = "saldo", nullable = false)
	private Double saldo;
	
	@Column(name = "cartao_credito", nullable = false)
	private Boolean cartaoCredito;
	
	@Column(name = "numero_cartao_credito", unique = true)
	private String numeroCartaoCredito;
	
	@Column(name = "dia_vencimento_cartao_credito")
	private String diaVencimentoCartaoCredito;
	
	@Column(name = "codigo_seguranca_cartao_credito")
	private Integer codigoSegurancaCartaoCredito;
	
	@Column(name = "limite_cartao_credito", nullable = false)
	private Double limiteCartaoCredito;
	
	@Column(name = "cartao_debito", nullable = false)
	private Boolean cartaoDebito;
	
	@Column(name = "numero_cartao_debito", nullable = false, unique = true)
	private String numeroCartaoDebito;
	
	@Column(name = "limite_conta", nullable = false)
	private Boolean limiteConta;
	
	@Column(name = "data_vencimento_cartao_debito")
	private Date vencimentoCartaoDebito;
	
	@Column(name = "codigo_seguranca_cartao_debito")
	private Integer codigoSegurancaCartaoDebito;
	
	@Column(name = "saldo_limite_conta", nullable = false)
	private Double saldoLimiteConta;
	
	public Conta() { }

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

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(Boolean cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public String getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(String numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public String getVencimentoCartaoCredito() {
		return diaVencimentoCartaoCredito;
	}

	public void setVencimentoCartaoCredito(String vencimentoCartaoCredito) {
		this.diaVencimentoCartaoCredito = vencimentoCartaoCredito;
	}

	public Integer getCodigoSegurancaCartaoCredito() {
		return codigoSegurancaCartaoCredito;
	}

	public void setCodigoSegurancaCartaoCredito(Integer codigoSegurancaCartaoCredito) {
		this.codigoSegurancaCartaoCredito = codigoSegurancaCartaoCredito;
	}

	public Boolean getCartaoDebito() {
		return cartaoDebito;
	}

	public void setCartaoDebito(Boolean cartaoDebito) {
		this.cartaoDebito = cartaoDebito;
	}

	public String getNumeroCartaoDebito() {
		return numeroCartaoDebito;
	}

	public void setNumeroCartaoDebito(String numeroCartaoDebito) {
		this.numeroCartaoDebito = numeroCartaoDebito;
	}

	public Boolean getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(Boolean limiteConta) {
		this.limiteConta = limiteConta;
	}

	public Date getVencimentoCartaoDebito() {
		return vencimentoCartaoDebito;
	}

	public void setVencimentoCartaoDebito(Date vencimentoCartaoDebito) {
		this.vencimentoCartaoDebito = vencimentoCartaoDebito;
	}

	public Integer getCodigoSegurancaCartaoDebito() {
		return codigoSegurancaCartaoDebito;
	}

	public void setCodigoSegurancaCartaoDebito(Integer codigoSegurancaCartaoDebito) {
		this.codigoSegurancaCartaoDebito = codigoSegurancaCartaoDebito;
	}

	public Double getSaldoLimiteConta() {
		return saldoLimiteConta;
	}

	public void setSaldoLimiteConta(Double saldoLimiteConta) {
		this.saldoLimiteConta = saldoLimiteConta;
	}

	public Double getLimiteCarto() {
		return limiteCartaoCredito;
	}

	public void setLimiteCarto(Double limiteCarto) {
		this.limiteCartaoCredito = limiteCarto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, cartaoCredito, cartaoDebito, codigoSegurancaCartaoCredito,
				codigoSegurancaCartaoDebito, conta, id, limiteCartaoCredito, limiteConta, numeroCartaoCredito,
				numeroCartaoDebito, saldo, saldoLimiteConta, diaVencimentoCartaoCredito,
				vencimentoCartaoDebito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(cartaoCredito, other.cartaoCredito)
				&& Objects.equals(cartaoDebito, other.cartaoDebito)
				&& Objects.equals(codigoSegurancaCartaoCredito, other.codigoSegurancaCartaoCredito)
				&& Objects.equals(codigoSegurancaCartaoDebito, other.codigoSegurancaCartaoDebito)
				&& Objects.equals(conta, other.conta) && Objects.equals(id, other.id)
				&& Objects.equals(limiteCartaoCredito, other.limiteCartaoCredito) && Objects.equals(limiteConta, other.limiteConta)
				&& Objects.equals(numeroCartaoCredito, other.numeroCartaoCredito)
				&& Objects.equals(numeroCartaoDebito, other.numeroCartaoDebito) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(saldoLimiteConta, other.saldoLimiteConta)
				&& Objects.equals(diaVencimentoCartaoCredito, other.diaVencimentoCartaoCredito)
				&& Objects.equals(vencimentoCartaoDebito, other.vencimentoCartaoDebito);
	}
}
