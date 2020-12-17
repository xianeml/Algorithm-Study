package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class EventAvailableCapacity {

	protected Queue<Integer> ticketRequests;
	protected int availableCapacity;

	public EventAvailableCapacity(int maxCapacity) {
		ticketRequests = new LinkedList<Integer>();
		availableCapacity = maxCapacity;
	}

	/*
	 * 큐는 인터페이스이기 때문에 생성자에서 인스턴스화할 땐 구체적인 클래스를 사용해야한다. 
	 * 링크드리스트를 사용하지만 큐처럼 다룬다.
	 * availableCapacity는 이벤트를 위해 서비스하고 팔수있는 최대티켓 갯수를 나타낸다.
	 */

	public void addTicketRequest(int numPeople) {
		ticketRequests.add(numPeople);
	}

	// 어떤 사람이 티켓을 요청하면 큐의 rear에 사람 수를 추가한다.

	public int processUntilNoCapacity() {
		int numRequestProcessed = 0;
		while (!ticketRequests.isEmpty()) {
			int remainAfterRequest = (availableCapacity - ticketRequests.peek());
			if (remainAfterRequest < 0)
				return numRequestProcessed;
			availableCapacity -= ticketRequests.remove();
			numRequestProcessed++;
		}
		return 0;
	}
	
	/*
	 * numRequestProcessed: 처리완료한 요청의 수를 추적한다.
	 * 이 처리는 우리가 초기화한 availableCapacity를 넘지 않게 해야한다.
	 * remainAfterRequest: 이 요청이 끝나고 티켓이 얼마나 남아있을지 일단 계산해보자.
	 * ticketRequests.peek(): 큐의 맨 앞에있는 값을 리턴한다.
	 * 만약 이 값이 음수라면: 요청이 정원을 초과했다면, 요청처리안함. 0 리턴.
	 * 큐의 맨앞에 있는 애를 삭제하면서 정원값도 줄인다.
	 * 마지막으로 처리완료를 카운팅한다.
	 */
	
}
