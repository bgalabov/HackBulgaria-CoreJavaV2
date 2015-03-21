package com.hackbulgaria.corejava;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        if(number==0){
            return false;
        }
        for(int i=2; i*i<=2; i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isPrime(int number) {
        if(number==1){
            return true;
        }
        if(number==2){
            return true;
        }
        for(int i=2; i*i<number; i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int min(int... array) {
        int min=array[0];
        for(int i=1; i<array.length; i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        float sum=0;
        for(int i=0; i<array.length; i++){
            sum+=array[i];
        }
        return sum/array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
       boolean isDivisable=true;
       int result=2;
       
       if(upperBound==1){
           return 1;
       }
       for(long i=2; i<=upperBound; i++){
           result=(int) lcmcal(result, i);
       }
       
       
       return result;
    }
    
    // Helper method for finding lowest common multiple, used in the method above.
    private long lcmcal(long i,long y)
    {
        long n,x,s=1,t=1;
        for(n=1;;n++)
        {
            s=i*n;
            for(x=1;t<s;x++)
            {
                t=y*x;
            }
            if(s==t)
                break;
        }
        return(s);
    }

    @Override
    public long getLargestPalindrome(long N) {
        long number = 100;
        long digit = 0;
        long reversed = 0;

        while (true) {
            while (number > 0) {
                digit = number % 10;
                reversed = reversed * 10 + digit;
                number /= 10;

            }
            if (reversed == N) {
                return N;
            } else {
                number = --N;
                digit = 0;
                reversed = 0;
            }
        }
    }

    @Override
    public int[] histogram(short[][] image) {
        int arr[]=new int[255];
        
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image.length; j++){
                arr[image[i][j]]++;
            }
        }
        return arr;
    }

    @Override
    public long doubleFac(int n) {
        int temp=1;
        int result=1;
        
        for(int i=n; i>0; i--){
            temp*=i;
        }
        
        for(int i=temp; i>0; i--){
            result*=i;
        }
        
        return result;
    }

    @Override
    public long kthFac(int k, int n) {
        long result=1;
        
        for(int i=n; i>0; i=(i-k)){
            result*=i;
        }
        return result;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        int current;
        int countOfElement=0;
        // TODO Auto-generated method stub`
       for(int i=0; i<array.length; i++){
           current=array[i];
           countOfElement=0;
           for(int j=0; j<array.length; j++){
               if(array[j]==array[i]){
                   countOfElement++;
               }
           }
           if(countOfElement%2!=0){
               return current;
           }
       }
        return 0;
    }

    @Override
    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if(b<0){
            if(a<0){
                System.out.println("Cannot raise zero to the power of a negative power");
            }
            return 1/pow(a, -b);
        }
        else {
            if(b%2!=0){
                long powerOfHalfB=pow(a, b/2);
                return a*powerOfHalfB*powerOfHalfB;
            }
            else{
                long powerOfHalfB=pow(a, b/2);
                return powerOfHalfB*powerOfHalfB;
            }
        }
    }
    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        int sum=0;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int i=0; i<a.length; i++){
            sum+=a[i]*b[i];
        }
        
        return sum;
    }

    @Override
    public int maxSpan(int[] array) {
        int size=array.length;
        int maxSpan=0;
        
        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                if(array[i]==array[j] && maxSpan<j-i+1){
                    maxSpan=j-i+1;
                }
            }
        }
        return maxSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        int leftSum=0;
        int rightSum=0;
        
        for(int i=0; i<array.length; i++){
            leftSum+=array[i];
            rightSum=0;
            for(int j=array.length-1; j>i; j--){
                rightSum+=array[j];
            }
            if(leftSum==rightSum){
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int sizeW=original.length;
        int sizeH=original[0].length;
        
        int[][] rescaled=new int[newWidth][newHeight];
        int scaleWidth=sizeW/newWidth;
        int scaleHeight=sizeH/newHeight;
        
        for(int i=0; i<newWidth; i++){
            for(int j=0; j<newHeight; j++){
                rescaled[i][j]=original[i*scaleWidth][j*scaleHeight];
            }
        }
        
        
        
        return rescaled;
    }

    @Override
    public String reverseMe(String argument) {
        char[] arr=argument.toCharArray();
        StringBuilder strBldr=new StringBuilder();
        for(int i=argument.length()-1; i>=0; i--){
            strBldr.append(arr[i]);
        }
        return strBldr.toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        char[] arr=input.toCharArray();
        StringBuilder strbldr=new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<k; j++){
                if((int) arr[i]>=65 && ((int) arr[i]<=90)){
                    strbldr.append(arr[i]);
                    strbldr.append(arr[i]+=32);
                    break;
            }
                strbldr.append(arr[i]);
                }
            }
        return strbldr.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] strings=arg.split(" ");
        StringBuilder strBldr=new StringBuilder();
        
        for(String str : strings){
            strBldr.append(reverseMe(str) + " ");
        }
        strBldr.deleteCharAt(strBldr.length()-1);
        return strBldr.toString();
    }

    @Override
    public boolean isPalindrome(String argument) {
        char[] arr=argument.toCharArray();
        int gap=0;
        boolean isPalindrome=true;
        
        if(arr.length%2==0){
            gap=arr.length-1;
            for(int i=0; i<=(arr.length/2); i++, gap--){
                if(!(Character.compare(arr[i], arr[gap])==0)){
                    isPalindrome=false;
                    break;
                }
            }
        }
        else if(arr.length%2!=0){
            gap=arr.length-1;
            for(int i=0; i<=(arr.length/2); i++, gap--){
                if(!(Character.compare(arr[i], arr[gap])==0)){
                    isPalindrome=false;
                    break;
                }
            }
        }
        return isPalindrome;
    }

    @Override
    public boolean isPalindrome(int number) {
        int reversed=0;
        int digit=0;
        int n=number;
        
        while(n>0){
            digit=n%10;
            reversed=(reversed*10)+digit;
            n/=10;
        }
        if(number==reversed){
            return true;
        }
        return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        String[] strings=input.split("\\*");
        char[] arr1=strings[0].toCharArray();
        char[] arr2=strings[1].toCharArray();
        int size;
        int currentLength=0;
        int j;
        
        size = (arr1.length < arr2.length) ? arr1.length : arr2.length;
        j=arr2.length-1;
        for(int i=0; i<size; i++, j--){
            if(arr1[i]==arr2[j]){
                currentLength++;           
            }
            else{
                if(currentLength>1){
                    return currentLength;
                }else{
                    currentLength=0;
                }
            }
        }
        
        return currentLength;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        java.util.regex.Pattern pattern = null;
        pattern=java.util.regex.Pattern.compile(needle);
        java.util.regex.Matcher matcher=pattern.matcher(haystack);
        int count=0;
        
        while(matcher.find()){
            count++;
        }
        return count;
    }

    @Override
    public String decodeURL(String input) {
        String output=input.replace("%20", " ").replace("%3A", ":").replace("%3D", "?").replace("%2F", "/");
        return output;
    }

    @Override
    public int sumOfNumbers(String input) {
        java.util.regex.Pattern p = null;
        p=java.util.regex.Pattern.compile("[-]?[+]?[0-9]+");
        java.util.regex.Matcher m=p.matcher(input);
        int sum=0;
        
        while(m.find()){
            sum+=new Integer(m.group());
        }
        
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        /*char[] arr1=A.toCharArray();
        char[] arr2=B.toCharArray();*/
        //boolean areAnagrams=false;
        
        char[] arr1;
        char[] arr2;
        String[] str1=A.split(" ");
        String[] str2=B.split(" ");
        int str1Size=0;
        int str2Size=0;
        
        /*The for-cycles below are to ensure that the sum of the letters 
        of the two strings (excluding blank spaces) are same.*/
        for(String s : str1){
            str1Size+=s.length();
        }
        
        for(String s : str2){
            str2Size+=s.length();
        }
        
        if(str1Size!=str2Size){
            return false;
        }
        arr1=A.toCharArray();
        arr2=B.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for(int i=0; i<arr1.length; i++){
            if(!(arr1[i]==arr2[i])){
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        for(int i=0; i<=string2.length()-string.length(); i++){
            if(areAnagrams(string, string2.substring(i, string.length()+i)))
                return true;
        }
        
        return false;
    }
    
    public static void convertToGreyscale(String imgPath){
        //String filePath=imgPath.replaceAll("\\", "\\\\");
        BufferedImage img=null;
        File input=null;
        File outputFile=null;
        int width;
        int height;
        int rgb;
        int r;
        int g;
        int b;
        int grayLevel;
        int gray;
        
        try {
            input=new File(imgPath);
            System.out.println();
            img=ImageIO.read(input);
        } catch (IOException e) {
            System.out.println("Cannot open image.");
            e.printStackTrace();
        }
        
        width=img.getWidth();
        height=img.getHeight();
        
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                rgb=img.getRGB(i, j);
                r = (rgb >> 16) & 0xFF;
                g = (rgb >> 8) & 0xFF;
                b = (rgb & 0xFF);
                grayLevel = (r + g + b) / 3;
                gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
                img.setRGB(i, j, gray);
            }
        }
        
        outputFile=new File(input.getAbsolutePath().toString().replace(".jpg", "_grayscale.jpg"));
        try {
            ImageIO.write(img, "jpg", outputFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
    
    /* A test main for convertToGreyScale(String imgPath) method */
    public static void main(String[] args){
        convertToGreyscale(".\\house.jpg");
    }

}
