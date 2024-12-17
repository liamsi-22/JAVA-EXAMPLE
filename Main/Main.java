import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.LinkedList;

interface InnerMain {

    List<Integer> returnSpecifcNode1();
    // List<Integer> returnSpecifcNode2();
}
class Solution implements InnerMain{
    List<Integer> node = new LinkedList<>();
    public Solution(List<Integer> node){
        this.node = node;
    }

    List<Integer> returnSpecifcNode(){
        List<Integer> tmp = node;
        return tmp.stream().parallel()
                .filter(n -> n % 2 == 0)
                    .map(n -> n * 100).collect(Collectors.toList());
    }

    @Override
    public List<Integer> returnSpecifcNode1(){
        List<Integer> tmp = node;
        return tmp.stream().parallel()
                .filter(n -> n % 2 != 0)
                    .map(n -> n * 1).collect(Collectors.toList());
    }

    public void displayNode(List<Integer> returnSpecifcNode){
        System.out.println(returnSpecifcNode);
    }
}

public class Main {

    public static void main(String[] args){
        Solution data = new Solution(Arrays.asList(1, 3, 4, -3, 22));
        data.displayNode(data.returnSpecifcNode1());
    }
}