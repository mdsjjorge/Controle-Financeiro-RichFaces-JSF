package src.main.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empenho {
    private int id;
    private long IdDespesa;
    private Double ValorEmpenho;
    private int anoEmpenho;
    private int ano;
    private String numeroEmpenho;
    private Date dataEmpenho;
    private double valor;
    private String observacao;    
    
	public Empenho(long IdDespesa, Double ValorEmpenho, int anoEmpenho, int ano, String numeroEmpenho, Date dataEmpenho, double valor, String observacao) {
		super();
		this.IdDespesa = IdDespesa;
		this.ValorEmpenho = ValorEmpenho;
		this.anoEmpenho = anoEmpenho;
		this.ano = ano;
		this.numeroEmpenho = numeroEmpenho;
		this.dataEmpenho = dataEmpenho;
		this.valor = valor;
		this.observacao = observacao;
	}
	
	public long getIdDespesa() {
		return IdDespesa;
	}

	public void setIdDespesa(long idDespesa) {
		IdDespesa = idDespesa;
	}

	public Double getValorEmpenho() {
		return ValorEmpenho;
	}

	public void setValorEmpenho(Double valorEmpenho) {
		ValorEmpenho = valorEmpenho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnoEmpenho() {
		return anoEmpenho;
	}

	public void setAnoEmpenho(int anoEmpenho) {
		this.anoEmpenho = anoEmpenho;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getNumeroEmpenho() {
		return numeroEmpenho;
	}
	public void setNumeroEmpenho(String numeroEmpenho) {
		this.numeroEmpenho = numeroEmpenho;
	}
	public Date getDataEmpenho() {
		return dataEmpenho;
	}
	public void setDataEmpenho(Date dataEmpenho) {
		this.dataEmpenho = dataEmpenho;
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
	
	private List<Pagamento> pagamentos;

    private Despesa despesa;

    public Empenho() {
        this.pagamentos = new ArrayList<>();
    }

    public Empenho(long long1, long long2, String string, int int1, java.sql.Date date, double double1,
			String string2) {
		// TODO Auto-generated constructor stub
	}

	public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }
}
