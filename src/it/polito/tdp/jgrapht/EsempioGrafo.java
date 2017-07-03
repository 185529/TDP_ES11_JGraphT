package it.polito.tdp.jgrapht;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleGraph;

public class EsempioGrafo {

	/*
	 * non diretto, semplice, non pesato
	 */
	void esempio1(){
		
		// creazione grafo
		
		UndirectedGraph<Integer, DefaultEdge> grafo = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		
		// popolamento vertici
		
		for(int i=1; i<=6; i++){
			grafo.addVertex(i);
		}
		
		// popolamento archi
		
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(1, 3);
		
		grafo.addEdge(5, 6);
				
	}
	
	/*
	 * diretto, multigrafo, pesato
	 */
	void esempio2(){
		
		// creazione grafo
		
		DirectedWeightedMultigraph<Integer, DefaultWeightedEdge> grafo = new DirectedWeightedMultigraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
			
		// popolamento vertici
			
		for(int i=1; i<=6; i++){
			grafo.addVertex(i);
		}
			
		// popolamento archi
			
		grafo.setEdgeWeight(grafo.addEdge(1, 2), 0.5);
		grafo.setEdgeWeight(grafo.addEdge(2, 3), 0.5);
		grafo.setEdgeWeight(grafo.addEdge(1, 3), 0.5);
		
		grafo.setEdgeWeight(grafo.addEdge(5, 6), 0.5);
		grafo.setEdgeWeight(grafo.addEdge(5, 6), 0.5);	// multigrafo - posso avere archi multipli
		
		System.out.println("Esempio 2:\n");
		
		// itero sugli archi per stampare nodi e pesi pesi
		
		for(DefaultWeightedEdge arch : grafo.edgeSet()){
			System.out.println("("+grafo.getEdgeSource(arch)+" | "+grafo.getEdgeTarget(arch)+") ---> "+grafo.getEdgeWeight(arch));			
		}
		
		// itero sui nodi
		
		for(Integer vertex : grafo.vertexSet()){
			
			System.out.println(vertex);
			
			for(DefaultWeightedEdge arch : grafo.edgesOf(vertex)){
				
				System.out.println("-- Adiacent vertex: "+Graphs.getOppositeVertex(grafo, arch, vertex));
				
				if(grafo.getEdgeSource(arch)==vertex){
					
					System.out.println("Adiacent vertex: "+grafo.getEdgeTarget(arch));
					
				}else{
					
					System.out.println("Adiacent vertex: "+grafo.getEdgeSource(arch));
					
				}
				
			}
			
			System.out.println("In-degree: "+grafo.inDegreeOf(vertex)+" | Out-degree: "+grafo.outDegreeOf(vertex));
			
		}
		
		// lista dei vicini
		
		System.out.println("\nNeighbor list of 3:\n"+Graphs.neighborListOf(grafo, 3));
		
		System.out.println("\nPredecessor list of 3:\n"+Graphs.predecessorListOf(grafo, 3));
		
		System.out.println("\nSuccessor list of 3:\n"+Graphs.successorListOf(grafo, 3));
		
	}
	
	public static void main(String[] args) {

		EsempioGrafo eg = new EsempioGrafo();
		
		eg.esempio1();
		eg.esempio2();
		
	}

}
