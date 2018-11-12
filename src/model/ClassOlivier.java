package model;

public class ClassOlivier {
	private String unePhrase = "", firstPart = "", secondPart = "";
	private int charToDelete;
	private boolean canBeDeleted;
	
	
	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);

		return new String(bs).trim();
	}
	

	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	
	//Ask the user to write a sentence
	public void askSentence() throws Exception {
		System.out.println("Veuillez �crire une phrase svp.");
		unePhrase = getInputString();
	}
	
	
	//See if the character's position can be deleted
	public void canBeDelete(int chara) {
		if(chara <= unePhrase.length()) {
			canBeDeleted = true;
		}else {
			System.out.println("La position du caract�re n'est pas dans la longueur de la phrase");
			canBeDeleted = false;
		}
	}
	
	
	//Ask the user which character of previous sentence he wants to delete
	public void characterToDelete() throws Exception {
		System.out.println("Quel caract�re de votre phrase voulez-vous supprimer ?");
		charToDelete = getInputInt();
		canBeDelete(charToDelete);
		if(canBeDeleted) {
			firstPart = unePhrase.substring(0, charToDelete-1);
			secondPart = unePhrase.substring(charToDelete, unePhrase.length());
		}
		unePhrase = firstPart+""+secondPart;
		System.out.println(unePhrase);
	}
}
