package com.java.TCVM;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.InputScanner;

@RunWith(MockitoJUnitRunner.class)
public class InputScannerTest {

	@Test
	public void getInputInteger() {
		String input = "5";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);

		InputScanner inputScanner = new InputScanner();
		Integer s = inputScanner.nextInt();

		assertEquals(new Integer(5), s);
	}

}
