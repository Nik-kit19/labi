package labs.labi2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        new StudentSort().sort(students);

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.getName()).append(' ').append(s.getAge()).append('\n');
        }
        System.out.print(sb);
    }
}
