package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> filteredList = new ArrayList<>();

        for (int i = 0;i < intList.size();i++) {
            int elem = intList.get(i);
            if ((elem>0)&(elem%2 == 0)) filteredList.add(elem);
        }

        for (int j = filteredList.size()-1;j > 1;j--) {
            for (int i = 0;i < filteredList.size()-1;i++) {
                if (filteredList.get(i+1) < filteredList.get(i)) {
                    int tmp = filteredList.get(i);
                    filteredList.set(i,filteredList.get(i+1));
                    filteredList.set(i+1,tmp);
                }
            }
        }
        System.out.println("Первый способ:");
        filteredList.forEach(elem -> System.out.println(elem));

        StreamMain obj = new StreamMain();
        System.out.println("Второй способ:");
        obj.main();
	// write your code here
    }
}
