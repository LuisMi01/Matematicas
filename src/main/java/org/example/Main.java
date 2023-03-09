package org.example;
import java.util.*;

public class Main {

    private int[] coeficientes;

    public Main(int[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public int grado() {
        return this.coeficientes.length - 1;
    }

    public int coeficiente(int i) {
        return this.coeficientes[i];
    }

    public Main suma(Main p) {
        int[] resultado = new int[Math.max(this.grado(), p.grado()) + 1];

        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = this.coeficiente(i) + p.coeficiente(i);
        }

        return new Main(resultado);
    }

    public Main resta(Main p) {
        int[] resultado = new int[Math.max(this.grado(), p.grado()) + 1];

        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = this.coeficiente(i) - p.coeficiente(i);
        }

        return new Main(resultado);
    }

    public Main multiplicacion(Main p) {
        int[] resultado = new int[this.grado() + p.grado() + 1];

        for (int i = 0; i <= this.grado(); i++) {
            for (int j = 0; j <= p.grado(); j++) {
                resultado[i + j] += this.coeficiente(i) * p.coeficiente(j);
            }
        }
        return new Main(resultado);
    }

    public Main division(Main p) {
        int[] dividendo = Arrays.copyOf(this.coeficientes, this.coeficientes.length);
        int[] divisor = Arrays.copyOf(p.coeficientes, p.coeficientes.length);
        int gradoDividendo = this.grado();
        int gradoDivisor = p.grado();
        int[] cociente = new int[gradoDividendo - gradoDivisor + 1];

        for (int i = cociente.length - 1; i >= 0; i--) {
            cociente[i] = dividendo[gradoDivisor + i] / divisor[gradoDivisor];

            for (int j = gradoDivisor + i - 1; j >= i; j--) {
                dividendo[j] -= cociente[i] * divisor[j - i];
            }
        }

        return new Main(cociente);
    }



    static public void mostrarPolinomio(Main p) {
        System.out.println(p);
    }
    public static void main(String[] args) {
        Main p1 = new Main(new int[]{1, 2, 3});
        Main p2 = new Main(new int[]{2, -3, 1});
        mostrarPolinomio(p1.suma(p2));
        mostrarPolinomio(p1.resta(p2));
        mostrarPolinomio(p1.multiplicacion(p2));
        mostrarPolinomio(p1.division(p2));
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = this.grado(); i >= 0; i--) {
            if (this.coeficiente(i) != 0) {
                if (this.coeficiente(i) > 0 && i < this.grado()) {
                    sb.append("+");
                }

                sb.append(this.coeficiente(i));

                if (i > 0) {
                    sb.append("x");

                    if (i > 1) {
                        sb.append("^" + i);
                    }
                }
            }
        }

        return sb.toString();
    }
}