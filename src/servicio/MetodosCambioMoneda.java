package servicio;

import modelos.Moneda;

public class MetodosCambioMoneda {

    // Convierte al cambio del tipo de moneda
    public double convertir(double monto, Moneda de, Moneda a) throws Exception {

        if (monto <= 0) {
            throw new Exception("Ingrese una cantidad válida.");
        }

        if (de == null || a == null) {
            throw new Exception("Seleccione monedas.");
        }

        double valorDe = de.getTipoCambio();
        double valorA  = a.getTipoCambio();

        if (valorA == 0) {
            throw new Exception("Tipo de cambio inválido.");
        }

        return monto * (valorDe / valorA);
    }
}