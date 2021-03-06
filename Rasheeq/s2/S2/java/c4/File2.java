import java.util.*;
import java.io.*;
class File2{
	static Scanner s=new Scanner(System.in);
	static String clear="\033[2J\033[1;1H";
	public static void main(String args[]){
		int op;
		do{
			System.out.println(">======FILE OPERATIONS======<");
			System.out.println("|1| Read from a file");
			System.out.println("|2| Write contents to a file");
			System.out.println("|3| Concatenate 2 files");
			System.out.println("|4| Count words in a file");
			System.out.println("|0| EXIT\n=============================");
			System.out.print("Please select an option(0-4): ");
			op=s.nextInt();
			switch(op){
				case 0: break;
				case 1: read();
					break;
				case 2: write();
					break;
				case 3: concat();
					break;
				case 4: count();
					break;
				default:System.out.println("Invalid input!Try again");
					break;
			}
		}while(op!=0);
	}
	static void read(){
		File f;
		FileReader fr;
		String filePath;
		System.out.print("Enter file name : ");
		try{
			filePath=s.next();
			f=new File("files",filePath);
			fr=new FileReader(f);
			char c=(char)fr.read();
			System.out.println(clear+"\n:::File("+filePath+") Content:::");
			while(c!=(char)-1){
				System.out.print(c);
				c=(char)fr.read();
			}
			System.out.println("\n:::::::END::::::::");
			fr.close();
		}catch(Exception e){
			System.out.println(clear+e.getMessage());
		}
	}
	static void write(){
		Scanner r=new Scanner(System.in);
		File f;
		FileWriter fw;
		String fileName;
		String content;
		System.out.println("Enter the content");
		content=r.nextLine();
		char buffer[]=new char[content.length()];
		content.getChars(0,content.length(),buffer,0);
		System.out.print("(Save)Enter new file name: ");
		fileName=r.next();
		try{
			f=new File("files",fileName);
			fw=new FileWriter(f);
			fw.write(buffer);
			fw.close();
			System.out.println(clear+"File("+fileName+") saved...");
		}catch(Exception e){
			System.out.println(clear+e.getMessage());
		}
	}
	static void concat(){
		File f1;
		File f2;
		String src,des;
		char c;
		FileReader fr;
		FileWriter fw;
		try{
			System.out.print("Enter source file name: ");
			src=s.next();
			System.out.print("Enter destination file name ");
			des=s.next();
			f1=new File("files",src);
			f2=new File("files",des);
			fr=new FileReader(f1);
			fw=new FileWriter(f2,true);
			while((c=(char)fr.read())!=(char)-1){
				fw.write(c);
			}
			fr.close();
			fw.close();
			System.out.println(clear+"File :\'"+src+"\' copied to File:\'"+des+"\'");
		}catch(Exception e){
			System.out.println(clear+e.getMessage());
		}
	}
	static void count(){
		FileReader fr;
		File f;
		String fName="";
		char c,last=' ';
		int count=0;
		try{
			System.out.print("Enter file name: ");
			fName=s.next();
			f=new File("files",fName);
			fr=new FileReader(f);
			while((c=(char)fr.read())!=(char)-1){
				if((c==' '||c=='	')&&(last!=' '&&last!='	')){
					count++;
				}
				last=c;	
			}
			count++;
			if(last==' '||last=='	'){
				count--;
			}
			System.out.println(clear+"File "+fName+" contains "+count+" words");
		}catch(Exception e){
			System.out.println(clear+e.getMessage());
		}
	}
}
