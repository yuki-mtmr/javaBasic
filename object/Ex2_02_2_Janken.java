class Ex2_02_2_Janken {

    //定数
    private static final String HAND_G = "グー";
    private static final String HAND_C = "チョキ";
    private static final String HAND_P = "パー";

    public static void main (String[] args) {

        //<シナリオ1>
        //コマンドライン引数より3つの文字列を受け取る。 (ジャンケンを行う2名のプレイヤー及び審判の名前として利用)
        String player1 = args[0];
        String player2 = args[1];
        String judge = args[2];

        //<シナリオ2>
        //2名のプレイヤー及び審判を場に登場させる。(インスタンス化する) インスタンス化の際はコマンドライン引数で受け取った文字列をそれぞれ コンストラクタに渡す。
        Ex2_02_2_Human p1 = new Ex2_02_2_Human(player1);
        Ex2_02_2_Human p2 = new Ex2_02_2_Human(player2);
        Ex2_02_2_Human j = new Ex2_02_2_Human(judge);

        //<シナリオ3>
        // それぞれのプレイヤーに手を握らせる。 ※握らせる前に「じゃんけん・・・ぽん!!!!!」と審判が言う。 ※それぞれのプレイヤーがどんな手を出したか、それぞれについて
        // 「 (nameの値) さんの手は( handStatus の値)でした!」と審判が言う。
        System.out.println(j.name + "「じゃんけん・・・ぽん!!!!!」");

        //それぞれのプレイヤーに手を握らせる
        p1.makeHandStatus();
        p2.makeHandStatus();

        //それぞれのプレイヤーがどんな手を出したかを確認する
        System.out.println(j.name + "「" + p1.name + "さんの手は" + p1.handStatus + "でした!」");
        System.out.println(j.name + "「" + p2.name + "さんの手は" + p2.handStatus + "でした!」");

        //<シナリオ4>
        //審判が勝敗を判定し、結果を言う。 ※はじめに「結果は・・・」と審判が言う。 ※あいこだった場合は「あいこ!勝負つかず!」と審判が言う。 ※あいこでない場合は「(nameの値)さんの勝利!」と審判が言う。
        System.out.println(j.name + "「結果は・・・」");
        judge(p1, p2, j.name);
    }

    private static void judge(Ex2_02_2_Human p1, Ex2_02_2_Human p2, String judge) {
        if (p1.handStatus.equals(p2.handStatus)) {
            System.out.println(judge + "「あいこ!勝負つかず!」");
        } else if (p1.handStatus.equals(HAND_G) && p2.handStatus.equals(HAND_C)) {
            System.out.println(judge + "「" + p1.name + "さんの勝利!」");
        } else if (p1.handStatus.equals(HAND_C) && p2.handStatus.equals(HAND_P)) {
            System.out.println(judge + "「" + p1.name + "さんの勝利!」");
        } else if (p1.handStatus.equals(HAND_P) && p2.handStatus.equals(HAND_G)) {
            System.out.println(judge + "「" + p1.name + "さんの勝利!」");
        } else {
            System.out.println(judge + "「" + p2.name + "さんの勝利!」");
        }
    }
}
