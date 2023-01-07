package Queue;

public interface Queue<HerhangiBirTip> {
	
	public Boolean isEmpty();
	public void enqueue(HerhangiBirTip item);
	public HerhangiBirTip dequeue();
	public HerhangiBirTip front();
	
	

}
