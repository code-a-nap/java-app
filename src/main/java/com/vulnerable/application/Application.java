package com.vulnerable.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vulnerable.application.model.Developer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		Developer dev = new Developer("john", 32, false, "None :(", new String[] { "C", "C++", "Java" }, "Expert",
				"");
		FileOutputStream fileOut = new FileOutputStream("serialized");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(dev);
		out.close();
		fileOut.close();
		SpringApplication.run(Application.class, args);
	}

}
