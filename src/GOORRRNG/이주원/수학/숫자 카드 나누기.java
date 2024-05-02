class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        int resultA = gcdA;
        int resultB = gcdB;
        for(int i : arrayB) {
            if(i % gcdA == 0) {
                resultA = 0;
                break;
            }
        }
        for(int i : arrayA) {
            if(i % gcdB == 0) {
                resultB = 0;
                break;
            }
        }
        return Math.max(resultA, resultB);
    }
    
    int getGcd(int[] array) {
        int gcd = array[0];
        for(int i = 1; i < array.length; i++) {
            gcd = gcd(gcd, array[i]);
            if(gcd == 1)
                return gcd;
        }
        return gcd;
    }
    
    int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}