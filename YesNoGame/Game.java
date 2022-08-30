package YesNoGame;

import java.io.IOException;
import java.util.Scanner;

public class Game {
	static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public static char getResponse() {
		System.out.println("ketikkan 'y' or 'n' ");
		char answer = scanner.next(".").charAt(0);
		scanner.nextLine();
		return answer;
	
	}
	
	public static void clearScreen() {
		try {
			(new ProcessBuilder(new String[] {"cmd", "/c", "cls"})).inheritIO().start().waitFor();
		} catch (InterruptedException var1) {
			var1.printStackTrace();
		} catch (IOException var2) {
			var2.printStackTrace();
		}
	
	}
	public static void displayMenu() {
		System.out.println("ketik k untuk keluar");
		System.out.println("ketik s untuk simpan");
		System.out.println("ketik l unutk load");
		System.out.println("ketik a untuk load pertanyaan animal");
		System.out.println("ketik d untuk view tree");
		System.out.println("ketik karakter lain untuk memulai game");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PertanyaanLengkap game = new PertanyaanLengkap();
		game.addFirstQuestion("Apakah Hewannya Mamalia", "Anjing", "Ikan");
		clearScreen();
		displayMenu();
		char input = scanner.next(".").charAt(0);
		
		do {
			if (input == 'l') {
				game = PertanyaanLengkap.loadGame();
				game.startGame();
				displayMenu();
				input = scanner.next(".").charAt(0);
			} else if (input == 's') {
				PertanyaanLengkap.saveGame(game);
				game.startGame();
				displayMenu();
				input = scanner.next(".").charAt(0);
			} else if (input == 'd') {
				PertanyaanLengkap.printBinaryTree(game.firstQuestion, 0);
				game.startGame();
				displayMenu();
				input = scanner.next(".").charAt(0);
			} else if (input == 'a') {
				PertanyaanLengkap.loadAnimalGame();
				game.startGame();
				displayMenu();
				input = scanner.next(".").charAt(0);
			} else if (!game.currentQuestion.isQuestion) {
				System.out.println("apakah itu" + game.currentQuestion.question);
				input = getResponse();
				if (input == 'y') {
					System.out.println("aku tahu segalanya");
					game.startGame();
					displayMenu();
				} else {
					addNewQuestion(game);
					game.startGame();
					displayMenu();
				}
			} else {
				System.out.println(game.ask());
				input = getResponse();
				game.nextQuestion(input == 'y');
		
			}
			
		} while (input != 'k');
		System.out.println("Game Over");
		scanner.close();
	}
	public static void addNewQuestion(PertanyaanLengkap game) {
		System.out.println("Saya pikir saya tahu segalanya!");
		System.out.println("Katakan padaku apa itu?");
		String newAnswer = scanner.nextLine();
		System.out.println("Pertanyaan yes or no apa yang akan Anda tanyakan tentang " + newAnswer);
		String.newQuestion = scanner.nextLine();
		System.out.println("Apakah jawaban Anda alah y atau n untuk pertanyaan ini?");
		char input = getResponse();
		game.addNewQuestion(newQuestion, newAnswer, input == 'y');
	}
}
