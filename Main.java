/***************************************************************************************
Author: Patrick Vandergrift
Date: Aug 30, 2026
Description: Creates a report of quarterback players highest rating to lowest
***************************************************************************************/
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main 
{
  public static void main(String[] args) 
  {
    ArrayList<Quarterback> qbPlayers = new ArrayList<>();
    try
    {
      BufferedReader fileInput = new BufferedReader(new FileReader("quarterbacks.txt"));  //Read in file
      PrintWriter fileOutput = new PrintWriter("results.txt");                            //Output to file
      String formatOne = "%-15s | %-5s | %-5s | %-5s | %-5s |%-4s | %-7s%n";              //Formatting
      String formatTwo = "%-15s | %-5s | %-5s | %-5s | %-5s |%-4s | %-7.2f%n";
      String line = "---------------------------------------------------------------------------
      -----------------------------------------------------------------------";
      String temp; //Holds temperary values
      while((temp = fileInput.readLine()) != null)  //Logic Case: Take inputs from file
      {
        String[] playerData = temp.trim().split("\\s+");
        if(playerData.length < 6)
        {
          continue;
        }
        
        Quarterback player = new Quarterback();
        player.setName(playerData[0]);
        player.setAttempt(Integer.parseInt(playerData[1]));
        player.setComp(Integer.parseInt(playerData[2]));
        player.setYards(Integer.parseInt(playerData[3]));
        player.setTDowns(Integer.parseInt(playerData[4]));
        player.setIntercept(Integer.parseInt(playerData[5]));
        qbPlayers.add(player);
      }
      
      qbPlayers.sort(Comparator.comparingDouble(Quarterback::getRating).reversed());
      //qbPlayers.get(0).print(); //DEBUG CODE
      fileOutput.printf(formatOne, "Name", "Att", "Comp", "Yds", "TDs", "Int", "QP Rating");
      fileOutput.println("-------------------------------------------------------------------");
      for(int i=0; i < qbPlayers.size(); i++)  //Output Quaterback Information to terminal
      {
        fileOutput.printf(formatTwo, qbPlayers.get(i).getName(), qbPlayers.get(i).getAttempt(),
        qbPlayers.get(i).getComp(), qbPlayers.get(i).getYards(), qbPlayers.get(i).getTDowns(),
        qbPlayers.get(i).getIntercept(), qbPlayers.get(i).getRating());
      }
      fileOutput.close();
    } catch (FileNotFoundException e)  //Logic Case: File out found
    {
      System.out.print("Error: File Not Found");
    }
    catch (IOException e)  //Logic Case: Error reading file
    {
      System.out.printf("Error: Problem occurred when reading file, " + e.getMessage());
    }
  }
}
