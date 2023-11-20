package Question7ReversedInteger;

class Solution {
  public int reverse(int x) {

    String str = ""; 
    boolean containsMinus = false; 

    int isFirstElementMinus = String.valueOf(x).indexOf("-"); 
    int isLastElementZero = String.valueOf(x).indexOf("0"); 

    try{

    if(isLastElementZero == String.valueOf(x).length()-1)
    {
      for(int i = 0; i < isLastElementZero; i++)
      {
        str += String.valueOf(x).substring(i, i+1);
      }
      x = Integer.parseInt(str); 
      str = ""; 
    }

    if(isFirstElementMinus == 0)
    {
      for(int i = isFirstElementMinus + 1; i < String.valueOf(x).length(); i++)
      {
        str += String.valueOf(x).substring(i, i+1);
      }
      x = Integer.parseInt(str); 
      containsMinus = true; 
      str = ""; 
    }

    for(int i = String.valueOf(x).length()-1; i >= 0; i--)
    {
      str += String.valueOf(x).substring(i, i+1); 
    }

    if(containsMinus == true)
    {
      return Integer.parseInt("-" + str);  
    }
    return Integer.parseInt(str);
  }catch(NumberFormatException e){
    return 0; 
  }
  }

  public static void main(String[]args)
  {
    int reverseNum = new Solution().reverse(-102); 
    System.out.println(reverseNum); 
  }
}
