package modelos;

public class Moneda {
	private String idMoneda;
	private String nombre;
	private double tipoCambio;
	
	public Moneda(String nombre, String simbolo, double tipoCambioVenta) {
        this.nombre = nombre;
        this.idMoneda = idMoneda;
        this.tipoCambio = tipoCambioVenta;
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
	
	
}
