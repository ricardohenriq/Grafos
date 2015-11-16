#define maxV 1000
static int conta, lbl[maxV];
/* A função DIGRAPHbfs visita todos os vértices do digrafo G que podem 
ser alcançados a partir do vértice s.  A ordem em que os vértices são 
visitados é registrada no vetor lbl.  (Código inspirado no programa 18.9 de Sedgewick.) */
void DIGRAPHbfs( Digraph G, Vertex s) 
{ 
   Vertex v, w;
   conta = 0;
   for (v = 0; v < G->V; v++)
      lbl[v] = -1;
   QUEUEinit( G->V);
   lbl[s] = conta++; 
   QUEUEput( s); 
   while (!QUEUEempty( )) {
      v = QUEUEget( ); 
      for (w = 0; w < G->V; w++)
         if (G->adj[v][w] == 1 && lbl[w] == -1) {
            lbl[w] = conta++; 
            QUEUEput( w); 
         }
   }
   QUEUEfree( ); 
}