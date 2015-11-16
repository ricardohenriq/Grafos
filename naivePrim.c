#define Vertex int

typedef struct { 
   Vertex v, w; 
} Arc;

Arc ARC( Vertex v, Vertex w) {
   Arc a;
   a.v = v, a.w = w;
   return a;
}

struct node { 
   Vertex w; 
   link next; 
};

typedef struct node *link;

struct digraph {
   int V; 
   int A; 
   link *adj; 
};

typedef struct digraph *Digraph;
#define Graph Digraph

void naivePrim(Graph G, Vertex parent[]) 
{ 
   Vertex v, w, v0, w0; link a;
   for (w = 0; w < G->V; w++) parent[w] = -1;
   parent[0] = 0; 
   while (1) {
      double minprice = INFINITO;
      for (v = 0; v < G->V; v++) 
         if (parent[v] != -1) 
            for (a = G->adj[v]; a != NULL; a = a->next)
               if (parent[a->w] == -1 && minprice > a->cost) {
                  minprice = a->cost;
                  v0 = v, w0 = a->w;
               }
      if (minprice == INFINITO) break; 
      /* A */
      parent[w0] = v0;
   }
}