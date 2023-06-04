package OOP_Begin;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class FileManager {
    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getName());
    private static Object newPerson;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        file_reade fileReade = new file_reade();
        Person person = new Person();
        LOGGER.log(Level.FINE, "Started: {0}", Arrays.toString(args));
        boolean a;

        //        System.out.println("Выберете дейстивие" + '\n' + "1 - Запись" + '\n' + "2 - Чтение");
        //        int i = scanner.nextInt();

        int i = 1;

        if (i == 1) {
            System.out.println("Путь и имя ");
            //            person.Name = scanner.next();
            String Name = "C:\\Test\\test\\TEST.txt";
            System.out.println("Введите число");
            person.HP = scanner.nextInt();
            System.out.println("Пишите");
            //            person.ha = scanner.next();
            person.ha = "13" + '\n' + "Netrebin" + "\n" + "Kovtun" + "\n" + "XX.XX.XXXX";


            // Save:
            FileOutputStream fileOutputStream = new FileOutputStream(Name);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //            objectOutputStream.writeObject(person.HP);
            objectOutputStream.writeObject(person.ha);
            objectOutputStream.flush(); //Save
            objectOutputStream.close(); //Close

            fileReade.reade("C:\\Test\\test\\TEST.txt");
        }
        if (i == 2) {
            do {
                try {
                    System.out.println("Введите путь ");
                    String name = scanner.next();
                    FileInputStream fileInputStream = new FileInputStream(name);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Object newPerson = objectInputStream.readObject();
                    objectInputStream.close();

                    System.out.println(newPerson);
                    a = false;
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "File not found", e);
                    System.out.println("Фаайл не был найден");
                    a = true;
                    System.out.println("Выберете дейстивие" + '\n' + "1 - Запись" + '\n' + "2 - Чтение");
                    i = scanner.nextInt();
                }
            } while (a);
        }
    }

    void write() throws IOException {
        System.out.println("Путь и имя ");
        person.Name = scanner.next();
        System.out.println("Введите колличество Колес");
        person.HP = scanner.nextInt();

        // Save:
        FileOutputStream fileOutputStream = new FileOutputStream(person.Name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person.HP);
        objectOutputStream.flush(); //Save
        objectOutputStream.close(); //Close
    }


class Person extends file_reade{
    int HP;
    String Name;
    String ha;
}

//Методы для отдельного исспользования и заимствования класса file_read.
class file_reade {

    private static final Logger LOGGER = Logger.getLogger(file_reade.class.getName());
    int HP;
    String Name;
    Scanner scanner = new Scanner(System.in);
    Person person = new Person();
    boolean a;

    void a() {
        LOGGER.log(Level.INFO, "I'm logging");
    }

    void write() throws IOException {
        System.out.println("Путь и имя ");
        person.Name = scanner.next();
        System.out.println("Введите колличество Колес");
        person.HP = scanner.nextInt();

        // Save:
        FileOutputStream fileOutputStream = new FileOutputStream(person.Name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person.HP);
        objectOutputStream.flush(); //Save
        objectOutputStream.close(); //Close
    }

    String reade(String Name) {

        do {
            try {
                System.out.println("Введите путь ");
                String name = scanner.next();
                FileInputStream fileInputStream = new FileInputStream(Name);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object newPerson = objectInputStream.readObject();
                objectInputStream.close();

                System.out.println(newPerson);
                a = false;
            } catch (Exception e) {
                System.out.println("Фаайл не был найден");
                a = true;
            }
        } while (a);

        return Name;
    }
}

