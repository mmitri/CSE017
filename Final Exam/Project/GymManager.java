import java.util.*;
import java.io.*;
/**
 * Class GymManager 
 * Test program to manage users and members of a gym
 * @author Houria Oudghiri
 * Date of creation: December 10, 2021
 */
public class GymManager {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Read the list of the gym training sessions in an array list
		ArrayList<Session> sessions = new ArrayList<>();
		readSessions(sessions, "sessions.txt");
		System.out.println("Training sessions read (" + sessions.size() + " sessions).");
		
		// Read the list of the gym users in a hash table 
		// The username is the key and the user info is the value
		HashMap<String, UserInfo> users = new HashMap<>(500);
		readUsers(users, "users.txt");
		System.out.println("User information read (" + users.size() + " users).");
		
		// Read the list of the gym members in a BST
		BST<Member> members = new BST<>();
		readMembers(members, sessions, "members.txt");
		System.out.println("Member information read (" + members.size() + " members).");

		try{
			UserInfo user = login(keyboard, users);
			if(user != null){
				if(user.getID().startsWith("M")) {
				// Member operations
				memberOperations(keyboard, user.getID(), members, sessions);
				}else{
					// Administrator operations
					adminOperations(keyboard, sessions,members);
				}
			}
		}catch(InputMismatchException e){
			System.out.println("Username not valid.");
		}	
	}
	/**
	 * Method to read the session info from the file into an array list
	 * @param list: array list where objects of type Session will be stored
	 * @param filename: input file that contains the information of the training sessions
	 */
	public static void readSessions(ArrayList<Session> list, 
									String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		while (readFile.hasNextLine()) {
			String line = readFile.nextLine();
			String[] tokens = line.split(" ");
			String code = tokens[0];
			String title = tokens[1];
			int time = Integer.parseInt(tokens[2]);
			double fee = Double.parseDouble(tokens[3]);
			Session s = new Session(code, title, time, fee);
			list.add(s);
		}
		readFile.close();
	}
	/**
	 * Method to read the user info from the file into a hash table
	 * @param ht: the hash table where objects of type UserInfo will be stored
	 *           as values. keys are the user names
	 * @param filename: input file that contains the user information
	 */ 
	public static void readUsers(HashMap<String, UserInfo> ht,
								 String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try{
			readFile = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.println("Error 404: File not found.");
			System.exit(0);
		}
		while(readFile.hasNextLine()){
			String line = readFile.nextLine();
			String[] tokens = line.split(" ");
			String id = tokens[0];
			String username = tokens[1];
			String password = tokens[2];
			UserInfo u = new UserInfo(id,username,password);
			ht.put(username, u);
		}
	}
	
	/**
	 * Method to read the member info from the file into the BST
	 * The list sessions is also updated to reflect the number of members
	 * enrolled in each session
	 * @param bst: the BST where objects of type Member will be stored
	 * @param sessions: list of training sessions
	 * @param filename: input file that contains the member information
	 */
	public static void readMembers(BST<Member> bst,
								   ArrayList<Session> sessions,
								   String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try{
			readFile = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.println("Error 404: File not found.");
			System.exit(0);
		}
		while(readFile.hasNextLine()){
			String line = readFile.nextLine();
			String[] tokens = line.split(" ");
			String id = tokens[0];
			String name = tokens[1];
			Member m = new Member(id,name);
			bst.add(m);
		}
	}
	/**
	 * Method to check the login credentials
	 * @param keyboard: Scanner object to interact with the user
	 * @param users: the hash table of user names and passwords 
	 *              used for the login verification
	 * @return the UserInfo object that has the same username and password 
	 *         entered by the user, or null if the username or password do not match
	 * @throws InputMismatchException
	 *         Exception thrown if username is not valid
	 *         (must be 3 letters followed by 3 digits)
	 */ 
	public static UserInfo login(Scanner keyboard, 
								 HashMap<String, UserInfo> users) {
			int count = 0;
			while(count < 3) {
				System.out.print("Enter username: ");
				String username = keyboard.next();
				if(!username.matches("[a-z]{3}[0-9]{3}")) {
					throw new InputMismatchException();
				}
				UserInfo u = users.get(username);
				if(u == null) {
					System.out.println("Username not found. Try again.");
				}
				else {
					System.out.print("\nEnter password: ");
					String password = keyboard.next();
					if(u.getPassword().equals(password)) {
						return u;
					}
					else {
						System.out.println("Password incorrect. Try again.");
					}
				}
				count++;
			}
			System.out.println("Incorrect username or password more than 3 times.");
			System.out.println("Terminating the program...");
			return null;
		}
	
	/**
	 * Method to perform the operations of a member
	 * @param keyboard: Scanner object to interact with the user
	 * @param id: id of the member 
	 * @param members: BST of all the members in the gym
	 *                used to find the member with the given id and
	 *                update it if sessions are added or removed
	 * @param sessions: List of training sessions of the gym
	 *                 used to view the training sessions or 
	 *                 to allow the member to choose a new session and
	 *                 add it to his/her list
	 */
	public static void memberOperations(Scanner keyboard, 
									    String id, 
									    BST<Member> members, 
									    ArrayList<Session> sessions){
		int operation;
		Member m = members.find(new Member(id, ""));
		do {
			printMenu();
			operation = keyboard.nextInt();
			switch(operation) {
				case 1:// view my sessions
					members.toString();
					break;
				case 2: // view all sessions
					sessions.toString();
					break;
				case 3:// add session
					sessions.toString();
					System.out.println("Enter the code of the session you want to add: ");
					String sessionCodeAdd = keyboard.nextLine();
					members.addSession(sessionCodeAdd);
					break;
				case 4: // remove session
					members.toString();
					System.out.println("Enter the code of the session you want to remove: ");
					String sessionCodeRemove = keyboard.nextLine();
					members.removeSession(sessionCodeRemove);
					break;
				case 5:
					System.out.println("Thank you for your visit!");
					break;
			}
		}while(operation != 5);
		
	}
	public static void printMenu() {
		System.out.println("Select an operation:");
		System.out.println("1: View my sessions");
		System.out.println("2: View all sessions");
		System.out.println("3: Add a session");
		System.out.println("4: Remove a session");
		System.out.println("5: Logout");
	}
	/**
	 * Method to perform the operations for an administrator
	 * This methods calls printIncome() and printSessions()
	 * @param keyboard: Scanner object to interact with the user
	 * @param sessions: List of training sessions
	 * @param members:  BST of the gym members
	 */
	public static void adminOperations(Scanner keyboard, 
									   ArrayList<Session> sessions,
									   BST<Member> members) {
		printIncome(sessions, members);
		printSessions(sessions);
	}
	
	/**
	 * Method to print the due fees for each member and
	 * the total weekly income. 
	 * @param list: list of training sessions
	 * @param bst : BST of members
	 */
	public static void printIncome(ArrayList<Session> list,
								   BST<Member> bst) {
		double total = 0;
		System.out.printf("%-20s\t%-20s\t%-20s\t%-20s\n","Member ID", "Member name", "Sessions", "Fees");
		for(int i=0;i<list.size();i++){
			System.out.printf("%-20s\t%-20s\t%-20s\t%-10d\n",bst.find(id),bst.find(name),bst.find(sessions),list.get(i+4));
			total = total + list.get(i+4);
		}
		System.out.printf("%-20s\t%-20d\n","Total Income",total);
	}
	
	/**
	 * Method to print the training sessions in descending order of
	 * the number of members enrolled in each session 
	 * The method calls mergeSort() to sort the list sessions
	 * @param sessions: list of training sessions
	 */
	public static void printSessions(ArrayList<Session> list) {
		MergeSort.mergeSort(list);
		System.out.printf("%-20s\t%-20s\n","Session Title","# Enrolled Members");
		for(int i=0;i<list.size();i++){
			System.out.printf("%-20s\t%-10d\n",list.get(i+1),list.get(i+5));
		}
	}
}

