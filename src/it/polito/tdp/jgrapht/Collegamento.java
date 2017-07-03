package it.polito.tdp.jgrapht;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Collegamento extends DefaultWeightedEdge {
	
	int linea;
	
	public Collegamento(){
		super();
	}
	
	public Collegamento(int linea){
		this.linea = linea;
	}

	/**
	 * @return the linea
	 */
	public int getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(int linea) {
		this.linea = linea;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Linea: "+linea;
	}

}
