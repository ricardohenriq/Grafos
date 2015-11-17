package br.ufg.inf;

import java.util.Arrays;

/**
 * Created by thiagodurante on 16/11/15.
 */
public class Grafo {

    class Aresta implements Comparable<Aresta>{

        int inicio;
        int fim;
        int peso;

        @Override
        public int compareTo(Aresta arestaComparacao) {
            return this.peso - arestaComparacao.peso;
        }
    }

    // Representa um subconjunto para o algoritmo de union-find
    class Subconjunto{

        int parent;
        int rank;
    }

    int V; // Número de vértices
    int A; // Número de arestas
    Aresta arestas[]; // Coleção com todas as arestas

    // Cria um grafo com v vértices e a arestas
    Grafo(int v, int a){
        this.V = v;
        this.A = a;
        this.arestas = new Aresta[a];

        for(int i=0; i<a; i++){
            this.arestas[i] = new Aresta();
        }
    }

    /* DETECÇÃO DE CICLO NO GRAFO:
     * USA UM ALGORIMTO AUXILIAR PARA ESTE FIM (UNION-FIND) */
    int find(Subconjunto subconjuntos[], int i)
    {
        if (subconjuntos[i].parent != i){
            subconjuntos[i].parent = find(subconjuntos, subconjuntos[i].parent);
        }
        return subconjuntos[i].parent;
    }

    void union(Subconjunto subconjuntos[], int x, int y)
    {
        int xroot = find(subconjuntos, x);
        int yroot = find(subconjuntos, y);

        if (subconjuntos[xroot].rank < subconjuntos[yroot].rank) {
            subconjuntos[xroot].parent = yroot;
        }
        else if (subconjuntos[xroot].rank > subconjuntos[yroot].rank){
            subconjuntos[yroot].parent = xroot;
        }
        else {
            subconjuntos[yroot].parent = xroot;
            subconjuntos[xroot].rank++;
        }
    }

    void kruskal()
    {
        int a = 0;

        /* INICIALIZANDO:
         * CRIA UM ARRAY RESULTADO PARA ARMAZENAR TODAS AS ARESTAS QUE COMPÕEM A ÁRVORA DE GERAÇÃO MÍNIMA */
        Aresta resultado[] = new Aresta[V];
        for (int i=0; i<V; i++){
            resultado[i] = new Aresta();
        }

        /* PASSO 1:
         * ORDENAR TODAS AS ARESTAS POR ORDEM DE PESO */
        Arrays.sort(arestas);

        Subconjunto subconjuntos[] = new Subconjunto[V];
        for(int i=0; i<V; i++){
            subconjuntos[i]=new Subconjunto();
        }


        for (int v = 0; v < this.V; v++)
        {
            subconjuntos[v].parent = v;
            subconjuntos[v].rank = 0;
        }

        int count = 0;

        while (a < V - 1)
        {
            /* PASSO 2:
             * VERIFICA A EXISTÊNCIA DE UM CICLO */
            Aresta proximaAresta = new Aresta();
            proximaAresta = arestas[count++];

            int x = find(subconjuntos, proximaAresta.inicio);
            int y = find(subconjuntos, proximaAresta.fim);

            /* PASSO 3:
             * SE NÃO HÁ CICLO, ADICIONA A ARESTA NA ÁRVORE GERADORA */
            if (x != y)
            {
                resultado[a++] = proximaAresta;
                union(subconjuntos, x, y);
            }
        }

        int custoTotal = 0;

        System.out.println("Arestas que constituem a árvore geradora mínima \n");
        for (int i = 0; i < a; i++){
            System.out.println(resultado[i].inicio+" -- "+resultado[i].fim+" == "+ resultado[i].peso);
            custoTotal += resultado[i].peso;
        }
        System.out.println("\nO custo total para geração da árvore é: " +custoTotal);
    }
}
