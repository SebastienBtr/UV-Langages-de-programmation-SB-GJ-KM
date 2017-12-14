package filRouge.v6;

import java.util.Iterator;

public class FileImmutableAvecEtatReifie<E> implements FileImmutable<E> {
	private EtatFileImmutable<E> etat;
	
	public FileImmutableAvecEtatReifie(EtatFileImmutable<E> etat) {
		super();
		this.etat = etat;
	}

	public FileImmutable<E> creerAvecEtat(EtatFileImmutable<E> etat){
		return new FileImmutableAvecEtatReifie<>(etat);
	}
	
	@Override
	public E premier() {
		return this.etat.premier();
	}

	@Override
	public FileImmutable<E> suivants() {
		return this.creerAvecEtat(etat.suivants());
	}


	@Override
	public int taille() {
		return this.etat.taille();
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		return this.creerAvecEtat(this.etat.creer(dernier));
	}

	@Override
	public FileImmutable<E> creer() {	
		return this.creerAvecEtat(this.etat.creer());
	}

	@Override
	public Iterator<E> iterator() {
		return this.etat.iterator();
	}
	
	@Override
	public boolean equals(Object obj){
		return this.etat.equals(obj);
	}
	@Override
	public String toString() {
		return this.etat.toString();
	}		
	
}
