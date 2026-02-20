package servicio;

import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Transaccion;

public class MetodoOperacionTransferencias {

    private TransaccionService ts = new TransaccionService();
    private MetodosCambioMoneda mcm = new MetodosCambioMoneda();

    public String depositar(String numCuenta, double monto) throws Exception {
        Cuenta c = AlmacenDatos.cuentaPorNumero(numCuenta);
        if (c == null) throw new Exception("Cuenta no encontrada.");
        if (monto <= 0) throw new Exception("Ingrese un monto válido.");

        c.setSaldo(c.getSaldo() + monto);

        ts.registrarTransaccion(c, new Transaccion(
                c.getNumeroCuenta(),
                Transaccion.Tipo.Deposito,
                monto
        ));

        return "Depósito realizado con éxito.";
    }

    public String transferir(String origen, String destino, double monto) throws Exception {
        Cuenta cOrigen = AlmacenDatos.cuentaPorNumero(origen);
        Cuenta cDestino = AlmacenDatos.cuentaPorNumero(destino);

        if (cOrigen == null) throw new Exception("No se encontró la cuenta de origen.");
        if (cDestino == null) throw new Exception("No existe el número de cuenta destino: " + destino);
        if (monto <= 0) throw new Exception("Ingrese un monto válido.");
        if (cOrigen.getSaldo() < monto) throw new Exception("Saldo insuficiente.");

        cOrigen.setSaldo(cOrigen.getSaldo() - monto);

        double convertido = mcm.convertir(monto, cOrigen.getMoneda(), cDestino.getMoneda());
        cDestino.setSaldo(cDestino.getSaldo() + convertido);

        ts.registrarTransaccion(cOrigen, new Transaccion(
                cOrigen.getNumeroCuenta(),
                Transaccion.Tipo.Transferencia,
                monto
        ));

        ts.registrarTransaccion(cDestino, new Transaccion(
                cDestino.getNumeroCuenta(),
                Transaccion.Tipo.Transferencia,
                convertido
        ));

        return "Transferencia realizada con éxito.\n" +
               "Monto enviado: " + String.format(java.util.Locale.US, "%.2f", monto) +
               " (" + cOrigen.getMoneda().getNombre() + ")\n" +
               "Monto recibido: " + String.format(java.util.Locale.US, "%.2f", convertido) +
               " (" + cDestino.getMoneda().getNombre() + ")";
    }
}