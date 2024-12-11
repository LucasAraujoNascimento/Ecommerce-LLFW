package model;

public class Pagamento {
	private int id;
	private String tipoDePagamento;
	private int valorPago;
	private String dataPagamento;
	
	public Pagamento(int id, String tipoDePagamento, int valorPago, String dataPagamento) {
		super();
		this.id = id;
		this.tipoDePagamento = tipoDePagamento;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
	}

	public Pagamento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public int getValorPago() {
		return valorPago;
	}

	public void setValorPago(int valorPago) {
		this.valorPago = valorPago;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
}
