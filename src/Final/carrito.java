package Final;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class carrito {
    public static void main(String[] args) {

        // Menú
        String[] producto = {"Leche Great Value 128oz", "Cubeta 18 huevos Great Value", "Harina Gold Medal 5lb", "Jugo de manzana Mott's 64oz, Mantequilla Great Value sin sal 4 barras 16 oz"};
        double[] valor = {3.84, 5.87, 4.38, 3.76, 4.47 }; //referencia: walmart.com
        boolean continuar = true;
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> carrito = new ArrayList<>();
        double iva = 0.19;
        double total = 0;

        while (continuar) {
            System.out.println("\n--- Menú ---");
            for (int i = 0; i < producto.length; i++) {
                System.out.println((i + 1) + ". " + producto[i] + " - $" + valor[i]);
            }
            System.out.println("0. Salir");

            System.out.print("Ingrese el número del producto (o 0 para salir): ");
            int eleccion = scanner.nextInt();

            if (eleccion == 0) {
                continuar = false;
            } else if (eleccion >= 1 && eleccion <= producto.length) {
                carrito.add(producto[eleccion - 1]);
                total += valor[eleccion - 1];
            } else {
                System.out.println("Opción inválida.");
            }
        }

        // Mostrar carrito y calcular total con IVA
        System.out.println("\n--- Carrito de compras ---");
        for (int i = 0; i < carrito.size(); i++) {
            String producto_carrito = carrito.get(i);
            System.out.println("- " + producto_carrito);
        }
        System.out.println(" ");
        double totalConIva = (total + (total * iva));
        System.out.println("Subtotal: $" + df.format(total));
        System.out.println("IVA (19%): $" + df.format(total * iva));
        System.out.println("Total a pagar: $" + df.format(totalConIva));
    }
}
