public class FinalExam{
    public static void main(String[] args){
        final int iterations = 0;
        System.out.println("Hello World");
        System.out.println(cc("Stay healthy!", 't'));
        for(int n=0;n<100;n++){
            timeComplex(n);
            System.out.println("Iterations for " + n +": " + iterations);
        }
        System.out.println(iterations);
    }
    public static int cc(String s, char c){
        return cc(s,c,0);
    }
    public static int cc(String s, char c, int index){
        if(index >= s.length()){
            return 0;
        }else if(s.charAt(index) == c){
            return 1+cc(s,c,index+1);
        }else{
            return cc(s,c,index+1);
        }
    }
    public static int timeComplex(int n){
        for (int i = 0; i < n/2; i++){ // n iterations
            iterations++;
            if(i%2 == 0){ // only execute half the time
                for (int j = 1; j < i; j *= 2){ // log base 2(n)
                    iterations++;
                    System.out.println(i * j);
                }
            }else{
                for(int j = i+10; j > 0; j /= 2){ // log base 2(n)
                    iterations++;
                    System.out.println(i * j * 2);
                }
           }
        }
        return iterations;
    }
}