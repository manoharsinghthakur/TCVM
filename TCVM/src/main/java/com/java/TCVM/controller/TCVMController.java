package com.java.TCVM.controller;

import java.io.IOException;

public class TCVMController {
	public static void main(String[] args) throws IOException {
		new ContainerInitializer().getContainerInstance();
		new TCVMMenu().showMenu();
	}
}
