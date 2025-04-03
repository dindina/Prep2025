package threads;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRead {


    public static List<String> readFilesParallel(List<String> filePaths) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        List<String> fileContents = new ArrayList<>();
        List<StringBuilder> fileBuilders = new ArrayList<>();

        for(int i= 0 ; i < filePaths.size() ; i++){
            String filePath = filePaths.get(i);
            Thread th1 = new Thread( () ->{
                try {
                    BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
                    String line;
                    StringBuilder sbr = new StringBuilder();
                    fileBuilders.add(sbr);
                    while (true) {
                        if (!((line = br.readLine()) != null)) break;

                        sbr.append(line);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            threads.add(th1);
        }

        for(Thread th : threads){

            th.start();
        }

        for(Thread th : threads){

            th.join();
        }

        for(StringBuilder s : fileBuilders){

            fileContents.add(s.toString());
        }

        return fileContents;

    }

    public static void main(String[] args) throws InterruptedException {

        List<String> filesToRead = new ArrayList<>();
        filesToRead.add("/Users/dinesh/Solution.txt");
        //filesToRead.add("/Users/dinesh/Solution.txt");
        //filesToRead.add("/Users/dinesh/Solution.txt");

        List<String> contents = readFilesParallel(filesToRead);

        for (int i = 0; i < contents.size(); i++) {
            System.out.println("Content of " + filesToRead.get(i) + ":\n" + contents.get(i));
            System.out.println("-------------------------");
        }
    }
    public static void testTwoFiles() {
         final StringBuilder file1Content = new StringBuilder("");
         final StringBuilder file2Content = new StringBuilder("");



        Thread thread1 = new Thread(()->{

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("/Users/dinesh/Solution.txt")));
                String line;

                while( (line = br.readLine()) != null){
                    file1Content.append(line);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thread2 = new Thread(()->{

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("/Users/dinesh/Solution.txt")));
                String line;

                while( (line = br.readLine()) != null){
                    file2Content.append(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Threads interrupted: " + e.getMessage());
        }

        // Print the file contents after threads are finished
        System.out.println("File 1 Content:\n" + file1Content);
        System.out.println("\nFile 2 Content:\n" + file2Content);


    }
}
