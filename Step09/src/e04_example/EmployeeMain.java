package e04_example;

import java.util.ArrayList;

public class EmployeeMain {

	public static void main(String[] args) {
		PermanentWorker pwoker = new PermanentWorker(3600, "김철수");
		pwoker.printEmployeeInfo();
		
		PartTimeWorker partTimeWorker = new PartTimeWorker("홍길동", 100, 15000);
		partTimeWorker.printEmployeeInfo();
		
		ForeignWorker fworker = new ForeignWorker(4500, "박영수", 2);
		fworker.printEmployeeInfo();
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(fworker);
		list.add(partTimeWorker);
		list.add(pwoker);
		list.add(new ForeignWorker(3600,"문수영",1));
		
		//반복문 - 모든 직원의 정보를 출력
		for(Employee e : list)
			e.printEmployeeInfo();
		
		//전체 지출되는 급여 금액 출력
		int totalPay = 0;
		
		for(Employee e : list)
			totalPay += e.getPay();
		
		System.out.println("이번 전체 지출되는 급여 비용 : "+ totalPay);
		
	}

}




