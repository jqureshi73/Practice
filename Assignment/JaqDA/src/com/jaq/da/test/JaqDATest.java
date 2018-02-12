package com.jaq.da.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JaqDATest {

	@Test
	void test() {
		try {
		File pwd_file = new File("src/pwd.txt");
		assertTrue(pwd_file.exists());
		
		FileInputStream pwd_stream = null;
			pwd_stream = new FileInputStream(pwd_file);
		assertTrue(pwd_stream != null);

		BufferedReader pwd_buffer = new BufferedReader(new InputStreamReader(pwd_stream));
		assertTrue(pwd_buffer != null);
		
		Map<String, String> pwds = new HashMap<String, String>();
		
		assertTrue(pwds != null);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		

}
