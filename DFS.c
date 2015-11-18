/* Vamos supor que nossos digrafos têm no máximo maxV vértices. */

static int conta, pre[maxV];
/* A função DIGRAPHdfs visita todos os vértices e todos os arcos do digrafo G. A função 
atribui um número de ordem pre[x] a cada vértice x:  o k-ésimo vértice visitado recebe 
número de ordem k.  (Código inspirado no programa 18.3 de Sedgewick.) */

/* A função DIGRAPHdfs é apenas uma interface.  A busca em profundidade propriamente dita 
é realizada pela função recursiva dfsR.  Cada invocação de dfsR a partir de DIGRAPHdfs é 
uma etapa da busca em profundidade. Se dissermos que um vértice v está marcado quando pre[v] 
é positivo, podemos descrever cada etapa assim:  (1) escolha um vértice não marcado v e (2) 
visite e marque todos os vértices acessíveis a partir de v que ainda não estejam marcados. 
A maneira de escolher um vértice não marcado em (1) é irrelevante; o código acima examina os 
vértices na ordem 0, 1, 2, etc., mas poderia ter usado qualquer outra ordem.*/

void DIGRAPHdfs( Digraph G) 
{ 
   Vertex v;
   conta = 0;
   for (v = 0; v < G->V; v++) 
      pre[v] = -1;
   for (v = 0; v < G->V; v++)
      if (pre[v] == -1) 
         dfsR( G, v);
}
/* A função dfsR supõe que o digrafo G é representado por uma matriz de adjacência.  (Inspirado 
no programas 18.1 de Sedgewick.) */

void dfsR( Digraph G, Vertex v) 
{ 
   Vertex w;
   pre[v] = conta++; 
   for (w = 0; w < G->V; w++)
      if (G->adj[v][w] != 0 && pre[w] == -1)
         dfsR( G, w); 
}