class Solution {
    public int shipWithinDays(int[] weights, int D) {
        //minimum is the maximum weight which should be shipped as single item
        int min = weights[0];
        //maximum is allitems shipped 
        int max = 0;
        for(int weight: weights){
            if(weight>min){
                min = weight;
            }
            max+=weight;
        }
        
        while(min<=max){
           int  mid = min + (max -min)/2;
            int partition = getPartition(weights, mid);
            if(partition <D){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        
        return min;
    }
    
    private int getPartition(int weights[], int mid){
        
        int sum = 0;
        int count = 0;
        for(int weight  : weights){
    
            if(sum+weight>mid){
                sum = weight;
                count++;
            }else{
                sum+=weight;
            }
            
        }
        return count;
    }
}
