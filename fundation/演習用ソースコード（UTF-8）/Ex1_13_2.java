/*-< 演習：Ex1_13_2 >---------------------------------
コマンドライン引数で受け取った整数（A型：1, B型：2, O型：3, AB型：4）に応じて、
以下の実行結果を表示するプログラムを作成してください。
ただし、switch文を必ず使用してください。

  (A型)が入力された場合 ："あなたは几帳面な性格の方ですね？"
  (B型)が入力された場合 ："あなたはマイペースな性格の方ですね？"
  (O型)が入力された場合 ："あなたは大雑把な性格ですね？"
  (AB型)が入力された場合："あなたは天才肌な方ですね？"
  上記以外              ："数字の1～4で答えてください"

----------------------------------------------------*/
public class Ex1_13_2 {
	public static void main (String[] args) {

		//コマンドライン引数で好きな数字を1つ受け取る
		int bloodType = Integer.parseInt(args[0]);

		switch (bloodType){
			case 1:
				System.out.println("あなたは几帳面な性格の方ですね？");
				break;
			case 2:
				System.out.println("あなたはマイペースな性格の方ですね？");
				break;
			case 3:
				System.out.println("あなたは大雑把な性格ですね？");
				break;
			case 4:
				System.out.println("あなたは天才肌な方ですね？");
				break;
			default:
				System.out.println("数字の1～4で答えてください");
				break;
		}
		
		
		
		
	}
}
