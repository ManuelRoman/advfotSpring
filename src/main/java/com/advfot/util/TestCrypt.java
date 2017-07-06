package com.advfot.util;

import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("ana"));
		Random random = new Random();
		for(int i=0; i<=100; i++){
			int idFotSelec = random.nextInt((10 - 1) + 1) + 1;
			System.out.println(idFotSelec);
		}
	}

}
