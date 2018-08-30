package com.java.TCVM;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.service.InputScanner;

@RunWith(MockitoJUnitRunner.class)
public class TCVMMenuTest {

	@InjectMocks
	TCVMMenu tcvmMenu;
	
	@Mock
	InputScanner inputScanner;
	@Test
	public void shouldCheckSwitchCaseOneMakeTea() throws IOException {
		Mockito.when(inputScanner.nextInt()).thenReturn(1);
		tcvmMenu.showMenu();
	}

}
