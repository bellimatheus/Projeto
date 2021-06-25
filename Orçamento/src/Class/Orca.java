package Class;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Orca {
	private int id, qtde;
	private Date data;
	private String frn, prod;
	private double preco, frete;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");// Classe para formatar a Data

	public Orca(int id, int qtde, int data, String frn, String prod, double preco, double frete) {
		super();
		this.id = id;
		this.qtde = qtde;
		this.frn = frn;
		this.prod = prod;
		this.frete = frete;
		this.preco = preco;
	}

	public Orca(Integer valueOf, Date parse, String string, String string2, Integer valueOf2, Integer valueOf3) {
		// TODO Auto-generated constructor stub
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public void setFormato(SimpleDateFormat formato) {
		this.formato = formato;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getFrn() {
		return frn;
	}

	public void setFrn(String frn) {
		this.frn = frn;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		long temp;
		temp = Double.doubleToLongBits(frete);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((frn == null) ? 0 : frn.hashCode());
		result = prime * result + id;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((prod == null) ? 0 : prod.hashCode());
		result = prime * result + qtde;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orca other = (Orca) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (Double.doubleToLongBits(frete) != Double.doubleToLongBits(other.frete))
			return false;
		if (frn == null) {
			if (other.frn != null)
				return false;
		} else if (!frn.equals(other.frn))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (prod == null) {
			if (other.prod != null)
				return false;
		} else if (!prod.equals(other.prod))
			return false;
		if (qtde != other.qtde)
			return false;
		return true;
	}

	double getSubTotal() {

		return (double) preco * qtde;

		/*
		 * String acumulador = ""; acumulador += "Id\tQtde\tDia\tFrn\tProd\tPreço"; int
		 * indice = 0; for (Orca o : ProcessaOrcamentos.orcamentos) { acumulador +=
		 * indice + "\t" +o.toString(); indice++; } acumulador += "Total de DENERO: " +
		 * ProcessaOrcamentos.tempoTotal();
		 * 
		 * return acumulador; return id;
		 */
	}

	@Override
	public String toString() {
		return "ID " + id + " Data " + formato.format(data) + " Produto " + prod + " Fornecedor " + frn + " Estoque "
				+ qtde + " Frete " + frete + " Preço " + preco + "  " + String.format("%.1f", getSubTotal()) + "\n";
	}

	public String toCSV() {
		return id + ";" + prod + ";" + qtde + ";" + frete + ";" + formato.format(data) + ";" + frn + ";" + preco + ";"
				+ String.format("%.1f", getSubTotal()) + "\r\n";
	}

}
