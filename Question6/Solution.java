package Question6; 
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows)
    {
    if(numRows == 1)
    {
      return s; 
    }

    List<ArrayList<String>> arrNumRows = new ArrayList<>(); 

    for(int i = 0; i < numRows; i++)
    {
      ArrayList<String> arrLs = new ArrayList<String>();
      arrNumRows.add(arrLs); 
    }

    boolean isNotZigZagTime = true; 
    boolean isZigZagTime = false; 
    int size = 0; 
    int count = 1; 
    int reverseCount = numRows; 

    System.out.println(s.length());

    while(((size < s.length()) && isNotZigZagTime) || ((size < s.length()) && isZigZagTime))
    {
      if(isNotZigZagTime == true)
      {
        arrNumRows.get(count-1).add(s.substring(size, size+1)); 
        size++;
        count++; 
        if(count == numRows && size != s.length())
        {
          System.out.println("Size: " + size); 
          if(isZigZagTime == false)
          {
            arrNumRows.get(count-1).add(s.substring(size, size+1)); 
            isZigZagTime = true; 
            isNotZigZagTime = false; 
            count = 1; 
          }
        }
      }

      if(isZigZagTime == true)
      {
        if(reverseCount == 1)
        {
          isNotZigZagTime = true; 
          isZigZagTime = false; 
          count = 1; 
          reverseCount = numRows; 
          continue;
        }
        if(count == 1)
        {
          size++; 
          count++; 
          reverseCount--; 
          continue;
        }
        if(reverseCount != 0)
        {
          arrNumRows.get(reverseCount-1).add(s.substring(size, size+1)); 
          reverseCount--;  
        }
        size++; 
        count++;
        if(count == numRows)
        {
          if(isNotZigZagTime == false)
          {
            isNotZigZagTime = true; 
            isZigZagTime = false; 
            count = 1; 
            reverseCount = numRows; 
          }
        }
      }
    }
    String stringToReturn = "";
    for(ArrayList<String> row: arrNumRows)
    {
      for(int i = 0; i < row.size(); i++)
      {
        stringToReturn += row.get(i); 
      }
    }
    return stringToReturn; 
  }

  public static void main(String[]args)
  {
    String s = new Solution().convert("ABCD", 2);
    System.out.println("String: " + s); 
  }
}