import java.util.*;

public class Main {
    public static void main (String[] args){
        // 4 3 2 4 3 2 0 0 0 4 0
        // a b d k r
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] str = scanner.nextLine().split(" ");

        for (String s : str) {
            nums.add(Integer.parseInt(s, 2));
        }

        for (Integer num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        String[] alphabet = scanner.nextLine().split("");
        System.out.println(Arrays.toString(alphabet));

        LinkedList<String> characters = new LinkedList<>(Arrays.asList(alphabet));

       Integer number = scanner.nextInt();

        List<String> resultMtf = mtf(nums, characters);
        List<String> resultBwt = bwt(resultMtf, number);
        System.out.println(resultBwt);
    }

    public static List<String> mtf(List<Integer> nums, LinkedList<String> characters){
        List<String> result = new ArrayList<>();
        for (Integer num : nums) {
            String character = characters.get(num);
            result.add(character);
            characters.remove(character);
            characters.addFirst(character);
        }
        return result;
    }

    public static List<String> bwt(List<String> characters, Integer number){
        List<String> result = new ArrayList<>();
        List<String> sortList = new ArrayList<>(characters);
        Collections.sort(sortList);
        List<Node> sortListFreq = addFreq(sortList);
        List<Node> listFreq = addFreq(characters);
        System.out.println(sortListFreq);
        System.out.println(listFreq);
        result.add(sortListFreq.get(number).character);
        int k = number;
        for (int j = 0; j < characters.size(); j++){
            for (int i = 0; i < characters.size(); i++){
                if (Objects.equals(sortListFreq.get(k).character, listFreq.get(i).character)
                && Objects.equals(sortListFreq.get(k).freq, listFreq.get(i).freq)){
                    k = i;
                    result.add(sortListFreq.get(k).character);
                }
                if (result.size() == characters.size()){
                    break;
                }
            }
            if (result.size() == characters.size()){
                break;
            }
        }
        return result;
    }

    public static List<Node> addFreq(List<String> characters){
        List<Node> result = new ArrayList<>();
        Map<String, Integer> temp = new HashMap<>();
        for (String character : characters) {
            result.add(new Node(character, 0));
        }
        for (int i = 0; i < characters.size(); i++){
            if (temp.containsKey(result.get(i).character)){
                temp.put(result.get(i).character, temp.get(result.get(i).character) + 1);
                result.get(i).setFreq(temp.get(result.get(i).character));
            } else {
                temp.put(result.get(i).character, 0);
            }
        }
        return result;
    }
}

