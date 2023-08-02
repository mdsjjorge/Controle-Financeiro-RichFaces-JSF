package src.main.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Despesa {
	private int id;
    private String numeroProtocolo;
    private String tipoDespesa;
    private Date dataProtocolo;
    private Date dataVencimento;
    private String credor;
    private String descricao;
    private double valor;	
	
	public Despesa(String numeroProtocolo, String tipoDespesa, Date dataProtocolo, Date dataVencimento, String credor,
			String descricao, double valor) {
		super();
		this.numeroProtocolo = numeroProtocolo;
		this.numeroProtocolo = numeroProtocolo;
		this.tipoDespesa = tipoDespesa;
		this.dataProtocolo = dataProtocolo;
		this.dataVencimento = dataVencimento;
		this.credor = credor;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public Date getDataProtocolo() {
		return dataProtocolo;
	}
	public void setDataProtocolo(Date dataProtocolo) {
		this.dataProtocolo = dataProtocolo;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getCredor() {
		return credor;
	}
	public void setCredor(String credor) {
		this.credor = credor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	private List<Empenho> empenhos;

	private StatusDespesa status;

    public Despesa() {
        this.status = StatusDespesa.AGUARDANDO_EMPENHO;
    }

    public Despesa(long long1, String string, String string2, java.sql.Date date, java.sql.Date date2, String string3,
			String string4, double double1, String string5) {
		// TODO Auto-generated constructor stub
	}

	public StatusDespesa getStatus() {
        return status;
    }

    public void setStatus(StatusDespesa status) {
        this.status = status;
    }

    public void atualizarStatus() {
        double valorTotalEmpenhado = calcularValorTotalEmpenhado();
        double valorTotalPago = calcularValorTotalPago();
        double valorTotalDespesa = getValor();

        if (valorTotalEmpenhado == 0) {
            status = StatusDespesa.AGUARDANDO_EMPENHO;
        } else if (valorTotalEmpenhado < valorTotalDespesa && valorTotalPago == 0) {
            status = StatusDespesa.PARCIALMENTE_EMPENHADA;
        } else if (valorTotalEmpenhado == valorTotalDespesa && valorTotalPago == 0) {
            status = StatusDespesa.AGUARDANDO_PAGAMENTO;
        } else if (valorTotalPago > 0 && valorTotalPago < valorTotalDespesa) {
            status = StatusDespesa.PARCIALMENTE_PAGA;
        } else if (valorTotalPago == valorTotalDespesa) {
            status = StatusDespesa.PAGA;
        }
    }

    private double calcularValorTotalEmpenhado() {
        double valorTotalEmpenhado = 0;
        for (Empenho empenho : empenhos) {
            valorTotalEmpenhado += empenho.getValor();
        }
        return valorTotalEmpenhado;
    }

    private double calcularValorTotalPago() {
        double valorTotalPago = 0;
        for (Empenho empenho : empenhos) {
            for (Pagamento pagamento : empenho.getPagamentos()) {
                valorTotalPago += pagamento.getValor();
            }
        }
        return valorTotalPago;
    }
}
