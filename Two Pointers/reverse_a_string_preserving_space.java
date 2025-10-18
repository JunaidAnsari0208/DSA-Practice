public class reverse_a_string_preserving_space{
    
    public static String reverseWithSpacesIntact(String S){
        /* 
        // Native approach
        char[] arr = S.toCharArray();
        StringBuilder temp = new StringBuilder();
        for(char c: arr){
            if(c != ' ')
                temp.append(c);
        }

        temp.reverse();

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(char c: arr){
            if(c == ' ') ans.append(' ');
            else ans.append(temp.charAt(j++));
        }
        return ans.toString();
        */

        // Better Approach is using a Stack
        // Optimal approach is just 2 pointers on 2 ends and keep swapping
        char[] arr = S.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] == ' ')
                left++;
            else if(arr[right] == ' ')
                right--;
            else{
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args){
        String test = reverseWithSpacesIntact("Kill yourself");
        System.out.println(test);
    }
}