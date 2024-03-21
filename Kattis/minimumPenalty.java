class Solution {
    public  static int bestClosingTime(String customer) {
        char[] customers = customer.toCharArray();
        int penalties[] = new int[10_0000];
        int minPenalty = 100;
        int closingTime = 0;
        for(int i=0; i < customers.length+1; i++){
            for(int j=i; j <customers.length; j++){
            if(Character.compare(customers[j], 'Y') == 0){
                penalties[i]++;
            }
            }
            if(i > 0){
            for(int k=0; k<i;k++){
                if(Character.compare(customers[k], 'N') == 0){
                penalties[i] = penalties[i]+1;
            }
            }
            }
        }
        for(int i=0; i<customers.length+1; i++){
            if(penalties[i] < minPenalty){
                minPenalty = penalties[i];
                closingTime = i;
            }
        }
//        System.out.println("customers length: ",customers.length);
//        System.out.println();
        for(int i =0; i<customers.length; i++){
            System.out.print(penalties[i]+" ");
        }
        return closingTime;
    }
    public static void main(String[] args){
    System.out.println(bestClosingTime("YNYYNNYYNYNNNNYNNNYYNNYYYNNYYYYYNYYYYYNNNNYNNYNNYNYYNNNNNYYYYYNNNNYNNNYYYYYYNNYYYYYYNYNNNNNNNNNYNYYYNNYNYYYYYNYYYYYNYNYYNYNYYYYNYYNYNNYNYYNYNNYYNYNYYYYNNNYYNNNNNYYYYNNNNYNNNNNNNNNYYYNYYYNYNYNNNNNNNNNNYYYYNNYYYYNNYNYYNNYNNYNNNYNYYNYYNYNNNYYNNNYYNNYYNYNYYYNYYYYYNNYYNNYNNNYNYNYYNNYYYYNYNYNNYNNNNNYNYYNNYNNYNNNNYNYNNNNNYNYNNNYYNNYNNYYNYNNYYNNYNYYYNNYYYNYNNYNNYYNNNYYNYYYNYYNNNYNNNNNNNNNNYYNNYYNYYNYNNYNNYNYNYNYNNYYNYNYYNNYNNYNYNYYNNNNNNNYYYYYYNNYYYYNYNNNNNNYYYNNNYYYNNYNYNNNYYYNYYNNNYNYNYYNNNNYYNYYYYYYY"));;
    }
}