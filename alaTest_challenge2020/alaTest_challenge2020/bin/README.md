Thank you so much for the programming challenge. 
Here you can view a zip folder, CV and README file.
Download the zip file and import the zip folder to access the program.   
The tele folder holds the tele.java file which runs the input txt file  
and the Company.java file is a custom class I made to store operators.  
  
The test folder contains test cases, running AllTests.java runs them all together.  
other .txt files have also been included, which are called upon in the test suites.  
  
To input your own custom operator information, store the info in a .txt file,  
save it in the root folder alaTest_challenge2020, and then run tele.java.  
Upon running tele.java, type in the file name when prompted, and the desired phone  
number to find the code for.  
  
  
ABOUT THE PROGRAM:  
The operators require a degree of sorting, and the fastest any sorting algorithm can  
achieve is O(nlogn), so I went with storing each operator as a class called company  
and then placing them in a vector. Each company class contains a map of extensions,  
which takes logn time to search for an input number of m digits, assuming there are  
n extension-price pairs for each operator. Assuming there are k operators, the worst-case  
runtime of the program is O(kmlogn). In my implementation I am able to optimize this  
slightly by starting my search from the input number's first x digits, where x is the  
number of digits of the longest extension for an operator. Thus, the runtime of this  
program is streamlined to O(klogn).