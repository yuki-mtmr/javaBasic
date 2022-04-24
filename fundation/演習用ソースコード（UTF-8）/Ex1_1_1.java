/*-< 演習：Ex1_1_1 >---------------------------------
≪要件≫ ・投入された「10円玉」「50円玉」「100円玉」「500円玉」の合計金額を以下のように表示する
     「 ただいまの投入金額は(合計金額の値)円です 」
・「1円玉」「5円玉」が投入された場合は合計金額に含めず、「警告:1円玉は使えません」「警告:5円玉は使えません」と警告する ・硬貨としてふさわしくない値は合計金額に含めず、「警告:(入力された値)は硬貨として適切な値ではありません」と警告する
例)入力値777 → 「警告:777は硬貨として適切な値ではありません」
----------------------------------------------------*/
class Ex1_1_1 {
    public static void main (String[] args) {

        int sum = 0;

        for (String arg: args) {
            int coin = Integer.parseInt(arg);
            switch (coin) {
                case 1:
                    System.out.println("警告：1円玉は使えません");
                    break;
                case 5:
                    System.out.println("警告：5円玉は使えません");
                    break;
                case 10:
                case 50:
                case 100:
                case 500:
                    sum += coin;
                    break;
                default:
                    System.out.println(arg + "は硬貨として適切な値ではありません");
            }
        }
        System.out.println("ただいまの投入金額は" + sum + "円です");
    }
}
