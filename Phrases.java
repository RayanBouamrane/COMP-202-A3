//Name: Rayan Bouamrane
//Student Number: 260788250

public class Phrases{
  
  public static void main (String[] args){
    
//    String s1 = "Don't burn a bridge until it's behind you.";
//    String s2 = "Do not worry about crossing the bridge until you're ready to cross it.";
//    System.out.println(combineStrings(s1,s2)); 
//    
//    String t1 = "Not all those who wander are lost.";
//    String t2 = "Make new friends, but keep the old; The first are silver, the rest are gold.";
//    System.out.println(combineStrings(t1,t2));
    
  }
  public static String join (String[] a){ //2a
    
    //The first part of the string will be the first array value (index 0), this is done to avoid spacing issues
    String s = a[0];
    
    //for loop adds a space and the second value to the String s, which is returned when the loop completes
    for(int i=1; i<a.length;i++){
      s=s+" "+a[i];
    }
    return s;
  }
  
  public static int findInStringArray ( String[]a, String s){ //2b
    
    //this loop checks that the string s and the i'th entry of a are equal
    //if they are, i is returned, which is the index of a 
    for (int i=0; i<a.length; i++ ){
      if(s.equalsIgnoreCase(a[i])){
        return i; 
      }
    } 
    //if the loop completes and no match has been found, -1 is returned
    return -1;
  }
  
  public static int numWords (String s){ //2c helping method
    
    //if a String is empty or null, an exception is thrown, and a message displayed
    if(s.equals("")||s.equals(null)){
      throw new IllegalArgumentException ("Your String is empty, this is not valid.");
    }
    
    //this counter begins at one as if there are no spaces, there is one word
    int wordCount = 1;
    
    for (int i = 0; i<s.length(); i++){
      
      if(s.charAt(i) == ' '){
        wordCount = wordCount +1; 
      }
    }
    return wordCount;
  }
  public static String[] tokenize(String s){ //2c
    
    int sLength = numWords(s);
    
    String[] sArray = new String[sLength];
    
    //this for loop assigns an empty value to each index of the array
    //this avoids concatenation of null with another String
    for(int k = 0; k<sArray.length;k++){
      sArray[k] = ""; 
    }
    //this loop iterates through the index of sArray, k++ takes us to the next word
    for(int k = 0; k<sArray.length;k++){
      
      //this loop iterates through every character of the String s
      for(int i = 0;i<s.length();i++){
        
        //if a char is a space, no character is added to the array, and k increases by one
        if(s.charAt(i)==' ') {  
          k++;}
        //if not, the character at index i is concatenated with the array at index k
        else{
          sArray[k] = sArray[k]+s.charAt(i); 
        }
      }
    }
    return sArray;
  }
  
  public static String[] combineArray (String[] s1, String[] s2, int p1, int p2){ //2d
    
    //the length of the array will be this, as the first part shows the number of elements from the first 
    //array, which is added to number of elements taken from the second array
    String[] combined = new String[(p1+1)+(s2.length-p2-1)];  //simplifies to (p1+s2.length-p2)
    
    //this counter will increase for every index from the second array that is copied to the combined array
    int counter = 0;
    for (int k=0; k<combined.length; k++){
      
      if(k<=p1){
        combined[k] = s1[k];  
      }
      
      //when k becomes larger than p1, values from the second array will need to be inserted
      //the index of s2 will be the value of p2, plus the counter that increments only when s2 values 
      //are added, plus 1 (as the value at index p2 is not included)
      if(k>p1){ 
        combined[k] = s2[p2+counter+1];
        counter++;
      }
    }
    return combined;
  }
  
  public static String combineStrings (String s1, String s2){ //2e
    
    //both Strings are converted to arrays via tokenize
    String[] ar1 = tokenize(s1);
    String[] ar2 = tokenize(s2);
    
    //these ints will tell us the indexes of the common word in both arrays
    int index1 = -1;
    int index2 = -1;
    
    //for loop finds the index of ar1 where a String matches one in ar2
    for(int i=0;i<ar2.length;i++){
      index1 = findInStringArray(ar1, ar2[i]);
      
      //if the index is not equal to -1, the index where the words are the same has been found, 
      //and the loop breaks
      if(index1!=-1){ 
        break; 
      }
      
      //if the index value returned by findInStringArray is -1, and the last value in the array 
      //(with index ar2.length-1) has been searched, there are no matching Strings, and an exception is thrown
      if (index1==-1&&i==ar2.length-1){
        throw new IllegalArgumentException ("Your Strings do not have a word in common."); 
      }
    }
    //this loop is run again with inverse parameters, to find the index of ar2
    for(int i=0;i<ar1.length;i++){
      
      index2 = findInStringArray(ar2, ar1[i]);
      
      if(index2!=-1){
        break; 
      }
    }
    //the arrays and indexes are passed as parameters to the method combinearray
    String[] combinedArrays = combineArray(ar1, ar2, index1, index2);
    
    //and the array is converted into a String via the join method, and returned
    String combinedString = join(combinedArrays);
    
    return combinedString;
  }
}
