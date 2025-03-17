import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //membuat directory
        File f = new File("memo");
        if (f.mkdir()) {
            System.out.println("File Created");
        } else {
            System.out.println("File Already Exist");
        }
        while (true){
            //display
            System.out.println("1.Buka memo\n2.Tambah Memo\n3.Edit Memo\n4.Hapus Memo");
            Scanner Action = new Scanner(System.in);
            System.out.print("pilih (1-4):");

            int inp_action = Action.nextInt();
            Action.nextLine();
            if (inp_action == 1) {
                System.out.println("buka memo");

                //membaca isi file
                System.out.println("Memo yang ada:");
                File file1 = new File("memo/");
                File[] files = file1.listFiles();
                if (null != files) {
                    for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
                        String ss = files[fileIntList].toString();
                        if (null != ss && ss.length() > 0) {
                            System.out.println("Memo: " + (fileIntList + 1) + " :" + ss.substring(ss.lastIndexOf("\\") + 1, ss.length()));
                        }
                    }
                }
                System.out.println("masukan nama file yang ingin dibaca:");
                String nama_file = Action.nextLine();
                String fileName = "memo/"+nama_file+".txt" ;
                try {
                    // membaca file
                    File myFile = new File(fileName);
                    Scanner fileReader = new Scanner(myFile);

                    // cetak isi file
                    while(fileReader.hasNextLine()){
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Terjadi Kesalahan: " + e.getMessage());
                    e.printStackTrace();
                }
            } else if (inp_action==2) {
                System.out.println("silahkan tambahkan memo");
                System.out.print("silahkan masukan judul baru:");
                String judul_memo = Action.nextLine();
                String result_judul = "memo\\"+judul_memo+".txt";
                System.out.println("\nsilahkan masukan isi memo baru:");
                String isi_memo = Action.nextLine();
                try{
                    FileWriter obj = new FileWriter(result_judul,true);
                    //mengisi file
                    obj.write(isi_memo);
                    obj.close();

                    System.out.print("Yeay!berhasil");
                }catch(IOException e){
                    System.out.println("error.");
                }
            }else if (inp_action==3){
                System.out.print("silahkan masukan nama file yang ingin di edit:");
                String inp_judul = Action.nextLine();
                String fileName = "memo/"+inp_judul+".txt";

                System.out.print("silahkan tambah notes yang baru:");
                String isi_judul = Action.nextLine();
                String fileContent = isi_judul;

                try {
                    FileWriter fileWriter = new FileWriter(fileName);
                    fileWriter.write(fileContent);
                    fileWriter.close();

                    System.out.println("File sudah diperbaharui!");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                }
            }else if(inp_action==4){
                System.out.print("silahkan masukan nama file yang ingin di hapus:");
                String inp_delete = Action.nextLine();
                String fileName_del = "memo/"+inp_delete+".txt";

                File deleted = new File(fileName_del);
                if (deleted.delete()) {
                    System.out.println("memo yang dihapus: " + deleted.getName());
                } else {
                    System.out.println("gagal menghapus memo.");
                }
            }else {
                    System.out.println("input invalid..");

            }
        }
        }
    }