class Ex2_01_1_Janken {
    public static void main (String[] args) {

        //定数
        final String HAND_G = "グー";
        final String HAND_C = "チョキ";

        /*<シナリオ①>
         **コマンドライン引数より2つの文字列を受け取る
         **（ジャンケンを行う2名のプレイヤーの名前として利用）
         */
        String player1 = args[0];
        String player2 = args[1];

        /*<シナリオ②>
         **2名のプレイヤーを場に登場させる（インスタンス化する）
         */
        Ex2_02_1_Player p1 = new Ex2_02_1_Player(player1);
        Ex2_02_1_Player p2 = new Ex2_02_1_Player(player2);

        /*<シナリオ③>
         **それぞれのプレイヤーに手を握らせる
         */
        //握らせる前に「じゃんけん・・・ぽん！！！！！」というメッセージを画面に表示する
        System.out.println( "じゃんけん・・・ぽん！！！！！" );

        //それぞれのプレイヤーに手を握らせる
        p1.makeHandStatus();
        p2.makeHandStatus();

        //それぞれのプレイヤーがどんな手を出したかを確認する
        System.out.println( p1.name + "さんの手 : " + p1.handStatus );
        System.out.println( p2.name + "さんの手 : " + p2.handStatus );
    }
}
