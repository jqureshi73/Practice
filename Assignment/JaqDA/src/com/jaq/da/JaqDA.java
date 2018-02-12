package com.jaq.da;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jaq.ds.dictionarysearch.DictionarySearch;

public class JaqDA {

	public static void main(String[] args) {
		try {
			File pwd_file = new File("src/pwd.txt");
			FileInputStream pwd_stream = null;

			pwd_stream = new FileInputStream(pwd_file);

			BufferedReader pwd_buffer = new BufferedReader(new InputStreamReader(pwd_stream));

			Map<String, String> pwds = new HashMap<String, String>();

			String pwd_file_line = null;
			while ((pwd_file_line = pwd_buffer.readLine()) != null) {
				String[] splited = pwd_file_line.split("\\s+");
				if (splited[0] != null) {
					pwds.put(splited[0], splited[1]);
				}
			}

			pwd_buffer.close();
			if (pwds != null && pwds.size()>0) {
			  List<String> sl = DictionarySearch.execute(pwds);
			  for (String s : sl) {
				System.out.print(s+"\n");
			  }
			}
			
		} catch (IOException e) {
			System.out.print("Error occured during the print out of the DA: " + e.getMessage());
		}
	}
}
