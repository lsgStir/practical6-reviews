import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reviews {

	ArrayList<String> reviews;	// A list of individual reviews
	
	public static void main(String[] args) 
	{
		Reviews p = new Reviews();
		

		// p.printTop(10);
		System.out.println(p.findLongestReview());

	}
	
	public Reviews()
	{
		reviews = loadReviews("100.txt");  
	}
	
	/**
	 * Read in lines of data using the given review file name that contains reviews and return the reviews in 
	 * an ArrayList.
	 * 
	 * @param reviewFileName	The name of the file full of reviews to read data from.
	 * @return An ArrayList of String objects containing individual reviews
	 */
	public ArrayList<String> loadReviews(String reviewFileName)
	{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader in;
		
		try
		{
			String line;
			in = new BufferedReader(new FileReader(reviewFileName));
			while ((line = in.readLine()) != null)
			{
				String toks[]=line.split("\t"); // Format: Title\tReview\tScore
				data.add(toks[1]); // Just add the review
			}
			in.close();
		}
		catch (IOException e)
		{
			System.err.println("Problems, problems: " + e);
		}
		
		return data;
	}
	
	public void printTop(int numReviews)
	{
		for (int i=0; i<numReviews && i<reviews.size(); i++)
			System.out.println(reviews.get(i));
	} 
	
	public int findLongestReview()
	{
		int longest = 0;
		int maxLength = 0;
		int size = 0;
		for (int r=0; r<reviews.size(); r++)
		{
			// Get review r, split it using space as a separator
			// and find out how many words/tokens we got back. 
			size = reviews.get(r).split(" ").length;	
			if (size > maxLength)
			{
				maxLength = size;
				longest = r;
			}
		}
		return longest;
	}
}
