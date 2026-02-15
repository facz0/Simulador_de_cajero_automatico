package modelos;

public class Moneda {
	private String idMoneda;
	private String nombre;
	private double tipoCambio;
	
	public Moneda(String idMoneda, String nombre, double tipoCambio) {
		this.idMoneda = idMoneda; //ejemplo $, S/.
        this.nombre = nombre; //Soles, Dolares
        this.tipoCambio = tipoCambio;
    }

	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
