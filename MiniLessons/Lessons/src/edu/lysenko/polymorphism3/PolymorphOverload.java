package edu.lysenko.polymorphism3;

public class PolymorphOverload {

	public static void main(String[] args) {
		Dog dog2 = new Dog(3);
		Animal animal = new Animal(6);
		Dog dog = new Dog();
		Cat cat = new Cat();
//		System.out.println(dog);
//		System.out.println(dog2);
//		System.out.println(dog.makeSound());
//		System.out.println(dog.makeSound(1));
//		System.out.println(dog);
		show(dog, 3);
		show(cat, 2);

		System.out.println(dog);
		System.out.println(cat);
	}

	static void show(Animal animal, int age) {
		System.out.println(animal.makeSound());
		System.out.println(animal.makeSound(age));
	}

	static void show(Animal animal) {
		System.out.println(animal.makeSound());
		System.out.println(animal.makeSound(Animal.getAge()));
	}
}

class Animal {

	private static int age;

	Animal() {
	}

	Animal(int age) {
		this.age = age;
	}

	void setAge(int age) {
		this.age = age;
	}

	static int getAge() {
		return age;
	}

	String makeSound() {
		return "";
	};

	String makeSound(int age) {
		return "";
	};

}

class Dog extends Animal {

	private int age;

	Dog() {
		super(getAge());
		age = getAge();
	}

	Dog(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [age = " + age + "]";
	}

	@Override
	String makeSound() {
		return "dog voice";
	}

	@Override
	String makeSound(int age) {
		this.age = age;
		return "dog voice " + age;
	}

}

class Cat extends Animal {

	private int age;

	Cat() {
		super(getAge());
		age = getAge();
	}

	Cat(int age) {
		this.age = age;
	}

	@Override
	String makeSound() {
		return "cat voice";
	}

	@Override
	String makeSound(int age) {
		this.age = age;
		return "cat voice " + age;
	}

	@Override
	public String toString() {
		return "Cat [age = " + age + "]";
	}

}
