package Queue;

public class Node<HerhangiBirTip> {
	
	HerhangiBirTip veri;
	Node<HerhangiBirTip> sonraki;
	
	public Node(HerhangiBirTip veri,Node<HerhangiBirTip> sonraki)
	{
		
		this.veri=veri;
		this.sonraki=sonraki;
		
	}
	
	

}
