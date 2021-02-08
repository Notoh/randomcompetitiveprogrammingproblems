import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialStreams = scanner.nextInt();
        List<Double> streams = new ArrayList<>();
        for(int i = 0; i < initialStreams; i++) {
            streams.add((double) scanner.nextInt());
        }
        int in;
        while((in = scanner.nextInt()) != 77) {
            //all this code uses weird 0->1 index fuckery so the variable names are confusing
            if(in == 99) {
                int streamSplit = scanner.nextInt();
                int percent = scanner.nextInt();
                double initial = streams.get(streamSplit-1);
                double left = (initial * (double)percent/100.0);
                double right = initial-left;
                streams.add(streamSplit, right);
                streams.set(streamSplit-1, left);
            }
            if(in == 88) {
                int leftStream = scanner.nextInt();
                double left = streams.get(leftStream-1);
                double right = streams.get(leftStream);
                streams.remove(leftStream);
                streams.set(leftStream-1, left+right);
            }
        }
        StringBuilder output = new StringBuilder();
        for(Double doub : streams) {
            output.append(Math.round(doub)).append(" ");
        }
        output.setLength(output.length() - 1); //delete last space
        System.out.println(output);
    }
}