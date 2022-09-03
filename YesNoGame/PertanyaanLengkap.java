package YesNoGame;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class PertanyaanLengkap implements Serializable {
	private static final long serialVersionUID = 1L;
	static String path ="";
	Pertanyaan firstQuestion;
	Pertanyaan currentQuestion;
	int noOfQuestion = 0;
	
	
	
	
	public Pertanyaan getCurrentQuestion() {
		return this.currentQuestion;
	}
	
	public void startGame() {
		this.currentQuestion = this.firstQuestion;
	}
	
	public boolean isQuestionAnswer() {
		return !this.currentQuestion.isQuestion;
	}
	
	public boolean isEmpty() {
		return this.firstQuestion == null;
	}
	
	public String ask() {
		return this.currentQuestion.question;
	}
	
	public Pertanyaan nextQuestion(boolean isYes) {
		if (isYes) {
			this.currentQuestion = this.currentQuestion.yes;
		} else {
			this.currentQuestion = this.currentQuestion.no;
		}
		return this.currentQuestion;
	}
	
	public void addNewQuestion(String question, String answer, Boolean isYes) {
		Pertanyaan newQuestion = new Pertanyaan();
		newQuestion.question = question;
		newQuestion.isQuestion = true;
		newQuestion.parent = this.currentQuestion.parent;
		newQuestion.parentYesResponse = this.currentQuestion.parentYesResponse;
		Pertanyaan newAnswer = new Pertanyaan();
		newAnswer.isQuestion = false;
		newAnswer.question = answer;
		newAnswer.parent = newQuestion;
		if(isYes) {
			newQuestion.yes = newAnswer;
			newQuestion.no = this.currentQuestion;
			newAnswer.parentYesResponse = true;
			this.currentQuestion.parentYesResponse = false;
			this.currentQuestion.parent = newQuestion;
		} else {
			newQuestion.no = newAnswer;
			newQuestion.yes = this.currentQuestion;
			newAnswer.parentYesResponse = false;
			this.currentQuestion.parentYesResponse = true;
			this.currentQuestion.parent = newQuestion;
		}
		if(newQuestion.parentYesResponse) {
			newQuestion.parent.yes = newQuestion;
		} else {
			newQuestion.parent.no = newQuestion;
		}
	}
	
	public void displayTree(Pertanyaan root) {
		if (root != null) {
			this.displayTree(root.no);
			System.out.print(" " + root.question);
			this.displayTree(root.yes);
		}
	}
	public static void printBinaryTree(Pertanyaan root, int level) {
		if (root != null) {
			printBinaryTree(root.yes, level + 1);
			if (level != 0) {
				for (int i = 0; i < level - 1; i++) {
					System.out.print("|\t");
				}
				System.out.println(" |-------" + root.question);
			} else {
				System.out.println(root.question);
			}
			printBinaryTree(root.no, level + 1);
		}
	}
	public static String getPath() {
		CodeSource codeSource = Game.class.getProtectionDomain().getCodeSource();
		File jarFile = null;
		
		try {
			
			
				
			
			jarFile = new File(codeSource.getLocation().toURI().getPath());
		} catch (URISyntaxException var3) {
			var3.printStackTrace();
		}
		String jarDir= jarFile.getParentFile().getPath();
		return jarDir;
	}
	
	public static void saveGame(PertanyaanLengkap game) throws IOException {
		path = getPath() + "\\game.ser";
		fileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(game);
		oos.close();
	}
	public static PertanyaanLengkap loadGame() throws IOException, ClassNotFoundException {
		path = getPath() + "\\game.ser";
		new PertanyaanLengkap();
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		PertanyaanLengkap newGame = (PertanyaanLengkap)ois.readObject(); //ois.close();
		return newGame;
	}
	public static PertanyaanLengkap loadAnimalGame() throws IOException, ClassNotFoundException {
		path = getPath() + "\\Aminal.ser";
		new PertanyaanLengkap();
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		PertanyaanLengkap newGame = (PertanyaanLengkap)ois.readObject(); //ois.close();
		return newGame;
	}
	public void addFirstQuestion(String question, String yesAnswer, String noAnswer) {
		Pertanyaan newQuestion = new Pertanyaan();
		newQuestion.question = question;
		newQuestion.isQuestion = true;
		Pertanyaan newYesAnswer = new Pertanyaan();
		newYesAnswer.isQuestion = false;
		newYesAnswer.question = yesAnswer;
		newYesAnswer.parent = newQuestion;
		newYesAnswer.parentYesResponse = true;
		Pertanyaan newNoAnswer = new Pertanyaan();
		newNoAnswer.isQuestion = false;
		newNoAnswer.question = noAnswer;
		newNoAnswer.parent = newQuestion;
		newNoAnswer.parentYesResponse = false; //newNoAnswer.yes = newYesAnswer; newNoAnswer.no = newNoAnswer;
		this.currentQuestion = newQuestion;
		this.firstQuestion = newQuestion;
	
	}
	public void askQuestion() {
		
	}
}

