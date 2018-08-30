package com.java.TCVM.service;

import java.io.IOException;
import java.util.Scanner;

import com.java.TCVM.controller.TCVMMenu;

public class ReturningMainMenu {
	public void returnToMainMenu() throws IOException{
		//Scanner scanner = new Scanner(System.in);
		InputScanner scanner = new InputScanner();
		System.out.println("For Main Menu press 0");
		Integer number = scanner.nextInt();
		if(number==0){
			new TCVMMenu().showMenu();
		}
	}
}
