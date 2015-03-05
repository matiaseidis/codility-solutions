package other;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;


public class ExternalMergeSortTest {

    public static void main(String[] args) throws Exception {
        String pathDir = "/home/us/mergesort";
        String fileName = "source";

        File source = setup(pathDir, fileName);

        System.out.println("source created: "+source.length()/1024+" MB");
        long availableMemBytes = source.length()/12;
        System.out.println("availableMem: "+availableMemBytes/1024 + " MB");

        Comparator<String> comp = (a,b) -> {
            String[] thisSplit = a.split("-");
            String[] oSplit = b.split("-");
            Integer thisI = Integer.valueOf(thisSplit[thisSplit.length-1]);
            Integer oI = Integer.valueOf(oSplit[oSplit.length-1]);
            return thisI.compareTo(oI);
        };

        new ExternalMergeSort().sort(source.getAbsolutePath(), pathDir + "/result", availableMemBytes, comp);
        System.out.println("sort completed");
    }

    private static File setup(String pathDir, String fileName)
            throws IOException {
        File sourceDir = new File(pathDir);
        if(sourceDir.exists())
            for(File f : sourceDir.listFiles())
                f.delete();
        else
            sourceDir.mkdir();


        File source = new File(sourceDir, fileName);
        if(source.exists())
            source.delete();
        source.createNewFile();

        BufferedWriter br = new BufferedWriter(new FileWriter(source)) ;
        int lines = 5000000;
        for(int i = lines; i>0; i--) {
            br.write("line-"+i);
            br.newLine();
        }
        br.close();
        return source;
    }

}