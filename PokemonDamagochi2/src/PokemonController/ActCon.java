package PokemonController;

import java.util.Scanner;

public class ActCon {
	Scanner sc = new Scanner(System.in);
	
	public void Start() { //시작 시 프롤로그
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
	
	// 채찍질
	// 놀아주기
	// 명상하기
	
	// 메인페이지 이동
	
	// 포켓몬 상태
	

}
