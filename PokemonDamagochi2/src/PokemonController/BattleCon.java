package PokemonController;

import java.util.ArrayList;

import PokemonDAO.PokemonDAO;
import PokemonDTO.MuzDTO;
import PokemonDTO.PokemonDTO;

public class BattleCon {

	// 고정값 뮤츠 개체 만들어야함
	// HP150 ATK 20~50중에 랜덤수

	// 배틀메소드 실행

	// 배틀기능
	// 1. 공격 2.상처약

	// 만약 뮤츠의 HP가 0 이하라면 ..
	// 물리쳤다 친구가 되었따 축하한다는 멘트 출력 및 --> 메인페이지 이동 or 게임종료 선택지 출력

	// 만약 Player (T_ID)의 HP가 0 이하라면 ...
	// 실패했다 대충 위로하는 멘트 출력 --> 메인페이지 이동 or 게임종료 선택지 출력

	ArrayList<PokemonDTO> t_pdto = new ArrayList<PokemonDTO>();
	PokemonDAO pdao = new PokemonDAO();
	PokemonDTO pdto = new PokemonDTO(0, 0, 0, 0);
	MuzDTO MD = new MuzDTO();
	static PokemonController.ActCon pconAct = new PokemonController.ActCon();
	// 배틀기능

	public void Battle(String id) {
		t_pdto = pdao.state(id);
		while (true) {
			System.out.println("포켓몬 전투병기 뮤츠가 나타났다!");
			System.out.println("가라! " + t_pdto.get(0).getPNAME() + " 널 믿어");

			System.out.println("뮤츠가 공격했다!");

			int MDAtk = MD.getAttack();
			t_pdto.get(0).setHP((t_pdto.get(0).getHP() - MDAtk));

			System.out.println(MDAtk + "의 데미지를 입었습니다.");

			System.out.println("[ " + t_pdto.get(0).getPNAME() + " ]"+" 는 " + "[ "+t_pdto.get(0).getT_ID()+ " ] 를 슬프게 하지않기 위해 버텼다");
			System.out.println(t_pdto.get(0).getPNAME() + "의 혼신의 힘을 다한 공격!");
			MD.setHp(MD.getHp() - t_pdto.get(0).getATK());

			if (t_pdto.get(0).getHP() <= 0) {
				System.out.println("패배하였습니다... 채찍질이 부족한 것 같다");
				System.out.println("메인으로 이동합니다.");
				pconAct.main();
				break;
			} else if (MD.getHp() <= 0) {
				System.out.println("승리하였습니다!");
				System.out.println("뮤츠와의 배틀에서 승리하였습니다!");
				System.out.println("뮤츠와 친구가 되었다!" + "[ "+t_pdto.get(0).getT_ID()+ " ]"+" 는 포켓몬마스터가 되었다");
				System.out.println("메인으로 이동합니다.");
				// 크레딧 
				pconAct.main();
				break;
			}

		}

	}

}
