import java.sql.Time;

public class CalcDailyWage {

    public static void main(String[] args) {

        // 計算用の数値を定数で用意
        final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
        final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
        final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算

        //バイト給与計算用定数
        final int SHORT_BREAK = 45;      // 小休憩の分換算;
        final int LONG_BREAK = 60;      // 大休憩の分換算;
        final int BREAK_TIME_THRESHOLD = 6 * 1000 * 60 * 60; // 6時間のミリ秒換算
        final int OVER_TIME_PAY_THRESHOLD = 8 * 1000 * 60 * 60; // 8時間のミリ秒換算

        // バイトの開始時間と終了時間をコマンドライン引数から受け取る
        Time startTime  = Time.valueOf(args[0]);
        Time finishTime = Time.valueOf(args[1]);

        // getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
        // ※getTime()メソッドの戻り値はlong型であることに注意
        long workingTime = finishTime.getTime() - startTime.getTime();

        // ミリ秒で取得した労働時間を○時間△分の形式に直す
        int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
        int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) ); // 分に換算

        // 出力
        if (workingTime < BREAK_TIME_THRESHOLD) {
            int wage = workingMin * (900 / 60);
            System.out.println("本日の給料は" + wage + "円です。");
        } else if (workingTime < OVER_TIME_PAY_THRESHOLD) {
            int wage = (workingMin - SHORT_BREAK) * (900 / 60);
            System.out.println("本日の給料は" + wage + "円です。");
        } else {
            workingMin -= LONG_BREAK;
            int overTimeWorkingMin = 0;
            if (workingMin - 8 * 60 > 0) {
                overTimeWorkingMin = (workingMin - 8 * 60);
            }
            int wage = ((workingMin - overTimeWorkingMin) * (900 / 60)) + (int)(overTimeWorkingMin * (900 * 1.25 / 60));
            System.out.println("本日の給料は" + wage + "円です。");
        }
    }
}
