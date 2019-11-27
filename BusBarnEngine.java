import java.util.*;
import java.io.*;

public class BusBarnEngine {

   public static void main(String[] args) {
      Random rand = new Random();
      Set<Bus> barn = new TreeSet<>();
      Map<Integer,String> routes = new TreeMap<>();
      
      addBuses(barn, rand);
      setRoutes(routes, "routes.txt");
      //printBarn(barn);
      printBarnRoutes(barn, routes);
   }
   
   public static void addBuses(Set<Bus> barn, Random r) {
      int busesToAdd = r.nextInt(10)+1; // 1-10 (it's the high - the low +1)
      for(int i = 0 ; i < busesToAdd; i++){
         Bus b = new Bus();
         b.setRoute(r.nextInt(31)+100);
         barn.add(b);
      }
   }
   
   public static void printBarn(Set<Bus> barn) {
      System.out.println("\nBuses at the Bus Barn");
      System.out.println("=====================");
      for(Bus b : barn) {
         System.out.println(b);
         //System.out.println("+");
      } 
      if(barn.isEmpty()) { System.out.println("The bus barn is empty!"); }
   }
   
   public static void setRoutes(Map<Integer,String> routes, String fileName) {
      try {
         Scanner file = new Scanner(new File(fileName));
         while(file.hasNextInt()){
            int routeNum = file.nextInt();
            String trash = file.nextLine();// trash the new line after the character
            String routeDesc = file.nextLine();
            routes.put( routeNum, routeDesc);   
         }
      } catch(FileNotFoundException e) {
         System.out.println(fileName + " not found.");
      }
      
      System.out.println("Routes = " + routes);
   }
   public static void printBarnRoutes(Set<Bus>barn,Map<Integer, String>routes){
      System.out.println("\nBuses at the Bus Barn");
      System.out.println("=====================");
      for(Bus b : barn){
            if(routes.containsKey(b.getRoute())){
               System.out.println(b + "("+routes.get(b.getRoute())+")");
            }else{System.out.println(b);}
            
         
      }
      }
   }
         

