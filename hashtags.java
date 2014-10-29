import java.io.*;
import java.util.*;
class hashtags
{
	public static void main(String ar[]) throws Exception
	{
		
		
		
	}
	static String[] extract(String k)
	{
		ArrayList<String> a=new ArrayList<String>();
		String hash,temp;
		StringTokenizer st=new StringTokenizer(k);
		while(st.hasMoreTokens())
		{
			temp=st.nextToken();
			if(temp.charAt(0)=='#')
			{
				hash=temp;
				a.add(hash);		
			}
		}
		if(a.size()==0)
		{
			a.add("#default");			
		}

		return a.toArray(new String[a.size()]);

	}

}
class note implements Serializable
{
	String text;
	String[] hash;
	note(String n)
	{
		text=n;
		hash=hashtags.extract(n);
		try {
			add();
		}
		catch(Exception e) {
			
		}
	}
	void add() throws Exception
	{
		ArrayList<note> list;
		try
		{
			FileInputStream fileIn = new FileInputStream("notes.ser");
         	ObjectInputStream in = new ObjectInputStream(fileIn);
         	list=(ArrayList<note>)in.readObject();
         	list.add(this);
         	in.close();
         	fileIn.close();
		}
		catch(Exception E)
		{	
			E.printStackTrace();
			list=new ArrayList<note>();
			list.add(this);
         		
		}
		FileOutputStream fileOut = new FileOutputStream("notes.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(list);
        out.close();
        fileOut.close();
	}

}