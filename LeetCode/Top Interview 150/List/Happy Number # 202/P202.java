// IT CAN ALSO BE DONE WITH THE FAST AND SLOW POINTER !!!

class Solution {
    public static boolean isHappy(int n) {
        int sum;
        List<Integer> val = new ArrayList<>(); // IMP FOR CHECKING THE CYCLICITY
        while(true){
            sum = 0;
            while(n!=0) {
                sum += (n%10) * (n%10);
                n/=10;
            }
            n = sum;
            if(n==1) return true;
            else if(val.contains(n)) break;
            else val.add(n);
        }

        return false;
    }
}
