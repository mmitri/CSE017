public class Test{
    public static void main(String[] args) {

        // Stack of type generic
        Stack<String> cities = new Stack<>();
        cities.push("Bethlehem");
        cities.push("Merrick");
        cities.push("Austin");
        cities.push("Boston");
        // cities.push(122);
        // This would cause an error because 122 is not of type String
        System.out.println(cities);
        System.out.println(cities.peek());
        System.out.println(cities);
        System.out.println(cities.pop());
        System.out.println(cities);

        // Stack of type Object
        StackObject names = new StackObject();
        names.push("John");
        names.push("Lilly");
        names.push("Emmit");
        names.push("Julia");
        names.push(122);
        System.out.println(names);

        // Pair<Integer, String> p1,p2;
        // p1 = new Pair<>(12345,"Lehigh");
        // p2 = new Pair<>(2121212, "Pizza");
        // System.out.println(p1);
        // System.out.println(p2);

        // Pair<String, String> ps1, ps2;
        // ps1 = new Pair<>("Albany", "New York");
        // ps2 = new Pair<>("Boston, Massachusets");
        // System.out.println(ps1.equals(ps2));

        Integer[] numbers = {22,11,35,27,55};
        String[] strings = {"Kiwi", "Apple","Orange", "Banana", "Blueberries"};
        // ObjectStack[] stacks = {new ObjectStack(), new ObjectStack()};
        sort(numbers);
        printArray(strings);
        sort(strings);
        printArray(numbers);
        // sort(stacks);
    }
    //Print array from slides for generic type
    public static <E> void printArray(E[] list) {
            System.out.print("[ ");
            for (int i=0; i<list.length; i++)
            System.out.print(list[i] + " ");
            System.out.println("]");
            }

    //Selection sort from slides for generic type
        public static <E extends Comparable<E>> void sort(E[] list){
            int currentMinIndex;
            E currentMin;
            for (int i=0; i<list.length-1; i++){
                currentMinIndex = i;
                currentMin = list[i];
                for(int j=i+1; j<list.length; j++){
                    if(currentMin.compareTo(list[j]) > 0){
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
