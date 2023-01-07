package Queue;

public class MyQueue<HerhangiBirTip> implements Queue<HerhangiBirTip> {

	
	 Node<HerhangiBirTip> head,tail;
	 
	 public MyQueue() {
		
		 head=null;
		 tail=null;
		 
	}
	 
	@Override
	public Boolean isEmpty() {
		
		return head==null;
	
	}

	@Override
	public void enqueue(HerhangiBirTip veri) {
	
		
		if(isEmpty()==false)
		{
			Node<HerhangiBirTip> yeni=new Node<HerhangiBirTip>(veri, tail.sonraki);
			tail.sonraki=yeni;
			tail=yeni;
			
			
		}
		else
		{
			head=new Node<HerhangiBirTip>(veri,null);
			tail=head;
			
		}
		
	}

	@Override
	public HerhangiBirTip dequeue() {
		HerhangiBirTip returnResult=head.veri;
		head=head.sonraki;
		return returnResult;
	}

	@Override
	public HerhangiBirTip front() {
		// TODO Auto-generated method stub
		return head.veri;
	}

	
}
