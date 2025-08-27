package java_advanced_01.TeamMission1;

import java_advanced_01.TeamMission1.common.ErrorCode;
import java_advanced_01.TeamMission1.common.StudentText;

import java.io.*;
import java.util.HashMap;

public class StudentInput {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static File file = new File("C:/Temp/student.dat");
    static ObjectInputStream ois = null;
    static ObjectOutputStream oos = null;

    public static void main(String[] args) throws IOException {
        // studentInfo = 이름:학생
        HashMap<String, Student> studentInfo = new HashMap<>();

        loadCheck();

        printUsage();

//        checkKeyAndInputData();

//        saveData();

    }
    public static void loadCheck() throws IOException {
        // 파일이 있나요?
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                Object obj = ois.readObject();
                if (obj == null) {
                    break;
                }
                System.out.println(obj);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println(ErrorCode.FILE_NOT_FOUND.getMsg());
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(null);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // 파일 생성


        // 파일 로드

    }

    public static void printUsage() {
        System.out.println(StudentText.PRINT_USAGE.getMsg());
    }

    public static void checkKeyAndInputData() {

    }

    public static void saveData() {

    }
}
