import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class Jerry {
	public static void main(String[] args) {
		File dir = new File(".");
		Scanner in = new Scanner(System.in);

		System.out.println("I am Jerry.");
		System.out.print("What should I do? : ");

		String reply = in.nextLine();

		//"Show a Word" Command
		if (reply.equals("Show a word")){
			System.out.println("What word would you like to see?");
			String word = in.nextLine();
			File dictionary = new File("./dictionary");
			File[] files = dictionary.listFiles();
			for (File each : files){
				int pos = each.getName().lastIndexOf(".");
				String eachName =  pos > 0 ? each.getName().substring(0, pos) : each.getName();
				if (eachName.equals(word)) {
					System.out.println("You want to see "+eachName+"?");
					break;
				}
			}
			System.out.println("Currently, that looks like this: \n");
			try  {
				BufferedReader br = new BufferedReader(new FileReader("./dictionary/"+word+".java"));
   			String line = null;
				int count = 0;
   			while ((line = br.readLine()) != null) {

					System.out.println(++count+" | "+line);
				}
				System.out.println("");
			} catch(IOException e) {
					e.printStackTrace();
			}
		} // End "Show a Word" Command

		//"Edit a word" Command
		if (reply.equals("Edit a word")){
			System.out.println("What word would you like to edit?");
			String word = in.nextLine();
			File dictionary = new File("./dictionary");
			File[] files = dictionary.listFiles();
			for (File each : files){
				int pos = each.getName().lastIndexOf(".");
				String eachName =  pos > 0 ? each.getName().substring(0, pos) : each.getName();
				if (eachName.equals(word)) {
					System.out.println("You want to see "+eachName+"?");
					break;
				}
			}
			System.out.println("Currently, that looks like this: \n");
			try  {
				List<String> fileHolder = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new FileReader("./dictionary/"+word+".java"));
   			String line = null;
				int count = 0;
   			while ((line = br.readLine()) != null) {
					System.out.println(++count+" | "+line);
					fileHolder.add(line);
				}
				System.out.println("\nWhich line do you want to edit?");
				int i = in.nextInt();
				in.nextLine();
				System.out.println("You want to edit: \""+fileHolder.get(i-1)+"\"");
				System.out.println("I'm afraid I can't do that, yet.");
			} catch(IOException e) {
					e.printStackTrace();
			}
			System.exit(0);
		} // End "Edit a word" Command

		// "What words do you know?" Command
		if (reply.equals("What words do you know?")) {
			File dictionary = new File("./dictionary");
			File[] files = dictionary.listFiles();
			System.out.println("I know the following words: ");
			for (File each : files) {
				int pos = each.getName().lastIndexOf(".");
				String eachName =  pos > 0 ? each.getName().substring(0, pos) : each.getName();
				System.out.println(eachName);

			}
			System.exit(0);
		}  // end "What words do you know?" Command

		//Edit Files Command
		if (reply.equals("edit your files")){
			try {
					File dictionary = new File("./dictionary");
					File[] files = dictionary.listFiles();
					for (File each : files) {
						int pos = each.getName().lastIndexOf(".");
						String eachName =  pos > 0 ? each.getName().substring(0, pos) : each.getName();
						File file = new File("./dictionary/"+eachName+".java");
						file.createNewFile();

						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write("class "+eachName+" { \n"+
						"\n"+
						"}");
						bw.flush();
						bw.close();
					}
					System.exit(0);
			} catch(IOException e) {
					e.printStackTrace();
			}
		} // end Edit Files Command

		reply = reply.replaceAll("[^A-Za-z0-9 ]","");
		String[] words = 	reply.split("\\s+");

		//Learn Words
		for (String each : words) {

			File listen = new File("./dictionary/"+each+".java");

			System.out.println("You said " + each);

			if (listen.exists()) System.out.println("I know this word!");
			else System.out.println("I have never heard that word. \n" +
						        					"I will add it to my dictionary.");
			try {
				File newWord = new File("./dictionary/"+each+".java");
				newWord.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}

			if (reply.equals("Create your dictionary")) {
				File dictionary = new File(".//dictionary");
				dictionary.mkdir();
				System.out.println("I think I did it. Will you check?");
			}
		} // end Learn Words

		System.out.println("...\nI don't know anything more to do. I should leave. Goodbye.");
	}
		}
