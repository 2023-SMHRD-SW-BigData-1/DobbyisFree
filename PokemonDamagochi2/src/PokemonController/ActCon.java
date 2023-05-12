package PokemonController;

import java.util.ArrayList;
import java.util.Scanner;

import PokemonDAO.PokemonDAO;
import PokemonDTO.PokemonDTO;

public class ActCon {
	Scanner sc = new Scanner(System.in);
	PokemonDAO pdao = new PokemonDAO();
	PokemonDTO pdto = new PokemonDTO();
	static PokemonController.AsciiArt pconArt = new PokemonController.AsciiArt();
	int input;

	// 시작 시 프롤로그
	public void Start() {
		try {
			for (int i = 0; i < 1; i++) {

				System.out.println("포켓몬마스터가 되기 위해 모험을 떠난 '너!'와 친구들, 긴 여정을 마치고 환상의 포켓몬과의 최종결전을 앞두고 있다.");
				Thread.sleep(1000);
				System.out.println("결전에 앞서 혹독하고 처절한 트레이닝을 계획하는데...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 오박사님 등장시 대사
	public void Doctorate() {
		try {
			for (int i = 0; i < 1; i++) {
				pconArt.Okid();
				System.out.println("그동안 고생많았다 이제 근본중에 근본인 그 녀석만 남았구나! 그간 함께했던 수많은 에이스포켓몬중에서 3마리를 엄선했단다.");
				Thread.sleep(1000);
				System.out.println("아무리 그래도 다구리치는건 추잡하지 않니? 마지막으로 너와 함께할 포켓몬을 딱 1마리만 골라보렴");
			}
		} catch (Exception e) {
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

	public void act(String id) {
		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.print("1.채찍질  2.놀아주기  3.잠자기 4. 포켓몬 상태 확인 >> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				pdao.Whip(id);
				System.out.println("공격력 , 경험치가 올랐다!");
				System.out.println("체력이 30 깎였다!");
				break;
			case 2:
				pdao.Play(id);
				System.out.println("친밀도, 경험치가 올랐다!");
				System.out.println("체력이 30 깎였다!");
				break;
			case 3:
				pdao.Sleep(id);
				System.out.println("체력이 모두 회복되었다!");
				System.out.println("경험치가 올랐다!");
				break;
			case 4:
				ArrayList<PokemonDTO> t_pdto = pdao.state(id);
				for (PokemonDTO pdto : t_pdto) {
					if (pdto.getT_ID().equals(id)) {
						System.out.println("========================================================");
						System.out.printf("%4s\t%4s\t%4s\t%5s\t%5s\t%3s\n" , "트레이너명" , "HP" , "ATK" , "LOVE" , "EXP" , "포켓몬이름");
						
						System.out.printf("%4s\t%4d\t%4d\t%4d\t%4d\t%4s\n", pdto.getT_ID(),
								pdto.getHP(), pdto.getATK(), pdto.getLOVE(),
								pdto.getEXP(), pdto.getPNAME());
						System.out.println("========================================================");
					}
				}
				break;


			default:
				System.out.println("잘못 입력하셨습니다.");
				break;

			}
			
			
			// DB 능력치 값 불러오고 수정해서 다시 보내는 메소드

			// DB 능력치 값 불러오는 메소드 입력

			// .getLove , .getExp 로 대조해야할 것 같은데 어떻게 로직 짜야하는지 조금만 더 생각해봄
			// ArrayList로 담아야할것같다
			// if(친밀도(getLove)>20 && 경험치(getExp)>20){
			// 진화 메소드 실행 (스토리용 출력문 있어야함)
			// 배틀 메소드 실행
			// }else {
			// 충족하지 못하면 act 첫줄부터 반복하게 비워두기
			// }

			// DB 능력치 값 불러오는 메소드 입력
			// 만약 HP가 30미만이라면
			// 1번,2번 선택시에 HP가 부족합니다
			// act 첫줄부터 반복하게 비워두기

		}
	}

	// 메인페이지
	public void main() {
		int input = 0;

		while (input != 3) {
			pconArt.Progo();
			System.out.println();
			System.out.print("1. 회원가입 2. 로그인 3. 종료 ");
			System.out.print("선택 >>  ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				Start();
				System.out.print("당신의 [이름]을 알려주세요 >> ");
				String id = sc.next();
				System.out.print("트레이닝 중 갑작스러운 비상 상황에 대비하기 위해 당신의 [연락처]를 알려주세요 >> ");
				int pw = sc.nextInt();
				Doctorate();
				System.out.println();

				int pcode = 0;

				while (pcode != 3) {

					System.out.println("포켓몬그림"); // 포켓몬 그림 메소드 불러와주세요
					System.out.print("1.피카츄  2.이브이  3.치코리타");
					pcode = sc.nextInt();
					switch (pcode) {
					case 1:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					case 2:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					case 3:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					default:
						System.out.println("잘못 입력하셨습니다.");
						System.out.println("포켓몬 선택창으로 이동합니다.");
						System.out.println();
						break;

					}

				}

				break;
			case 2:
				System.out.println("로그인 선택하셨습니다.");
				System.out.print("ID 입력 > ");
				id = sc.next();
				System.out.print("PW 입력 > ");
				pw = sc.nextInt();
				// 로그인 DB 가져오는 메소드 (SELECT)
				PokemonDTO t_pdto = pdao.login(id, pw);
				if (t_pdto != null) {
					System.out.println("로그인 성공");
					System.out.println();
					act(id);

				} else {
					System.out.println("로그인 정보를 다시 확인해주세요. 메인화면으로 이동합니다.");
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.println();

				break;

			}
		}
	}

	// 포켓몬 상태
	// select 메소드로 불러와서
	// 이름 , hp , atk , love , exp만 출력

	// 진화창

}
