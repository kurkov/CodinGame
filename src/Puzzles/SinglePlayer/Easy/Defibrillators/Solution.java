package Puzzles.SinglePlayer.Easy.Defibrillators;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();

        LON = LON.replace(',', '.');
        LAT = LAT.replace(',', '.');

        int N = in.nextInt();
        in.nextLine();

        ArrayList<Defibrillator> defibrillators = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] d = DEFIB.split(";");
            d[4] = d[4].replace(',', '.');
            d[5] = d[5].replace(',', '.');
            defibrillators.add(new Defibrillator(d[0], d[1], d[2], d[3],
                    Double.parseDouble(d[4]), Double.parseDouble(d[5])));
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String closestDefib = defibrillators.get(0).id;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < defibrillators.size(); i++) {
            double distance = getDistance(Double.parseDouble(LON), Double.parseDouble(LAT),
                    defibrillators.get(i).longitude, defibrillators.get(i).latitude);
            if (distance < minDistance) {
                minDistance = distance;
                closestDefib = defibrillators.get(0).id;
            }
        }

        System.out.println(defibrillators.get(Integer.parseInt(closestDefib)).name);

    }

    private static double getDistance(double longitudeA, double latitudeA, double longitudeB, double latitudeB) {
        double x = (longitudeB - longitudeA) * Math.cos((latitudeA + latitudeB) / 2);
        double y = latitudeB - latitudeA;
        return sqrt(pow(x, 2) + pow(y, 2)) * 6371;
    }

    private static class Defibrillator {
        String id;
        String name;
        String address;
        String phone;
        double longitude;
        double latitude;

        Defibrillator(String id, String name, String address, String phone, double longitude, double latitude) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }
}