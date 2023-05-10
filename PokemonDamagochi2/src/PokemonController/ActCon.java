package PokemonController;

import java.util.Scanner;

public class ActCon {
	Scanner sc = new Scanner(System.in);
	//시작 시 프롤로그
	public void Start() { 
	try {
		for (int i = 0; i < 1; i++) {
			System.out.println("포켓몬마스터가 되기 위해 모험을 떠난 '너!'와 친구들, 긴 여정을 마치고 환상의 포켓몬과의 최종결전을 앞두고 있다.");
			Thread.sleep(1000);
			 System.out.println("결전에 앞서 혹독하고 처절한 트레이닝을 계획하는데...");
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	
	}
	
	// 오박사님 등장시 대사
	public void Doctorate() {
	try {
		for (int i = 0; i < 1; i++) {
			System.out.println("그동안 고생많았다 이제 근본중에 근본인 그 녀석만 남았구나! 그간 함께했던 수많은 에이스포켓몬중에서 3마리를 엄선했단다.");
			Thread.sleep(1000);
			 System.out.println("아무리 그래도 다구리치는건 추잡하지 않니? 마지막으로 너와 함께할 포켓몬을 딱 1마리만 골라보렴");
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
	// 회원가입시 나오는 문구
	public void New() {
	      Scanner sc = new Scanner(System.in);
	      System.out.print("ID 입력 : ");
	      String ID = sc.next();
	      System.out.print("PW 입력 : ");
	      String PW = sc.next();
	      
	      System.out.print("함께할 Pokemon 선택 : ");
	      String Pokemon = sc.next();
	}
	
	// 로그인시 나오는 문구
	public void login() {
	      System.out.print("ID 입력 : ");
	      String ID = sc.next();
	      System.out.print("PW 입력 : ");
	      String PW = sc.next();
	}
	
	// 채찍질
	// 놀아주기
	// 명상하기
	
	// 메인페이지 이동
	
	// 포켓몬 상태
	

}
