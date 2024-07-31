public class Main {
    public static void main(String[] args) {
        int[] listaOriginal = new int[20];
        int[] lista;
        int sumaDer, sumaIzq;
        generarNumeros(listaOriginal);
        lista = listaOriginal;
        ordenarPorQuickSort(lista, 0, lista.length-1);
        sumaIzq= sumarParteIzq(lista, 0);
        sumaDer = sumarParteDer(lista, 10);

        if (sumaIzq > sumaDer) {
            System.out.println("Lista Ordenada");
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
        }
    }

    public static void generarNumeros(int[] listaOriginal){
        int numero;
        System.out.println("Lista original");
        for (int i = 0; i < listaOriginal.length; i++) {
            numero = (int) (Math.random()*50+1);
            listaOriginal[i] = numero;
            System.out.println(listaOriginal[i]);
        }
    }

    public static void ordenarPorQuickSort(int[] lista, int inferior, int superior){
        int i, j, central;
        double pivote;
        central = (inferior + superior)/2;
        pivote = lista[central];
        i = inferior;
        j = superior;
        System.out.println("Limites que se analizan, Inferior: "+i+", Superior: "+j);
        do {
            while (lista[i] > pivote) i++;
            while (lista[j] < pivote) j--;
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (inferior < j) ordenarPorQuickSort(lista, inferior, j);
        if (i < superior) ordenarPorQuickSort(lista, i, superior);
    }

    public static void intercambiar(int[] lista, int i, int j){
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    public static int sumarParteIzq(int[] lista, int indice){
        int tam = indice;
        int suma = 0;
        if (tam == 9) suma += lista[tam];
        else suma = (lista[tam] + sumarParteIzq(lista, tam + 1));
        return suma;
    }

    public static int sumarParteDer(int[] lista, int indice){
        int tam = indice;
        int suma = 0;
        if (tam == lista.length-1) suma += lista[tam];
        else suma = (lista[tam] + sumarParteDer(lista, tam + 1));
        return suma;
    }
}