package apartmentsJDBC;

import java.util.Scanner;

public class Questions {

    private int district;
    private int nRoom;
    private int price;
    private int from;
    private RequestJDBC rj;

    public Questions() {
    }

    public RequestJDBC requester() {

        Scanner sc = new Scanner(System.in);


        System.out.println("select preferred area the district");
        System.out.println("1: Obolon");
        System.out.println("2: Center");
        System.out.println("3: Nivki");
        System.out.println("4: All offers");
        System.out.print("-> ");
        district = sc.nextInt();
        if (district <= 0 || district >= 5) {
            return null;
        }
        System.out.println("select number of the room");
        System.out.println("1: 1");
        System.out.println("2: 2");
        System.out.println("3: 3");
        System.out.println("4: All offers");
        System.out.print("-> ");
        nRoom = sc.nextInt();
        if (nRoom <= 0 || nRoom >= 5) {
            return null;
        }
//        System.out.println("select preferred price of the apartment");
//        System.out.println("1: from 0 to 50 000");
//        System.out.println("2: from 50 001 to 100 000");
//        System.out.println("3: more then 100 001");
//        System.out.print("-> ");
//        price = sc.nextInt();
//        if (price <= 0 || price >= 4) {
//            return null;
//        }
        price =3;

        System.out.println("Do you want to see all the offers or only from the owners");
        System.out.println("1: all the offers");
        System.out.println("2: only from the owners");
        System.out.println("3: only from the agents");
        System.out.print("-> ");
        from = sc.nextInt();
        if (from <= 0 || from >= 4) {
            return null;

        }
        return rj = new RequestJDBC(district, nRoom, price, from);


    }


}


