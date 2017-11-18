package filRouge.v4;

public interface ModifiableSequentiellement<K, E> { 
	void changerReste(K reste);
	void changerTete(E tete);
}
