package com.mygdx.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConfigPos {
	private static ConfigPos INSTANCE = null;
	@SuppressWarnings("rawtypes")
	//private static HashMap<Class, ArrayList> elements = new HashMap<Class, ArrayList>();
	private static HashMap<String, ArrayList> elements = new HashMap<String, ArrayList>();
	
	@SuppressWarnings("unchecked")
	ConfigPos(){
		File fp = new File("position.txt");
		BufferedReader br = null;
		ArrayList<Float> donnees = new ArrayList<Float>();
		
		try {
			br = new BufferedReader(new FileReader(fp));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line;
		String[] tab_info;
		
		try {
			while((line = br.readLine())!= null) {
				tab_info = line.split(" ");
				System.out.println(line);
				System.out.println(tab_info[0]);
				for(int i = 1; i < tab_info.length; i++) {
					donnees.add(Float.valueOf(tab_info[i]));
				}
				System.out.println(donnees.toString());
				
				
				//elements.put(Class.forName("com.mygdx.model."+tab_info[0]), (ArrayList<Float>) donnees.clone());
				elements.put(tab_info[0], (ArrayList<Float>) donnees.clone());
				donnees.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		System.out.println(elements.toString());
		
	}
	
	public static ConfigPos getInstance() throws Exception {
		if(INSTANCE == null)
			INSTANCE = new ConfigPos();
		return INSTANCE;
	}
	
	/*
	@SuppressWarnings("rawtypes")
	public HashMap<Class, ArrayList> getElements(){
		return elements;
	}
	*/
	
	public HashMap<String, ArrayList> getElements(){
		return elements;
	}
	
	public static void reset() {
		INSTANCE = null;
	}
}
