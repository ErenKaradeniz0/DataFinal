package Queue;

public class JosephusProblemTest {

	public static void main(String[] args) {
		
		MyQueue<Integer> kimGitsinKuyrugu=new MyQueue<Integer>();
		
		int N=21; 
		int k=2;
		
		for(int i=1;i<=N;i++) kimGitsinKuyrugu.enqueue(i);
		
		while(kimGitsinKuyrugu.head.sonraki!=null)
		{
			for(int j=1;j<=k-1;j++)
			{
				kimGitsinKuyrugu.enqueue(kimGitsinKuyrugu.dequeue());
			}
			
			System.out.println(kimGitsinKuyrugu.dequeue()+" is killed!!!");
			//kimGitsinKuyrugu.dequeue()// killed!!
		}
		
		System.out.println("WINNER: "+kimGitsinKuyrugu.front());
		
		
		
		
		
		
		
		
		

	}

}
