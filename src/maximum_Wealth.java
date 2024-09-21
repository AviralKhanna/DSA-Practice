class maximum_Wealth {
    public int maximumWealth(int[][] accounts) {
int amount;
int i=0;
int j=0;
int max= accounts[i][j];
        for ( i =0 ; i < accounts.length; i++){  amount =0;
         for (j =0 ; j < accounts[i].length; j++)
         {
            amount +=accounts[i][j];

         } 
if (max< amount)

{
    max=amount;
   
}

        } return max;
        
    }
public static void main(String[] args) {
    maximum_Wealth ls = new maximum_Wealth();
    int [][] arr= {
        {1,13,5,4},
        {4,3,0,4},
        {4,3}
    };
    int ans = ls. maximumWealth(arr);
    System.out.println(ans);
}}