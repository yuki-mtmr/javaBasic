/*-< 演習：Ex1_11_2 >---------------------------------
do-while文を使用して、6の目がでるまでサイコロを降り続けるプログラムを作成してください。
※1～6までのランダムなint型の数値（出目）を取得する方法 ： 1 + (int)(Math.random() * 6.0)
※サイコロを振るたびに出目を画面に表示してください。
※6の目が出たら「6が出たのでを終了します」と表示してください。
----------------------------------------------------*/
class Ex1_11_2 {
	public static void main (String[] args) {
		int number = 1;
		do {
			number = 1 + (int)(Math.random() * 6.0);
			System.out.println(number);
		} while (number != 6);
		System.out.println("6が出たのでを終了します");
		
		
		
		
		
		
		
		
		
	}
}
