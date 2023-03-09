package Matematicas;

public interface Nodo {
    String info;
    Nodo sig;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nodo aux = new Nodo();
        aux.info = "Primer nodo";
        System.out.print("Ingrese la palabra: ");
        String palabra = scanner.nextLine();
        Nodo naux = aux;

        while (!palabra.equals("")) {
            Nodo nodo = new Nodo();
            nodo.info = palabra;
            naux.sig = nodo;
            naux = nodo;
            System.out.print("Ingrese una palabra: ");
            palabra = scanner.nextLine();
        }

        while (aux != null) {
            System.out.println(aux.info);
            aux = aux.sig;
        }
    }
}
