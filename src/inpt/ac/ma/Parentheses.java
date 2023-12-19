package inpt.ac.ma;

public class Parentheses {
	private char elements[];
	private int tete;

	// implement stack
	
	public Parentheses(int n) {
		elements = new char[n];
		tete = -1;
	}

	// add elements to stack
	void empiler(char c) {
		if (tete == elements.length - 1) {
			return;
		}
		tete++;
		elements[tete] = c;
	}

	//  delete the last element added to stack and return it
	char supprimer() {
		if (estVide()) {
			System.out.println("Stack empty");
			return (char) 0;
		}
		char p;
		p = elements[tete];
		tete--;
		return p;
	}

	// verify if stack is Empty()
	boolean estVide() {
		if (tete == -1) {
			return true;
		} else {
			return false;
		}
	}

	// verify that () and {} are balanced(equilibrèe)
	public static Boolean checkValidity(String texte) {
		char symbole, precedent;
		Parentheses s = new Parentheses(texte.length());
		for (int i = 0; i < texte.length(); i++) {
			symbole = texte.charAt(i);
			if (symbole == '(' || symbole == '{' || symbole == '[') {
				s.empiler(symbole);
			}
			if (symbole == ')' || symbole == '}' || symbole == ']') {
				if (s.estVide()) {
					// System.out.println("False");
					return false;
				} else {
					precedent = s.supprimer();
					if (!isPairMatch(precedent, symbole)) {
						// System.out.println("False");
						return false;
					}
				}
			}

		}
		if (!s.estVide()) {
			// System.out.println("False");
			return false;
		}
		// System.out.println("True");
		return true;
	}

	// verify that () are matched ..
	//first param is the deleted ( and second is the closing )
	public static boolean isPairMatch(char character1, char character2) {
		if (character1 == '(' && character2 == ')') {
			return true;
		} else if (character1 == '{' && character2 == '}') {
			return true;
		} else if (character1 == '[' && character2 == ']') {
			return true;
		} else {
			return false;
		}
	}

}