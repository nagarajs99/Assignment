package com.nithya.assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Month;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {

	public static void main(String[] args) {
		
		//I am using default directory for the task
		String workingDirectory = System.getProperty("user.dir");

		File directoryPath = new File(workingDirectory);
		File files[] = directoryPath.listFiles();
		Map<Integer, Integer> count = new TreeMap<>();

		for (int i = 0; i < files.length; i++) {
			
			Path path =  Paths.get(files[i].getAbsolutePath());

			BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);			
			
			try {
				
				Date createDate =  new Date(view.readAttributes().creationTime().toMillis());
				
				Integer month = createDate.getMonth();
				
					
					if( count.containsKey(month)) {
						
						Integer value = count.get(month);
						count.put(month, value+1);
						
					}else {
					
					count.put(month, 1);
					
					}

					
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		count.forEach((key, value) -> {
			
			System.out.println( Month.of(key).name() + " : " + value);
			
		});

	}
}
