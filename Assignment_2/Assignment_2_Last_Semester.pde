
/*
Name : Mohammed Sabri
Student Number:20084832
Programme Name: Flowers
*///------------------//
  //      Source       //
  //------------------//


/*Brief description of the animation achieved: Drawing two flowers
Any sources referred to during the development of the assignment (no need to reference lecture/lab materials):

lecture Notes,practical work , processing.
https://processing.org/
https://www.youtube.com/results?search_query=class+in+processing

*/


import javax.swing.*;



 
     
 
 




float movementCloud = 0.0;
float movementFlower1 = 100.0;
float movementFlower2 = 100.0;

boolean reverseCloud = true;
boolean reverseFlower1 = true;
boolean reverseFlower2 = true;
void setup()
{
  size (500,500);
  background(0);
  noStroke();



}




 

{
JOptionPane.showMessageDialog(
null,
"Welcome to my Programm");
}
{
String name = JOptionPane.showInputDialog(

"Please enter your name to Start");
}


{
String name = " Hello My Name is Mohammed Sabri and Welcome to my program";
println("The string is:                 " +name);
println("The length of the string is: " + name.length());
println("The stringin uppercase is: " + name.toUpperCase());
println("The string in lowercase is: " + name.toLowerCase());

}



void draw()
{
background(0, 255, 255);

if (movementFlower1 <=75)
movementFlower1 = 200;
//first flower
fill(0, 128, 0);//green
//steam of the flower
rect(240, movementFlower1, 20, 410-movementFlower1);
fill(255, 255, 0);//yellow
ellipse(250,movementFlower1,50,50);

fill(255, 0, 0); //red
ellipse(299,movementFlower1,50,50);
ellipse(201,movementFlower1,50,50);  
ellipse(250,movementFlower1+50,50,50);
ellipse(250,movementFlower1-50,50,50);
ellipse(200,movementFlower1,50,50);

//floor
fill(0, 128, 0);//green
rect(0, 410, 500, 410);

//second flower
 if (movementFlower2 <=85)
movementFlower2 = 250;
fill(0, 128, 0);//green
rect(420,movementFlower2, 20, 410-movementFlower2);
fill(255,255,0);//yellow
ellipse(430,movementFlower2,30,30);

fill(255,0,0);//red
ellipse(401,movementFlower2,30,30);
ellipse(460,movementFlower2,30,30);  
ellipse(430,movementFlower2+30,30,30);
ellipse(430,movementFlower2-29,30,30);



//the sun
fill(255,255,0);
ellipse(50,55,60,60);

  
 //cloud drawing
 fill(255);
 ellipse(movementCloud, 70, 45, 45);
 ellipse(movementCloud+30, 55, 50, 50);
 ellipse(movementCloud+40, 80, 55, 55);
 ellipse(movementCloud+60, 58, 55, 55);
 ellipse(movementCloud+70, 80, 38, 38);
 ellipse(movementCloud+80, 60, 38, 38);
 
 
 //the movement cloud is stored on x
// the value 60 is stored on Y
// cloud moving code 
 if (movementCloud == 0)
  reverseCloud = true;
  if (movementCloud == 410)
  reverseCloud = false;
  if (!reverseCloud) {
   movementCloud = movementCloud - 0.5;
  } else {
  movementCloud = movementCloud + 0.5;    // the movement of the cloud
  }
  // move the flower 1
   if (movementFlower1 == 0)
  reverseFlower1 = true;
  if (movementFlower1 == 410 )
  reverseFlower1 = false;
  if (!reverseFlower1) {
   movementFlower1 = movementFlower1 - 0.07;
  } else {
  movementFlower1 = movementFlower1 - 0.07;    // the movement of the flower1
  }
 // move the flower 2
   if (movementFlower2 == 0)
  reverseFlower2 = true;
  if (movementFlower2 == 410)
  reverseFlower2 = false;
  if (!reverseFlower2) {
   movementFlower2 = movementFlower2 - 0.07;
  } else {
  movementFlower2 = movementFlower2 - 0.07;    // the movement of the flower 2
  }

 

}
 
