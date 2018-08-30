package com.java.TCVM.controller;

import java.io.IOException;

import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.makeImpl.MakeTea;

public class TCVMController {
	public static void main(String[] args) throws IOException {
		new ContainerInitializer().getContainerInstance();
		//new TCVMMenu().showMenu();
		new TCVMMenu(new InputScanner(),new MakeTea()).showMenu();;
	}
}
