package src.main.entidades;

import java.util.Date;

public class Pagamento {
	private long id;
	private long idEmpenho;
	private Double valorPagamento;
    private int ano;
    private int anoPagamento;    
    private String numeroPagamento;
    private Date dataPagamento;
    private double valor;
    private String observacao;    
    
	public Pagamento(long idEmpenho,Double valorPagamento, int ano,int anoPagamento, String numeroPagamento, Date dataPagamento, double valor, String observacao) {
		super();
		this.idEmpenho = idEmpenho;
		this.valorPagamento = valorPagamento;
		this.ano = ano;
		this.anoPagamento = anoPagamento;
		this.numeroPagamento = numeroPagamento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.observacao = observacao;
	}
	
	public Pagamento(long long1, long long2, String string, int int1, java.sql.Date date, double double1,
			String string2) {
		// TODO Auto-generated constructor stub
	}

	public long getIdEmpenho() {
		return idEmpenho;
	}

	public void setIdEmpenho(long idEmpenho) {
		this.idEmpenho = idEmpenho;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAnoPagamento() {
		return anoPagamento;
	}

	public void setAnoPagamento(int anoPagamento) {
		this.anoPagamento = anoPagamento;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getNumeroPagamento() {
		return numeroPagamento;
	}
	public void setNumeroPagamento(String numeroPagamento) {
		this.numeroPagamento = numeroPagamento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	private Empenho empenho;

    public Empenho getEmpenho() {
        return empenho;
    }

    public void setEmpenho(Empenho empenho) {
        this.empenho = empenho;
    }
}
