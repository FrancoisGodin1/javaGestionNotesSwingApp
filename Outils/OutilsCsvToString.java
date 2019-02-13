package Outils;

import java.io.*;

public class OutilsCsvToString {

    public static String loadFile(String file) throws IOException{

        String fileContent="";
        try {
            File f = new File(file);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line = br.readLine();

                while (line != null) {
                    fileContent = fileContent + line + "\n";
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException exception) {
                System.out.println("Error reading file : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("file doesn't exists");
        }
        return fileContent;
    }

    public static String extractLine(String data, int num){
        String[] lines = data.split("\n");
        return lines[num];
    }

    public static String extractValue(String line, int column){
        String[] values = line.split("\t");
        return values[column];
    }

    public static int nbLines(String data){
        String[] lines = data.split("\n");
        return lines.length;
    }
}
