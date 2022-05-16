public class FinalExamTest{
    public static void main(String[] args) {
      cc("Stay healthy!", 't');
      
    }
    public static int cc(String s, char c) {
      return cc(s, c, 0);
    }
    public static int cc(String s, char c, int index){
      if (index >= s.length())
        return 0;
      else if(s.charAt(index) == c)
        return 1 + cc(s, c, index+1);
      else
        return cc(s, c, index+1);
    }
  
}