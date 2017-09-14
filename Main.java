public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //New Circular List
        CircularSelfOrganisingSLL<Integer> l = new CircularSelfOrganisingSLL<Integer>();

        //Add Elements
        l.addToTail(-30);
        l.addToTail(6);
        l.addToTail(20);
        l.addToTail(310);
        l.addToTail(0);

        //Print out list so far
        System.out.println(l);

        //Access elements in list and print out list after each access
        l.access(20);
        System.out.println(l);
        l.access(6);
        System.out.println(l);
        l.access(310);
        System.out.println(l);
        l.access(310);
        System.out.println(l);
        l.access(20);


        //print round trip
        l.printRoundtrip(310);
        
        //Deletes elements from list
        System.out.println(l);
        l.deleteFromTail();
        System.out.println(l);
        l.deleteFromTail();
        System.out.println(l);
        l.deleteFromTail();
        System.out.println(l);

        l.printRoundtrip(310);
    }


}
