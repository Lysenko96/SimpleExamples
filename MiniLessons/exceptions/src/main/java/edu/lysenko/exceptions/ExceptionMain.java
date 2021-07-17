package edu.lysenko.exceptions;

import java.io.*;
import java.util.logging.*;

class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	private static Logger LOG = Logger.getLogger(MyException.class.getName());

	MyException() {
//		StringWriter trace = new StringWriter();
//		printStackTrace(new PrintWriter(trace));
//		LOG.severe(trace.toString());
	}

	MyException(String msg) {
		super(msg);
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		LOG.severe(trace.toString());
	}

	void getTextMyException(MyException e) {
		e.printStackTrace(System.err);
	}
}

public class ExceptionMain {

	private static Logger LOG = Logger.getLogger(ExceptionMain.class.getName());

	void bar() throws MyException {
		System.out.println("throw MyException from bar()");
		throw new MyException();
	}

	void foo() throws MyException {
		System.out.println("throw MyException from foo()");
		throw new MyException("create in foo()");
	}

	public static void main(String[] args) {
		ExceptionMain main = new ExceptionMain();

		Object obj = null;

		try {
			main.bar();
		} catch (MyException e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			LOG.severe(trace.toString());
			// e.getTextMyException(e);
			// System.out.println("catch MyException");
		} finally {
			System.out.println("bar complete");
		}
		try {
			main.foo();
		} catch (MyException e) {
			// e.getTextMyException(e);
			System.out.println(e.getMessage());
		} finally {
			System.out.println("foo complete");
		}
		try {
			obj.toString();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("null catched");
		}
		try {
			int a[] = new int[1];
			System.out.println(a[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			LOG.severe(trace.toString());
			System.out.println("ArrayIndexOutOfBoundsException catch");
		}
		while (true) {
			try {
				throw new MyException();
			} catch (MyException e) {
				e.getTextMyException(e);
				System.out.println("catch");
				break;
			} finally {
				System.out.println("finally");
			}
		}
	}
}
