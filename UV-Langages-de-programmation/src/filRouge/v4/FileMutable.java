package filRouge.v4;

public interface FileMutable<E> extends 
	File<FileMutable<E>, E>,
	ModifiableElementairementEnPlace<E>, 
	Copiable<FileMutable<E>>,
	RepresentableParIteration<E>, IdentifiableParIteration<FileMutable<?>, E>
{
	/*
	 * Accesseurs
	 */
	@Override
	default FileMutable<E> reste() {
		FileMutable<E> r = creerCopie();
		r.retirer();
		return r;
	}

	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E e) {
		this.ajouter(e);
		return this;
	}

	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}

}
