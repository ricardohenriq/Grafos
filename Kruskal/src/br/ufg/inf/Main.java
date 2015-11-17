package br.ufg.inf;

/**
 * Created by thiagodurante on 17/11/15.
 */
public class Main {

    public static void main (String[] args) {

        int V = 7;
        int A = 11;
        Grafo grafo =  new Grafo(V,A);

        // MONTA O GRAFO REPRESENTADO PELAS IMAGENS DO PROJETOS

        // add edge AB
        grafo.arestas[0].inicio = 0;
        grafo.arestas[0].fim = 1;
        grafo.arestas[0].peso = 7;

        // add edge AD
        grafo.arestas[1].inicio = 0;
        grafo.arestas[1].fim = 3;
        grafo.arestas[1].peso = 5;

        // add edge BC
        grafo.arestas[2].inicio = 1;
        grafo.arestas[2].fim = 2;
        grafo.arestas[2].peso = 8;

        // add edge BE
        grafo.arestas[3].inicio = 1;
        grafo.arestas[3].fim = 4;
        grafo.arestas[3].peso = 7;

        // add edge BD
        grafo.arestas[4].inicio = 1;
        grafo.arestas[4].fim = 3;
        grafo.arestas[4].peso = 9;

        // add edge CE
        grafo.arestas[5].inicio = 2;
        grafo.arestas[5].fim = 4;
        grafo.arestas[5].peso = 5;

        // add edge DE
        grafo.arestas[6].inicio = 3;
        grafo.arestas[6].fim = 4;
        grafo.arestas[6].peso = 15;

        // add edge DF
        grafo.arestas[7].inicio = 3;
        grafo.arestas[7].fim = 5;
        grafo.arestas[7].peso = 6;

        // add edge EF
        grafo.arestas[8].inicio = 4;
        grafo.arestas[8].fim = 5;
        grafo.arestas[8].peso = 8;

        // add edge EG
        grafo.arestas[9].inicio = 4;
        grafo.arestas[9].fim = 6;
        grafo.arestas[9].peso = 9;

        // add edge FG
        grafo.arestas[10].inicio = 5;
        grafo.arestas[10].fim = 6;
        grafo.arestas[10].peso = 11;

        grafo.kruskal();
    }
}
