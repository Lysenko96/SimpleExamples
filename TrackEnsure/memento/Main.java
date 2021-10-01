package te.lesson2.memento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		Snapshot snapshot = new Snapshot("name", "surname");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.obj"))) {
			oos.writeObject(snapshot);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.obj"))) {
			Snapshot snap = (Snapshot) ois.readObject();
			System.out.println(snap.getName());
			System.out.println(snap.getSurname());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
