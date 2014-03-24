package com.kpfu.itis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task10 {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// Step 1: Get classLoader
		ClassLoader myClassLoader = Task10.class.getClassLoader();

		// Step 2: Define a class to be loaded.
		String classNameToBeLoaded = "Task10";

		// Step 3: Load the class
		Class c = myClassLoader.loadClass(classNameToBeLoaded);

		// Step 4: create a new instance of that class
		Object whatInstance = c.newInstance();

		// get package name
		Package p = c.getPackage();
		if (p != null) {
			System.out.println("package " + p.getName() + ";");
		} else {
			System.out.println("Package is not defined(i.e. default)");
		}

		// print class name
		System.out.print("class " + c.getSimpleName() + " ");

		// print superclass name
		System.out.print("extends " + c.getSuperclass().getSimpleName() + " ");

		// print implemented interfaces
		Class[] interfaces = c.getInterfaces();
		for (int i = 0, size = interfaces.length; i < size; i++) {
			System.out.print(i == 0 ? "implements " : ", ");
			System.out.print(interfaces[i].getSimpleName());
		}

		System.out.println(" {");

		// print class fields
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("\t" + getModifiers(field.getModifiers())
					+ getType(field.getType()) + " " + field.getName() + ";");
		}

		// print constructors
		Constructor[] constructors = c.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.print("\t" + getModifiers(c.getModifiers())
					+ c.getSimpleName() + "(");
			System.out.print(getParameters(constructor.getParameterTypes()));
			System.out.println(") { }");
		}
		
		
		// print methods
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			Annotation[] annotations = m.getAnnotations();
			System.out.print("\t");
			for (Annotation a : annotations)
				System.out.print("@" + a.annotationType().getSimpleName() + " ");
			System.out.println();
			
			System.out.print("\t" + getModifiers(m.getModifiers()) +
					getType(m.getReturnType()) + " " + m.getName() + "(");
			System.out.print(getParameters(m.getParameterTypes()));
			System.out.println(") { }");
		}
		
		System.out.println("}");
		System.out.println();
		
		System.out.print("Setting up the right task number... ");
		Method setMethod = c.getMethod("setTaskNumber", new Class[] { int.class });
		setMethod.invoke(whatInstance, 10);
		System.out.println(" Ok");
		
		System.out.println("Launching required methods...");
		
		
		Method doneMethod = c.getMethod("done", null);
		doneMethod.invoke(whatInstance, null);
		
	}
	

	private static String getParameters(Class[] params) {
		String p = "";
		for (int i = 0, size = params.length; i < size; i++) {
			if (i > 0)
				p += ", ";
			p += getType(params[i]) + " param" + i;
		}
		return p;
	}

	// return field/class modifiers as String
	private static String getModifiers(int m) {
		StringBuilder modifiers = new StringBuilder();
		if (Modifier.isPublic(m))
			modifiers.append("public ");
		if (Modifier.isProtected(m))
			modifiers.append("protected ");
		if (Modifier.isPrivate(m))
			modifiers.append("private ");
		if (Modifier.isStatic(m))
			modifiers.append("static ");
		if (Modifier.isAbstract(m))
			modifiers.append("abstract ");
		return modifiers.toString();
	}

	static String getType(Class clazz) {
		String type = clazz.isArray() ? clazz.getComponentType()
				.getSimpleName() : clazz.getSimpleName();
		if (clazz.isArray())
			type += "[]";
		return type;
	}
}
