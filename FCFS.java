import java.util.*;

public class FCFS{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Processes: ");
        int n = sc.nextInt();
        int pid[]=new int[n];
        int ar[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int ta[]=new int[n];
        int wt[]=new int[n];

        int temp;
        float avgwt=0,avgta=0;

        for(int i=0;i<n;i++){
            System.out.println("Enter Process "+(i+1)+" arrival time: ");
            ar[i]=sc.nextInt();
            System.out.println("Enter Process "+(i+1)+" burst time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }

        //sorting according to arrival time
        for(int i=0;i<n;i++){
            for(int j=0;j<n-(i+1);j++){
                if(ar[j]>ar[ar[j+1]]){
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;

                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;

                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(i==0){
                ct[i]=ar[i]+bt[i];
            }
            else{
                if(ar[i]>ct[i-1]){
                    ct[i]=ar[i]+bt[i];
                }
                else{
                    ct[i]=ct[i-1]+bt[i];
                }
                ta[i]=ct[i]-ar[i];
                wt[i]=ta[i]-bt[i];
                avgwt+=wt[i];
                avgta+=ta[i];
            }
            System.out.println("\nPID ARRIVAL BURST COMPLETE TURN WAITING");
        }

        for(int i=0;i<n;i++){
            System.out.println(pid[i] + " \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i] ) ;
        }

        sc.close();
        System.out.println("\naverage waiting time: "+ (avgwt/n));// printing average waiting time.
        System.out.println("average turnaround time:"+(avgta/n)); // printing average turnaround time.
    }
}
