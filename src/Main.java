public class Main {
    public static void main(String[] args) {
        String[] nombre = new String[]{"A", "B", "C", "D", "E"};
        int[] rafagaCPU = new int[]{3, 1, 3, 4, 2};
        int[] tiempoLlegada = new int[]{2, 4, 0, 1, 3};
        int tamanioArreglos = nombre.length;
        int[] tiempoDeInicio = new int[tamanioArreglos];
        int[] tiempoDeRetorno = new int[tamanioArreglos];
        int[] tiempoDeEspera = new int[tamanioArreglos];
        int tiempoTotal = 0;
        System.out.print("Orden de los Trabajos segun FIFO: ");
        ordenarArreglosPorTiempoLlegada(nombre, rafagaCPU, tiempoLlegada);
        imprimirArreglo(tiempoLlegada);
        imprimirArreglo(nombre);
        System.out.print("\nRafaga de CPU:");
        imprimirArreglo(rafagaCPU);

        for(int i = 0; i < tamanioArreglos; i++){
            if(i == 0){
                tiempoDeInicio[i] = tiempoLlegada[i];
            }else{
                tiempoDeInicio[i] = Math.max(tiempoTotal, tiempoLlegada[i]);
            }
            tiempoDeRetorno[i] = tiempoDeInicio[i] + rafagaCPU[i];
            tiempoDeEspera[i] = tiempoDeInicio[i] - tiempoLlegada[i];
            tiempoTotal += rafagaCPU[i];
        }
        System.out.print("\nTiempos de Espera:");
        imprimirArreglo(tiempoDeEspera);
        System.out.print("\nTiempos de Retorno:");
        imprimirArreglo(tiempoDeRetorno);

        System.out.println("\nTiempo medio de espera: " + calcularPromedioArreglo(tiempoDeEspera));
        System.out.println("Tiempo de retorno medio: " + calcularPromedioArreglo(tiempoDeRetorno));
    }

    public static void ordenarArreglosPorTiempoLlegada(String[] nombre, int[] rafagaCPU, int[] tiempoLlegada){
        for(int i = 0; i < tiempoLlegada.length; i++){
            for(int j = 0; j < tiempoLlegada.length-1; j++){
                if(tiempoLlegada[j]>tiempoLlegada[j+1]){
                    intercambiarPosicion(tiempoLlegada, j);
                    intercambiarPosicion(rafagaCPU, j);
                    intercambiarPosicion(nombre, j);
                }
            }
        }
    }

    public static void intercambiarPosicion(int[] arreglo, int i){
        int aux = arreglo[i];
        arreglo[i] = arreglo[i+1];
        arreglo[i+1] = aux;
    }

    public static void intercambiarPosicion(String[] arreglo, int i){
        String aux = arreglo[i];
        arreglo[i] = arreglo[i+1];
        arreglo[i+1] = aux;
    }

    public static void imprimirArreglo(int[] arreglo){
        System.out.print("\n[ ");
        for(int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.print("]");
    }

    public static void imprimirArreglo(String[] arreglo){
        System.out.print("\n[ ");
        for(int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.print("]");
    }

    public static double calcularPromedioArreglo(int[] arreglo){
        int suma = 0;
        for(int valor : arreglo){
            suma += valor;
        }
        return (double) suma /arreglo.length;
    }
}