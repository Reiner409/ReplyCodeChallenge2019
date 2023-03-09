package it.ringmaster.fantastici4.rc19;

import it.ringmaster.fantastici4.rc19.structures.Mappa;
import it.ringmaster.fantastici4.rc19.structures.tiles.Customer;
import it.ringmaster.fantastici4.rc19.structures.tiles.Reply;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }


    public Reply createReplyNearCustomer(Mappa map, Customer customer){
        Reply newReply;

       if(customer.getX() < map.getWidth() - 2){
           newReply = new Reply(customer.getX() + 1, customer.getY());
           newReply.addPath("L");
       }
       else{
           newReply = new Reply(customer.getX() - 1, customer.getY());
           newReply.addPath("R");
       }

       return newReply;
    }

    public List<Reply> getReplyOffices(Mappa map, Customer[] customers){
        List<Reply> offices = new ArrayList<>();

        return offices;
    }

    public static void main(String[] args) {

        File input = new File("D:/Reply_Code_Challenge/input/1_victoria_lake.txt");
        try(Scanner sc = new Scanner(input)) {

            String[] line = sc.nextLine().split(" ");
            int width = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            int o = Integer.parseInt(line[3]);

            Mappa map = new Mappa(width, height, c, o);
            Customer[] customers = new Customer[c];
            Reply[] replies = new Reply[o];

            /* Init customer headquarters */
            for (int i = 0; i < c; i++) {
                String[] coords = sc.nextLine().split(" ");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                double reward = Integer.parseInt(coords[2]);
                customers[i] = new Customer(x, y, reward);
            }

            /* Init the map */
            for (int i = 0; i < height; i++) {
                char[] lineChar = sc.nextLine().toCharArray();
                for (int j = 0; j < width; j++) {
                    map.addTerrain(lineChar[j], j, i);
                }
            }

            System.out.println(map);

            //Arrays.sort(customers);

            Reply newReply;
            for(int i=0; (i < customers.length && i < replies.length); i++){
                if(customers[i].getX() < map.getWidth() - 2){
                    newReply = new Reply(customers[i].getX() + 1, customers[i].getY());
                    newReply.addPath("L");
                }
                else{
                    newReply = new Reply(customers[i].getX() - 1, customers[i].getY());
                    newReply.addPath("R");
                }

                replies[i] = newReply;
            }

            /* PRINT OUTPUT */
            printOutput(replies);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void printOutput(Reply[] replies) {
        for (Reply r: replies) {
            for (String path : r.getPathsToOffices()) {
                System.out.println(String.format("%d %d %s", r.getX(), r.getY(), path));
            }
        }
    }

}
