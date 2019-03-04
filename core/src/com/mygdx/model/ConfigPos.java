package com.mygdx.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mygdx.outils.Pair;

public class ConfigPos {
	private static ConfigPos INSTANCE = null;
	@SuppressWarnings("rawtypes")
	//private static HashMap<Class, ArrayList> elements = new HashMap<Class, ArrayList>();
	private static ArrayList<Pair> elements = new ArrayList<Pair>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				elements.add(new Pair(tab_info[0],donnees.clone()));
				donnees.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println(elements.toString());
		
	}
	
	public static ConfigPos getInstance() throws Exception {
		if(INSTANCE == null)
			INSTANCE = new ConfigPos();
		return INSTANCE;
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Pair> getElements(){
		return elements;
	}
	
	public static void reset() {
		INSTANCE = null;
	}
}
