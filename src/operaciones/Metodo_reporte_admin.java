package operaciones;

import datos.AlmacenDatos;
import modelos.Usuario;
import modelos.Cuenta;

public class Metodo_reporte_admin {

    /**
     * Busca un usuario por su NOMBRE
     * Devuelve el Usuario si existe
     * Devuelve null si no existe
     */
	 public static Usuario clientePorNombre(String nombre) {
		  if (nombre == null || nombre.trim().isEmpty()) {
	            return null;
	        }

	        for (int i = 0; i < AlmacenDatos.listaUsuarios.size(); i++) {
	            Usuario user = AlmacenDatos.listaUsuarios.get(i);

	            if (user.getNombre().equalsIgnoreCase(nombre)) {
	                return user;
	            }
	        }
	        return null;
	    }

	   

	    /**
	     * NUEVO MÉTODO
	     * Busca TODAS las cuentas asociadas a un nombre
	     * Devuelve un ARREGLO de cuentas
	     */
	    public static Cuenta[] cuentasPorNombre(String nombre) {
	    

	        // 1Contar coincidencias
	        int contador = 0;
	        for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
	            Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
	            if (cuenta.getUsuario().getNombre().equalsIgnoreCase(nombre)) {
	                contador++;
	            }
	        }

	        //  Crear arreglo
	        Cuenta[] resultado = new Cuenta[contador];
	        int index = 0;

	        //  Llenar arreglo
	        for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
	            Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
	            if (cuenta.getUsuario().getNombre().equalsIgnoreCase(nombre)) {
	                resultado[index++] = cuenta;
	            }
	        }

	        return resultado;
	    }
	
    
    //metodo de monto
    public static Cuenta[] cuentasPorRangoSaldo(double saldoMinimo, double saldoMaximo) {
    // 1️⃣ Contar cuántas cuentas cumplen la condición
    int indice = 0;
    for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
        Cuenta c = AlmacenDatos.listaCuentas.get(i);
        if (c.getSaldo() >= saldoMinimo && c.getSaldo() <= saldoMaximo) {
            indice++;
        }
    }

    //  Crear el arreglo del tamaño exacto
    Cuenta[] resultado = new Cuenta[indice];
    int index = 0;

    //  Llenar el arreglo
    for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
        Cuenta c = AlmacenDatos.listaCuentas.get(i);
        if (c.getSaldo() >= saldoMinimo && c.getSaldo() <= saldoMaximo) {
            resultado[index] = c;
            index++;
        }
    }

    return resultado; // si no hay cuentas, devuelve un arreglo vacío
}
}
