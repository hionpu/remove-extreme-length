import java.util.*;

public class removeExtremes {
    public static String[] removeExtremes(String[] arr) {
        // TODO:
        if ( arr.length == 0 ) return null;
        //arr를 list로 변경(나중에 remove()쓰기위해서)
        LinkedList<String> arrList = new LinkedList<String>(Arrays.asList(arr));

        // arr의 각 element의 length를 element로 가지는 Array 생성
        Integer[] lengthArr = new Integer[arr.length];

        for (int i = 0 ; i < arr.length ; i++) {
            lengthArr[i] = arr[i].length();
        }
        // lengthArr를 linkedlist로 변경
        LinkedList<Integer> lengthList = new LinkedList<>(Arrays.asList(lengthArr));

        // linkedArr의 최솟값, 최댓값 구함
        int min = (int) lengthList.stream().reduce(Integer::min).orElse(-1);
        int max = (int) lengthList.stream().reduce(Integer::max).orElse(-1);

        // 각 값에 해당하는 인덱스 반환, 같은 길이면 인덱스가 큰것을 반환
        int minIndex = lengthList.indexOf(min);
        int maxIndex = lengthList.indexOf(max);
        for (int i = 0 ; i < lengthList.size() ; i++) {
            if (lengthList.get(i) == min) minIndex = i;
        }
        for (int i = 0 ; i < lengthList.size() ; i++) {
            if (lengthList.get(i) == max) maxIndex = i;
        }
        System.out.println(Arrays.toString(lengthList.toArray()));
        System.out.println(min + "," + max);
        System.out.println(minIndex + "," + maxIndex);

        // 인덱스에 해당하는 값 제거
        arrList.remove(Math.max(minIndex,maxIndex)); arrList.remove(Math.min(minIndex,maxIndex));

        return arrList.toArray(new String[arrList.size()]);

    }
    public static void main(String[] args) {
    String[] arr = {"a", "b", "c", "def"};
        System.out.println(removeExtremes.removeExtremes(arr));

    }
}
