package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CartaoCredito extends FormaPagamento{

	private static final long serialVersionUID = 2903533596271519651L;
	@Column(nullable = false)
	private Integer numeroCartao;
	@Column(nullable = false)
	private String codigoSeguranca;
	@Column(nullable = false)
	private TipoCartao tipoCartao;
	@Column(nullable = false)
	private Bandeira bandeira;

	public Integer getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

}
