package Matematicas;

public class Polinomio implements  Nodo{
    Nodo termino_mayor;
    int grado;
    int Sig;
    public Polinomio() {
        this.termino_mayor = null;
        this.grado = -1;
    }

    public void agregarTermino(int termino, double valor) {
        Nodo aux = new Nodo();
        datoPolinomio dato = new datoPolinomio(valor, termino);
        aux.info = dato;
        if (termino > this.grado) {
            aux.sig = this.termino_mayor;
            this.termino_mayor = aux;
            this.grado = termino;
        } else {
            Nodo actual = this.termino_mayor;
            while (actual.sig != null && termino < actual.sig.info.termino) {
                actual = actual.sig;
            }
            aux.sig = actual.sig;
            actual.sig = aux;
        }
    }

    public void modificar_termino(Polinomio polinomio, int termino, double valor) {
        Nodo aux = polinomio.getTermino_mayor();
        while (aux != null && aux.getInfo().getTermino() != termino) {
            aux = aux.getSig();
        }
        aux.getInfo().setValor(valor);
    }


    public Nodo getTermino_mayor() {
        return termino_mayor;
    }

    public void setTermino_mayor(Nodo termino_mayor) {
        this.termino_mayor = termino_mayor;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }
}
