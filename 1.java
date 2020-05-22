import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
public class Main {
    public static void DiskFreeSpace() {
        Scanner sc = new Scanner(System.in);
        String Disk = sc.nextLine();
        File file = new File(Disk + ":");
        long totalSpace = file.getTotalSpace() / (1024 * 1024);
        long freeSpace = file.getFreeSpace() / (1024 * 1024);
        System.out.println("Disk " + Disk + ":");
        System.out.println("Total Space = " + totalSpace + " Mega Bytes");
        System.out.println("Free Space = " + freeSpace + " Mega Bytes");
    }

    public static void main(String[] args) {


        System.out.println("all available drives: ");
        FileSystemView fsv = FileSystemView.getFileSystemView();

        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println("Drive Letter: " + aDrive);
                System.out.println("\tType: " + fsv.getSystemTypeDescription(aDrive));
                System.out.println("\tTotal space: " + aDrive.getTotalSpace()/ (1024 * 1024)+" Mega Bytes");
                System.out.println("\tFree space: " + aDrive.getFreeSpace()/ (1024 * 1024)+" Mega Bytes");
                System.out.println();
            }
        }
        DiskFreeSpace();
    }
}
