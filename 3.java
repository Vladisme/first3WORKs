import java.io.*;
import java.util.zip.*;
import java.io.IOException;
public class Main2 {

    public static void main(String[] args) {

        String filename = "filename.txt";
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("output.zip"));
             FileInputStream fis = new FileInputStream(filename);) {
            ZipEntry entry1 = new ZipEntry("filename.txt");
            zout.putNextEntry(entry1);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zout.write(buffer);

            zout.closeEntry();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    try(ZipInputStream zin = new ZipInputStream(new FileInputStream("output.zip")))

    {
        ZipEntry entry;
        String name;
        long size;
        while ((entry = zin.getNextEntry()) != null) {

            name = entry.getName();

            System.out.printf("File name: %s \t \n", name);


            FileOutputStream fout = new FileOutputStream("new" + name);
            for (int c = zin.read(); c != -1; c = zin.read()) {
                fout.write(c);
            }
            fout.flush();
            zin.closeEntry();
            fout.close();
        }
    }
        catch(
    Exception ex)

    {

        System.out.println(ex.getMessage());
    }
        System.gc();
}
}
