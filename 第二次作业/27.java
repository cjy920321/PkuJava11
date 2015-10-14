public class Solution {
    public int removeElement(int[] A, int elem) {
        int startPosition = 0;
        for (int i = 0; i < A.length; i++) {
       // for (int i = 0 ; i< len; ++i){
       //  while (A[i]==elem && i< len) {
       //      A[i]=A[--len];
       //   }
            if (A[i] != elem) {
                A[startPosition] = A[i];
                startPosition++;
            }
        }
        return startPosition;
    }
}