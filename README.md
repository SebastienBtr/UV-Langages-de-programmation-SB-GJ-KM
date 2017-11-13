# UV-Langages-de-programmation-SB-GJ-KM
TP pour l'UV de programmation réalisé par :
Killian Mer, Gaetan Jacquet, Sébastien Bouttier.
# Convention de Nommage et de Tests
Nous avons utilisé la norme Java pour le nommage des classes, des attributs ainsi que des méthodes.
Tout a été rédigé en anglais.
Au niveau des tests, nous nous sommes mis d'accord pour avoir output le plus lisible possible pour pouvoir cibler rapidement les erreurs.
En effet, on utilise un compteur qui recense chaque cas de test. Le résultat nous est affiché sous la forme 5/5 (5 cas validés sur 5 essais).
Lorsqu'il y a une erreur, un message personnalisé s'affiche afin de cibler l'erreur.

Exemple : 

           --TestConstructor--
           Error : First non null 
           Result : 2/3
# Compléxité du Programme
Pour ce qui est de la compléxité, les opérations sur la file mutable FIFO est de O(1).
En effet, lorsqu'on appelle les méthodes pour récupérer un élément (popElem) ou pour ajouter un élément (pushElem), on connait l'élément concerné ce qui fait  que l'on a directement accés à l'élément voulu (Aucun parcours de la liste).

On a donc une compléxité constante.