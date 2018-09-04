package com.java.TCVM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.InputScanner;

@RunWith(MockitoJUnitRunner.class)
public class InputScannerTest {

	@Test
	public void shouldReturnInteger() {
		/*Scanner mockScanner = mock(Scanner.class);
		
		when(mockScanner.nextInt()).thenReturn(5);
		*/
		InputScanner inputScanner = new InputScanner();
		//inputScanner.nextInt();
		//Assert.assertEquals(5, inputScanner.nextInt());
	}

}
