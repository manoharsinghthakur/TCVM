package com.java.TCVM.service;

import java.util.Scanner;

public class InputScanner {
	private final Scanner scanner;

	public InputScanner() {
		this.scanner = new Scanner(System.in);

	}

	public InputScanner(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public String getString() {
		return scanner.next();
	}

	public int nextInt() {
		return scanner.nextInt();
	}

	public double getDouble() {
		return scanner.nextDouble();
	}
}
