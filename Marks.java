import java.util.Scanner;

public class Marks {
	static Scanner sc = new Scanner(System.in);
	static int[][] students;
	static int n;
	public static void main(String[] args) {
		System.out.println("\n-------- Marking System (C) IT24103468, 2025 --------\n");
		System.out.println("Note the following for Subject ID");
		System.out.println("1 - Mathematics");
		System.out.println("2 - Chemistry");
		System.out.println("3 - Physics\n");
		System.out.print("Enter number of students: ");
		n = sc.nextInt();
		students = new int[n][3];
		int option, tempStudent, tempSubject;
		
		do {
			System.out.println();
			System.out.println("1) Add marks\t2) Update marks");
			System.out.println("3) Get subject average\t4) Get student average");
			System.out.println("5) Get student total\t6) Get student grades");
			System.out.print(">>> ");
			option = sc.nextInt();
			System.out.println();

			switch (option) {
				case 1:
					System.out.print("Student ID: ");
					tempStudent = sc.nextInt();
					addMarks(tempStudent);
					break;
				case 2:
					System.out.print("Student ID: ");
					tempStudent = sc.nextInt();
					System.out.print("Subject ID: ");
					tempSubject = sc.nextInt();
					updateMarks(tempStudent, tempSubject);
					break;
				case 3:
					System.out.print("Subject ID: ");
					tempSubject = sc.nextInt();
					avgSubMarks(tempSubject);
					break;
				case 4:
					System.out.print("Student ID: ");
					tempStudent = sc.nextInt();
					avgStMarks(tempStudent);
					break;
				case 5:
					System.out.print("Student ID: ");
					tempStudent = sc.nextInt();
					totStMarks(tempStudent);
					break;
				case 6:
					System.out.print("Student ID: ");
					tempStudent = sc.nextInt();
					getStGrades(tempStudent);
					break;
				default:
					break;
			}
		} while (option >= 1 && option <= 6);
	}

	public static void addMarks(int stID) {
		if (stID > n || stID < 1) {
			System.out.println("Invalid student ID");
		} else {
			System.out.println("Enter the marks");
			System.out.print("Mathematics: ");
			students[stID - 1][0] = sc.nextInt();
	
			System.out.print("Chemistry: ");
			students[stID - 1][1] = sc.nextInt();
	
			System.out.print("Physics: ");
			students[stID - 1][2] = sc.nextInt();
		}
	}

	public static void updateMarks(int stID, int subID) {
		if (stID > n || stID < 1) {
			System.out.println("Invalid student ID");
		} else {
			System.out.println("Enter the marks for ");
			int flag = 0;
			switch (subID) {
				case 1:
					System.out.print("Mathematics: ");
					break;
				case 2:
					System.out.print("Chemistry: ");
					break;
				case 3:
					System.out.print("Physics: ");
					break;
				default:
					System.out.print("Invalid subject ID");
					flag = 1;
					break;
			}
			if (flag == 0) {
				students[stID - 1][subID - 1] = sc.nextInt();
			}
		}
	}

	public static void avgSubMarks(int subID) {
		int flag = 0;
		if (subID < 1 || subID > 3) {
			flag = 1;
		}
		if (flag == 0) {
			float avg = 0;
			for (int i = 0; i < n; i++) {
				avg += students[i][subID - 1];
			}
			avg /= n;
			System.out.print("Average marks for ");
			switch (subID) {
				case 1:
					System.out.print("mathematics ");
					break;
				case 2:
					System.out.print("chemistry ");
					break;
				case 3:
					System.out.print("physics ");
					break;
			}
			System.out.println("is " + avg);
		} else {
			System.out.print("Invalid subject ID");
		}
	}

	public static void totStMarks(int stID) {
		if (stID > n || stID < 1) {
			System.out.println("Invalid student ID");
		} else {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += students[stID - 1][i];
			}
			System.out.println("Student's total marks are " + sum);
		}
	}

	public static void avgStMarks(int stID) {
		if (stID > n || stID < 1) {
			System.out.println("Invalid student ID");
		} else {
			float avg = 0;
			for (int i = 0; i < 3; i++) {
				avg += students[stID - 1][i];
			}
			avg /= 3;
			System.out.println("Student's average mark is " + avg);
		}
	}

	public static void getStGrades(int stID) {
		if (stID > n || stID < 1) {
			System.out.println("Invalid student ID");
		} else {
			int markBand;
			for (int i = 0; i < 3; i++) {
				switch (i+1) {
					case 1:
						System.out.print("Mathematics: ");
						break;
					case 2:
						System.out.print("Chemistry: ");
						break;
					case 3:
						System.out.print("Physics: ");
						break;
				}
				markBand = students[stID - 1][i];
				markBand /= 10;
				if (markBand > 9) {
					markBand = 9;
				}
				switch (markBand) {
					case 9:
						System.out.println("Grade A");
						break;
					case 8:
						System.out.println("Grade B ");
						break;
					case 7:
						System.out.println("Grade C ");
						break;
					case 6:
						System.out.println("Grade D ");
						break;
					default:
						System.out.println("Fail");
						break;
				}
			}
		}
	}
}