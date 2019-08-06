package VirtualCommandPrompt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Command {

	Folder currentFolder;
	List<String> folders = new ArrayList<String>();

	public Command() {
		currentFolder = new Folder("R");
	}

	/**
	 * Run Virtual Command
	 */
	public void commandPrompt() {
		String commands;
		Scanner input = new Scanner(System.in);
		while (true) {
			showPath();
			commands = input.nextLine();
			String commandArray[] = commands.split(" ");
			Integer commandLength = commandArray.length;
			if (commandLength == 2) {
				switch (commandArray[0]) {

				case "mkdir":
					if (mkdir(commandArray[1]))
						System.out.println("New Folder Created.");
					else
						System.out.println("Folder already exit.");
					break;

				case "cd":
					if (!cd(commandArray[1]))
						System.out.println("Folder is not exists");
					break;

				case "find":
					String path = find(commandArray[1]);
					System.out.println(path);
					break;

				default:
					System.out.println("No Command found");
					break;
				}
			}
			if (commandLength == 1) {
				switch (commandArray[0]) {

				case "bk":
					if (!bk())
						System.out.println("This is root directory");
					break;

				case "ls":
					ls();
					break;

				case "tree":
					tree();
					break;
				case "exit":
					System.exit(0);
					break;
				default:
					System.out.println("Command Not found");

				}
			}
		}

	}

	/**
	 * Show the current path
	 */
	private void showPath() {
		System.out.print("R:");
		for (String folderName : folders) {
			System.out.print("\\" + folderName);
		}
		System.out.print(">");
	}

	/**
	 * Command to make directory
	 * 
	 * @param folderName
	 *            name of directory
	 * @return true if created successfully else return false
	 */
	private boolean mkdir(String folderName) {
		if (findfolder(folderName)) {
			Folder newFolder = new Folder(folderName);
			newFolder.setParent(currentFolder);
			currentFolder.subfolder.add(newFolder);

			return true;
		} else
			return false;
	}

	/**
	 * Find the directory
	 * 
	 * @param folderName
	 *            name of folder
	 * @return true if found else false
	 */
	private boolean findfolder(String folderName) {
		List<Folder> subFolders = currentFolder.getSubfolder();
		for (Folder currentFolders : subFolders) {
			if (currentFolders.getFolderName().equals(folderName))
				return false;
		}
		return true;
	}

	/**
	 * Change Directory Command
	 * 
	 * @param folderName
	 *            move to this directory
	 * @return true if success else false
	 */
	private boolean cd(String folderName) {
		if (!findfolder(folderName)) {
			List<Folder> subFolders = currentFolder.getSubfolder();
			for (Folder currentFolders : subFolders) {
				if (currentFolders.getFolderName().equals(folderName)) {
					currentFolder = currentFolders;
					folders.add(currentFolder.getFolderName());
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Go back to parent directory
	 * 
	 * @return true
	 */
	private boolean bk() {
		Folder parent = this.currentFolder.getParent();
		if (parent == null)
			return false;
		currentFolder = parent;
		folders.remove(this.folders.size() - 1);
		return true;
	}

	/**
	 * List of all files and directory inside the directory
	 * 
	 * @return true
	 */
	private boolean ls() {
		List<Folder> subFolders = currentFolder.getSubfolder();
		for (Folder folder : subFolders) {
			showFolderDetail(folder);
		}
		return true;
	}

	/**
	 * print detail of every folder
	 * 
	 * @param folder
	 */
	private void showFolderDetail(Folder folder) {
		System.out
				.println(folder.getFolderName() + "  " + folder.getDatetime());
	}

	private String find(String folderName) {
		return search(currentFolder, folderName);
	}

	/**
	 * Search the folder in virtual system
	 * 
	 * @param folder
	 * @param folderName
	 * @return path if found.
	 */
	private String search(Folder folder, String folderName) {
		if (folder.getFolderName().equals(folderName))
			return folderName;
		if (folder.getSubfolder().size() < 1)
			return "";
		String path = "";
		for (Folder subfold : folder.getSubfolder()) {
			path = "";
			path = path + folder.getFolderName() + "/"
					+ search(subfold, folderName);
		}

		return path;
	}

	public void tree() {
		showTree(currentFolder, 0);
	}

	/**
	 * Show the tree view of directory
	 * 
	 * @param folder
	 * @param nesting
	 */
	private void showTree(Folder folder, Integer nesting) {

		for (Folder subDirectory : folder.getSubfolder()) {
			for (int loop = 0; loop < nesting; loop++)
				System.out.print("\u2502");
			if (subDirectory.getSubfolder().size() != 0) {
				System.out.println("\u251c\u2500"
						+ subDirectory.getFolderName());
				showTree(subDirectory, nesting + 1);
			} else
				System.out.println("\u2514\u2500"
						+ subDirectory.getFolderName());
		}

	}
}