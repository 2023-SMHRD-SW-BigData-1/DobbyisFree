package View;

import java.util.Scanner;

import PokemonController.ActCon;
import PokemonDAO.PokemonDAO;

public class Main {

	static PokemonController.ActCon pconAct = new PokemonController.ActCon();
	static PokemonController.AsciiArt pconArt = new PokemonController.AsciiArt();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PokemonDAO pdao = new PokemonDAO();

		
		
		pconAct.main();

		pconAct.act();
		// 친밀도 == 20 && 경험치 == 20 이면 진화창 출력
		// 배틀메소드 실행

//			System.out.println("게임종료를 선택하셨습니다.");
//			System.out.println("게임을 종료합니다.");
//			// 게임종료메소드
//	
//
//			System.out.println("잘못 입력 하셨습니다.");
//			System.out.println("메인화면으로 이동합니다.");

		// 출력문 입력 부탁드립니다.


		// 키우기
		System.out.println("1.행동 선택   2.메인페이지");
		int start = sc.nextInt();

		System.out.println("<< 1.채찍질하기 2.놀아주기 3.잠자기 >> ");
		int training = sc.nextInt();

		System.out.println("---는 기분 좋은듯하다^^ 공격력이 올랐다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("하하하하하하하~호호호호호호~흐헤흐헤흐히흐히히히히~ 친밀도가 올랐다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("우리 ---는 자는 모습이 제일 귀엽당>< HP가 회복되었다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("오잉?! ---의 상태가?");
		System.out.println("---는 ---로 진화했다!");

		// 최종배틀
		System.out.println("포켓몬 전투병기 뮤츠가 나타났다!");

		System.out.println("뮤츠와의 배틀에서 승리하였습니다!");

		System.out.println("뮤츠와 친구가 되었다! ID는 포켓몬마스터가 되었다");

		System.out.println("어머! ---는 싸우는 사이 뮤츠와 정분이 났다! ♡♡♡");

		// 패배
		System.out.println("패배하였습니다... 채찍질이 부족한 것 같다");
		// 돌아가기

	}

}
