package com.book.effectivejava.juu.chapter2.item3.enumtype;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class EnumElvisSerialization {

	public static void main(String[] args) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
			out.writeObject(Elvis.INSTANCE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
			Elvis elvis3 = (Elvis)in.readObject();
			System.out.println(elvis3 == Elvis.INSTANCE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
