public class Ex2_03_1_Janken {
	
	public static void main(String[] args) {
		
		/*<シナリオ①>
		**コマンドライン引数より3つの文字列を受け取る
		*/
		String nameP1      = args[0] ; //ジャンケンを行うプレイヤー1の名前
		String nameP2      = args[1] ; //ジャンケンを行うプレイヤー2の名前
		String nameReferee = args[2] ; //審判の名前
		
		
		/*<シナリオ②>
		**2名のプレイヤー及び審判を場に登場させる（インスタンス化する）
		*/
		Ex2_03_1_Player  p1      = new Ex2_03_1_Player(  nameP1 ) ;   //プレイヤー1をインスタンス化
		Ex2_03_1_Player  p2      = new Ex2_03_1_Player(  nameP2 ) ;   //プレイヤー2をインスタンス化
		Ex2_03_1_Referee ref     = new Ex2_03_1_Referee( nameReferee ) ;   //審判をインスタンス化
		
		
		/*<シナリオ③>
		**それぞれのプレイヤーに手を握らせる
		*/
		//握らせる前に「じゃんけん・・・ぽん！！！！！」と審判が言う
		ref.startJanken();
		
		//それぞれのプレイヤーに手を握らせる
		p1.makeHandStatus();
		p2.makeHandStatus();
		
		//それぞれのプレイヤーがどんな手を出したか審判が言う
		ref.checkHand(p1);
		ref.checkHand(p2);
		
		
		/*<シナリオ④>
		**審判が勝敗を判定し、結果を言う
		*/
		ref.judgeJanken(p1,p2);
		
		
	}
}
