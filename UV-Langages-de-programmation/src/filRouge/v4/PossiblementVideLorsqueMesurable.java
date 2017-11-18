package filRouge.v4;

public interface PossiblementVideLorsqueMesurable extends PossiblementVide, Mesurable {
	default boolean estVide() {
		return this.taille() == 0;
	}
}
