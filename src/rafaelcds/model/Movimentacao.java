package rafaelcds.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Movimentacao")
public class Movimentacao {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "tipo")
	@Enumerated(EnumType.ORDINAL)
	private ETipoMovimentacao tipo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "valor")
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ETipoMovimentacao getTipo() {
		return tipo;
	}
	
	public String getTipoFormatado() {
		return tipo == null ? "" : tipo.getNome();
	}

	public void setTipo(ETipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}
	
	public String getDataFormatada() {
		return data == null ? null : DATE_FORMAT.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setDataFormatada(String data) {
		try {
			this.data = data == null ? null : DATE_FORMAT.parse(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
