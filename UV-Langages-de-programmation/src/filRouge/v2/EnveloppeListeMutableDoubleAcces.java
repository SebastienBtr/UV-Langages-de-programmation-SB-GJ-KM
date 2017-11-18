package filRouge.v2;

import java.util.Iterator;

/*
 * Implem mutable
 */

public class EnveloppeListeMutableDoubleAcces<E> implements FileMutable<E> {

	private ListeMutable<E> liste; // liste complète
	private ListeMutable<E> fin;// sous-liste suffixe d'un élément ou *
	// Invariant :
	// - si liste complète vide, alors fin non spécifié
	// - sinon : suffixe contenant le dernier élément

	private int taille;

	public EnveloppeListeMutableDoubleAcces() {
		this.liste = ListeMutable.vide();
		this.fin = null;
		this.taille = 0;
	}

	@Override
	public E premier() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.liste.tete();
	}

	@Override
	public int taille() {
		return this.taille;
	}


	@Override
	public void ajouter(E element) {
		if (this.estVide()) {
			ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.liste);
			this.liste = nouvelElement;
			this.fin = nouvelElement;
			this.taille++;
			return;
		}
		ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.fin.reste());
		this.fin.changerReste(nouvelElement);
		this.fin = nouvelElement;
		this.taille++;
	}

	@Override
	public void retirer() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		this.liste = this.liste.reste();
		this.taille--;
	}

	@Override
	public FileMutable<E> creer() {
		return new EnveloppeListeMutableDoubleAcces<>();
	}
	
	@Override
	public FileMutable<E> creerCopie() {
		FileMutable<E> file = creer();
		return file.ajout(this);
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurListe<>(this.liste);
	}
	
	@Override
	public void ajouter(File<E> secondeFile) {
		if(secondeFile.estVide())
			return;
		if(secondeFile instanceof EnveloppeListeMutableDoubleAcces<?>){
			EnveloppeListeMutableDoubleAcces<E> file = (EnveloppeListeMutableDoubleAcces<E>)secondeFile;
			this.fin.changerReste(file.liste);
			this.fin = file.fin;
			return;
		}
		for(E e : secondeFile){
			this.ajouter(e);
		}
	}

	@Override
	public String toString() {
		return this.representation();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof File<?>)){
			return false;
		}
		try{
			@SuppressWarnings("unchecked")
			File<E> file = (File<E>)obj;
			return this.estEgal(file);
		}catch(ClassCastException e){
			return false;
		}
	}

}
