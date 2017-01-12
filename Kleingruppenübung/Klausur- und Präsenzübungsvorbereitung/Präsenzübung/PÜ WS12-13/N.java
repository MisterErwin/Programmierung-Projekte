import java.util.*;

public class N {
  public static void main(String args[]){
    LinkedList<Integer> list = new LinkedList<>();

    list.addFirst(8);
    list.addFirst(7);
    list.addFirst(4);
    list.addFirst(3);

    Iterator<Integer> it = list.iterator();

    int modsum = 0;

    while(it.hasNext()){
      int k = it.next();
      System.out.println(k);
      modsum += k;
      System.out.println("modsum: " + modsum);
      if(modsum % 7 == 0){
        it.remove();
      }
    }
    for(int i : list){
      System.out.println(i);
    }
  }
}
