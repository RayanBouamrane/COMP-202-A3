//Name: Rayan Bouamrane
//Student Number: 260788250

public class Mountains{
  
  public static void main (String[] args){
    
//    int size = 80;
//    double steepness = 2;
//    double maxH = 15;
//    String symbol = "#";
//    
//    drawMountains(generateMountains(size, steepness, maxH), symbol);
  
  }
  
  public static double nextPoint (double prevH, double steepness, double maxH){ //1a
    
    //prevH-steepness is the lower bound, adding 2*steepness would provide the upper bound
    //this method adds a random number (rounded to a whole number) to the lower bound
    double point = Math.round((prevH-steepness + Math.random()*2*(Math.round(steepness))));
    
    //if the point generated is larger than the max height, or smaller than 0
    //then the height and 0 is returned respectively, otherwise return the new point
    if(point > maxH){
      return maxH;
    }
    else if(point < 0){
      return 0;
    }
    else {
      return point; 
    }
  }
  
  public static double[] generateMountains (int size, double steepness, double maxH){ //1b
    
    //an array is created with "size" number of values in it
    //the first value of that array is the rounded value of the max height/2
    double[] arrayHeights = new double[size];
    arrayHeights[0]= Math.round(maxH/2);
    
    //this for loop calls upon the method nextPoint, passes though the previous value in the array,
    //as well as the steepness and maxH. The previous array entry is used to generate the next array entry
    for(int i = 1; i<size; i++){
      arrayHeights[i] = nextPoint(arrayHeights[i-1], steepness, maxH);
    }
    //the array is then returned
    return arrayHeights;
  }
  public static double findMaxHeight (double[] heights){ //1c
    
    //the variable maxHeight is declared, and set to zero, so that should the array passed 
    //in be empty, the method returns 0
    double maxHeight = 0;
    
    //loop iterates through the array and sets variable maxHeight to the largest number in the array
    for(int i = 0; i<heights.length; i++){
      
      //if a value is found to be larger than the previous maximum, it is set to be the new maximum
      if(heights[i]>maxHeight){
        maxHeight = heights[i];
      }
    }
    return maxHeight;
  }
  
  public static void drawMountains (double[] heights, String symbol){ //1d
    int maxHeight = (int) Math.round(findMaxHeight(heights)+1);
    
    //outer for loop iterates down from maxHeight to zero
    for (int y = maxHeight; y>=0; y--){
      
      //inner for loop iterates from 0 (index 0) to x>height.length, the highest index of heights
      for(int x = 0; x<heights.length; x++){
        
        //if statements follow the conditions listed in the assignment however, the condition that y!=0 needed
        //to be added, as otherwise ^ symbol would be printed instead of - as the condition that
        //y-heights[x]<1&&y-heights[x]>-1 is satisfied at y==0, even though we want the - ground to be printed
        if(y>heights[x]){ 
          System.out.print(" ");
        }
        else if(y-heights[x]<1&&y-heights[x]>-1&&y!=0){
          System.out.print("^");  
        }
        else if(y<heights[x]&&y!=0){
          System.out.print(symbol);
        }
        else if(y==0){
          System.out.print("-"); 
        }
      }
      System.out.println();
    }
  }
}
