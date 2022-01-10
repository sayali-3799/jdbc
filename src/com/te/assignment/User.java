package com.te.assignment;

import java.util.Scanner;

public class User {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Multiplayer multiplayer = new Multiplayer();
		String option;
		String song;
		int count = 1;
		do{
			System.out.println("Type the option you want");
			System.out.println("->add\n->delete\n->play\n->search\n->display\n->exit");
			option = scanner.next();
			switch (option) {
			case "add":{
				System.out.println("Type the song you want to add ");
				scanner.nextLine();
				song = scanner.nextLine();
				multiplayer.add(song);
				break;
			}
			case "delete":{
				System.out.println("Type the song that you want to delete");
				scanner.nextLine();
				song = scanner.nextLine();
				multiplayer.delete(song);
				break;
			}
			case "play":{
				System.out.println("Type the song that you want to play");
				scanner.nextLine();
				song = scanner.nextLine();
				multiplayer.play(song,multiplayer);
				break;
			}
			case"display":{
				multiplayer.dispaly();
				break;
			}
			case"search":{
				System.out.println("Type the song that you want to search");
				scanner.nextLine();
				song = scanner.nextLine();
				multiplayer.search(song);
				break;
			}
			case"exit":
				count=0;
				break;
			default:
				System.out.println("Type the correct option");
				break;
			}
		}while(count != 0);
			
		
		}
		

	}


