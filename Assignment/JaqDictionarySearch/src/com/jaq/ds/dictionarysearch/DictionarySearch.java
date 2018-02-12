package com.jaq.ds.dictionarysearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DictionarySearch {

	public static void main(String[] args) {
		Map<String, String> pwds = new HashMap<String, String>();
		pwds.put("test", "YWR2YW50YWdlb3VzbmVzcw==");
		pwds.put("test2", "c2ltbWVyaW5n");
		List<String> sl = execute(pwds);
		for (String s : sl) {
			System.out.print(s+"\n");
		}

	}
	
	public static List<String> execute(Map<String, String> pwds) {
		List<String> list = new ArrayList<String>();
		try {
			
			File fin = new File("src/dictionary.0");
			FileInputStream fis = new FileInputStream(fin);

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				Iterator pwd_it = pwds.entrySet().iterator();
				while (pwd_it.hasNext()) {
					Map.Entry pair = (Map.Entry) pwd_it.next();
					String ac = pair.getKey().toString();
					byte[] decodedBytes = Base64.getDecoder().decode(pair.getValue().toString());

					String ap = new String(decodedBytes);

					if (ap.equals(line)) {
						list.add(ac + "'s password is '" + line + "'");
					}

					String reversed_line = new StringBuilder(line).reverse().toString();
					if (ap.equals(reversed_line)) {
						list.add(ac + "'s password is '" + reversed_line + "'");
					}

					String line_wo_vowels = line.replaceAll("[AEIOUaeiou]", "");
					if (ap.equals(line_wo_vowels)) {
						list.add(ac + "'s password is '" + line_wo_vowels + "'");
					}
				}
			}
		} catch (IOException e) {
			list.add("Error occured during the print out of the DA: " + e.getMessage());
		}
		return list;
	}

}
